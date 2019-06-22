package razdwatrzy.zzpj.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.model.User;
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
    final
    CampaignRepository campaignRepository;

    final
    UserRepository userRepository;

    public Queries(CampaignRepository campaignRepository, UserRepository userRepository) {
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
    }

    public void addUser(String login, String email, String password) {
        User user = User.builder().isBanned(false).login(login).isActiveted(true).registrationTime(new Date()).lastLogin(null).build();
        UserCredentials credentials = new UserCredentials(user, email, password);
        user.setUserCredentials(credentials);

        //Cascades to credentials
        userRepository.save(user);
        return user;
    }

    public Campaign addCampaign(Campaign campaign){
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
        try {
            Optional<User> user = userRepository.findById(id);
            return user.orElse(null); //TODO should throw custom exception
        } catch (Exception e) {
            throw new IllegalArgumentException("There are no users with given id!");
        }
    }

    public Campaign getCampaignById(long id) throws IllegalArgumentException {
        try {
            Optional<Campaign> campaign = campaignRepository.findById(id);
            return campaign.orElse(null); //TODO should throw custom exception
        } catch (Exception e) {
            throw new IllegalArgumentException("There are no campaigns with given id!");
        }
    }

    public List<Campaign> getCampaigns(int count){
        List<Long> ids = StreamSupport.stream(campaignRepository.findAll().spliterator(), false).map(Campaign::getId).collect(Collectors.toList());
        Collections.shuffle(ids);
        return ids.subList(0,count).stream().map(x->campaignRepository.findById(x).get()).collect(Collectors.toList());
    }


    public Iterable<Campaign> getActiveCampaignsByUserId(long id){
        return campaignRepository.getActiveCampaignsByUserId(id);
    }

}
