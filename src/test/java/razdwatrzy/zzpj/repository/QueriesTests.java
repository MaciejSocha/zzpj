package razdwatrzy.zzpj.repository;

import org.assertj.core.util.IterableUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.model.UserCampaign;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class QueriesTests {
    @Autowired
    Queries queries;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserCampaignRepository userCampaignRepository;

    @Before
    public void clearDb(){
        userRepository.deleteAll();
        campaignRepository.deleteAll();
        userCampaignRepository.deleteAll();
    }

    @Test
    public void addUser(){
        long countBeforeQuery = userRepository.count();
        queries.addUser("Yenj", "123@gmail.com","hidden");
        long countAfterQuery = userRepository.count();
        assertEquals( 1, countAfterQuery - countBeforeQuery);
    }

    @Test
    public void addCampaign(){
        Campaign campaign = new Campaign(null,100,1000,false,"Camp","abc",
                "abc", "img", "img", new Date());

        long countBeforeQuery = campaignRepository.count();
        campaignRepository.save(campaign);
        long countAfterQuery = campaignRepository.count();
        assertEquals(1, countAfterQuery - countBeforeQuery);

    }

    @Test
    public void getCampaigns(){
        Campaign campaign1 = new Campaign(null,100,1000,false,"Campaign1","abc",
                "abc", "img", "img", new Date());


        Campaign campaign2 = new Campaign(null,100,1000,false,"Campaign2","abc",
                "abc", "img", "img", new Date());


        Campaign campaign3 = new Campaign(null,100,1000,false,"Campaign3","abc",
                "abc", "img", "img", new Date());


        Campaign campaign4 = new Campaign(null,100,1000,false,"Campaign4","abc",
                "abc", "img", "img", new Date());


        Campaign campaign5 = new Campaign(null,100,1000,false,"Campaign5","abc",
                "abc", "img", "img", new Date());



        queries.addCampaign(campaign1);
        queries.addCampaign(campaign2);
        queries.addCampaign(campaign3);
        queries.addCampaign(campaign4);
        queries.addCampaign(campaign5);

        //Check if everything was cleared beforehand
        assertEquals(campaignRepository.count(), 5);

        List<Campaign> campaigns = queries.getCampaigns(2);
        assertEquals( 2, campaigns.size());

    }

    @Test
    public void getUserByEmail(){
        queries.addUser("Yenj", "123@gmail.com","hidden");
        User user = queries.getUserByEmail("123@gmail.com");
        assertEquals("Yenj", user.getLogin());
    }


    @Test
    public void getUserById(){
        User user = queries.addUser("Yenj", "123@gmail.com", "hidden");
        User user1 = queries.getUserById(user.getId());
        assertEquals(user.getId(), user1.getId());
        assertEquals(user.getLogin(), user1.getLogin());

    }

    @Test
    public void getCampaignById(){
        Campaign campaign1 = new Campaign(null,100,1000,false,"Campaign1","abc",
                "abc", "img", "img", new Date());

        queries.addCampaign(campaign1);

        Campaign campaign2 = queries.getCampaignById(campaign1.getId());
        assertEquals(campaign1.getId(), campaign2.getId());
    }

    @Test
    public void getActiveCampaignsByUserId(){
        User user = queries.addUser("Yenj", "123@gmail.com","hidden");
        User parent = queries.addUser("Yenj", "123@gmail.com","hidden");


        Campaign campaign1 = new Campaign(null,100,1000,false,"Campaign1","abc",
                "abc", "img", "img", new Date());


        Campaign campaign2 = new Campaign(null,100,1000,true,"Campaign2","abc",
                "abc", "img", "img", new Date());


        Campaign campaign3 = new Campaign(null,100,1000,false,"Campaign3","abc",
                "abc", "img", "img", new Date());


        UserCampaign userCampaign1 = new UserCampaign(campaign1, user, parent, 1000);
        campaign1.setUserCampaign(userCampaign1);

//
//        UserCampaign userCampaign2 = new UserCampaign(campaign2, user, 1L, 1000);
//        campaign2.setUserCampaign(userCampaign2);

        //        UserCampaign userCampaign3 = new UserCampaign(campaign3, user, 1L, 1000);
//        campaign3.setUserCampaign(userCampaign3);

        queries.addCampaign(campaign1);
        queries.addCampaign(campaign2);
        queries.addCampaign(campaign3);


        assertEquals(1, userRepository.count());
        assertEquals(3, campaignRepository.count());
        assertEquals(1, userCampaignRepository.count());
//
////        Iterable<Campaign> activeCampaignsByUserId = queries.getActiveCampaignsByUserId(user.getId());
////        assertEquals(2, IterableUtil.sizeOf(activeCampaignsByUserId));
//
    }

}
