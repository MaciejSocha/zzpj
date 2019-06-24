package razdwatrzy.zzpj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;

@Component
public class CampaignToCampaignForm implements Converter<Campaign, CampaignForm> {
    @Override
    public CampaignForm convert(Campaign campaign) {
        CampaignForm campaignForm = new CampaignForm();
        campaignForm.setPoints(campaign.getPoints());
        campaignForm.setPointsToWin(campaign.getPointsToWin());
        campaignForm.setIsFinished(campaign.getIsFinished());
        campaignForm.setTitle(campaign.getTitle());
        campaignForm.setShortDescription(campaign.getShortDescription());
        campaignForm.setDescription(campaign.getDescription());
        campaignForm.setBgIMG(campaign.getBgIMG());
        campaignForm.setProfileIMG(campaign.getProfileIMG());
        campaignForm.setEndDate(campaign.getEndDate());
        return campaignForm;
    }
}
