package razdwatrzy.zzpj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;

@Component
public class CampaignFormToCampaign implements Converter<CampaignForm, Campaign> {
    @Override
    public Campaign convert(CampaignForm campaignForm) {
        Campaign campaign = new Campaign();
        if (campaignForm.getId() != 0) {
            campaign.setId(campaignForm.getId());
        }
        campaign.setPoints(campaignForm.getPoints());
        campaign.setPointsToWin(campaignForm.getPointsToWin());
        campaign.setIsFinished(campaignForm.getIsFinished());
        campaign.setTitle(campaignForm.getTitle());
        campaign.setShortDescription(campaignForm.getShortDescription());
        campaign.setDescription(campaignForm.getDescription());
        campaign.setBgIMG(campaignForm.getBgIMG());
        campaign.setProfileIMG(campaignForm.getProfileIMG());
        campaign.setEndDate(campaignForm.getEndDate());
        campaign.setMovieKey(campaignForm.getMovieKey());

        return campaign;
    }
}
