package razdwatrzy.zzpj.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.model.UserCredentials;

import java.util.Date;
import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign,Long> {
    @Query("from Campaign c where isFinished=FALSE ")
//    and id IN (select uc.id from UserCampaign where user.id = :userId and campaign.id = c.id)
    Iterable<Campaign> getActiveCampaignsByUserId(long userId);

}
