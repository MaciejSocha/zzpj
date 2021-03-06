package razdwatrzy.zzpj.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import razdwatrzy.zzpj.exceptions.ForbiddenException;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.model.UserCampaign;
import razdwatrzy.zzpj.model.UserCredentials;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.Optional;

@Repository
@Data
public class Queries {
    final CampaignRepository campaignRepository;
    final UserRepository userRepository;
    final UserCampaignRepository userCampaignRepository;
    final UserCredentialsRepository userCredentialsRepository;

    public Queries(CampaignRepository campaignRepository, UserRepository userRepository, UserCampaignRepository userCampaignRepository, UserCredentialsRepository userCredentialsRepository) {
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
        this.userCampaignRepository = userCampaignRepository;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    public User addUser(String login, String email, String password) {
        User user = User.builder().isBanned(false).login(login).isActiveted(true).registrationTime(new Date()).lastLogin(new Date()).build();
        UserCredentials credentials = new UserCredentials(user, email, password);

        //Cascades to credentials
        userRepository.save(user);
        userCredentialsRepository.save(credentials);
        return user;
    }

    public User getUser(String email, String password) {
        UserCredentials userCredentials = userCredentialsRepository.getUserCredentialsByEmailAndPassword(email, password);
        if (userCredentials == null) {
            throw new ForbiddenException("Wrong credentials!");
        }
        return userCredentials.getUser();
    }

    public Campaign addCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
        return campaign;
    }

    public User getUserByEmail(String email) throws IllegalArgumentException {
        try {
            return userRepository.getUserByUserCredentialsEmail(email).get(0);
        } catch (Exception e) {
            throw new IllegalArgumentException("There are no users with given email!");
        }
    }

    public User getUserById(long id) throws IllegalArgumentException {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new IllegalArgumentException("There are no users with id=" + id + "!"));
    }

    public Campaign getCampaignById(long id) throws IllegalArgumentException {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        return campaign.orElseThrow(() -> new IllegalArgumentException("There are no campaigns with id=" + id + "!"));
    }

    public List<Campaign> getCampaigns(int count) {
        List<Long> ids = StreamSupport.stream(campaignRepository.findAll().spliterator(), false).map(Campaign::getId).collect(Collectors.toList());
        Collections.shuffle(ids);
        return ids.subList(0, count).stream().map(x -> campaignRepository.findById(x).get()).collect(Collectors.toList());
    }


    public void followCampaign(Long campaignID, Long userID, Long parentID) throws IllegalArgumentException {
        Campaign campaign = getCampaignById(campaignID);
        User user = getUserById(userID);
        User parent = getUserById(parentID);
        userCampaignRepository.save(new UserCampaign(campaign, user, parent, 0));

        UserCampaign userCampaign;
        long currentUser = parentID;
        if (!parentID.equals(userID)) {
            for (int i = 0; i < 5; i++) {
                userCampaign = userCampaignRepository.getUserCampaignByCampaignIdAndUserId(campaignID, currentUser);
                if (userCampaign != null) {
                    campaign.setPoints((int) (campaign.getPoints() + 16 * (float) Math.pow(1 / 2, i)));
                    campaignRepository.save(campaign);
                    userCampaign.setPoints((int) (userCampaign.getPoints() + 16 * (float) Math.pow(1 / 2, i)));
                    userCampaignRepository.save(userCampaign);
                    currentUser = userCampaign.getUser().getId();
                }
            }
        }
    }
}

