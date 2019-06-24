package razdwatrzy.zzpj.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;

public class CampaignFormToCampaign implements Converter<CampaignForm, Campaign> {
    @Override
    public Campaign convert(CampaignForm campaignForm) {
        Campaign campaign = new Campaign();
        if (campaignForm.getId() != 0) {
            campaign.setId(campaignForm.getId());
        }
        campaign.setUserCampaign(new UserCampaignFormToUserCampaign().convert(campaignForm.getUserCampaignForm()));
        campaign.setPoints(campaignForm.getPoints());
        campaign.setPointsToWin(campaignForm.getPointsToWin());
        campaign.setIsFinished(campaignForm.getIsFinished());
        campaign.setTitle(campaignForm.getTitle());
        campaign.setShortDescription(campaignForm.getShortDescription());
        campaign.setDescription(campaignForm.getDescription());
        campaign.setBgIMG(campaignForm.getBgIMG());
        campaign.setProfileIMG(campaignForm.getProfileIMG());
        campaign.setEndDate(campaignForm.getEndDate());
        return campaign;
    }
}
