package razdwatrzy.zzpj.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.model.UserCredentials;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class Queries {
    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    UserRepository userRepository;


    public void addUser(String login, String email, String password){
        User user = new User(login,null,new Date(), true, false, new Date());
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

    public List<Campaign> getCampaigns(int count){
        List<Long> ids = StreamSupport.stream(campaignRepository.findAll().spliterator(), false).map(Campaign::getId).collect(Collectors.toList());
        Collections.shuffle(ids);
        return ids.subList(0,count).stream().map(x->campaignRepository.findById(x).get()).collect(Collectors.toList());
    }


}
