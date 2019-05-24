package razdwatrzy.zzpj.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.model.UserCredentials;

import java.util.Date;

@Repository
public class Queries {
    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    UserRepository userRepository;


    public void addUser(String login, String email, String password){
        User user = User.builder().isBanned(false).login(login).isActiveted(true).registrationTime(new Date()).lastLogin(null).build();
        UserCredentials credentials = new UserCredentials(user,email,password);
        user.setUserCredentials(credentials);

        //Cascades to credentials
        userRepository.save(user);
    }

    public void addCampaign(Campaign campaign){
        campaignRepository.save(campaign);
    }

    public User getUserByEmail(String email) throws IllegalArgumentException{
        try{
            return userRepository.getUserByUserCredentialsEmail(email).get(0);
        }catch (Exception e){
            throw new IllegalArgumentException("There are no users with given email!");
        }
    }

    public User getUserById(long id) throws IllegalArgumentException{
        try{
            return userRepository.findById(id).get();
        }catch (Exception e){
            throw new IllegalArgumentException("There are no users with given id!");
        }
    }

    public Campaign getCampaignById(long id) throws IllegalArgumentException{
        try{
            return campaignRepository.findById(id).get();
        }catch (Exception e){
            throw new IllegalArgumentException("There are no campaigns with given id!");
        }
    }


}
