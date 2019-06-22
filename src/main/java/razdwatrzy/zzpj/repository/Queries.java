package razdwatrzy.zzpj.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.model.UserCredentials;

import java.util.Date;
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
    }

    public void addCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
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


}
