package razdwatrzy.zzpj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import razdwatrzy.zzpj.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign,Long> {
  Iterable<Campaign> getActiveCampaignsByUserCampaignUserId(long userId);
}
