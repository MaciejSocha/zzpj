package razdwatrzy.zzpj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import razdwatrzy.zzpj.model.UserCampaign;

import java.util.List;

public interface UserCampaignRepository extends JpaRepository<UserCampaign, Long> {
    UserCampaign getUserCampaignByCampaignIdAndUserId(long campaign_id, long user_id);
}
