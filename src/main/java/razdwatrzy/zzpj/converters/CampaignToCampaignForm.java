package razdwatrzy.zzpj.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.youtube.YouTubeService;

@Component
public class CampaignToCampaignForm implements Converter<Campaign, CampaignForm> {
    @Autowired
    YouTubeService youTubeService;

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
        campaignForm.setMovieKey(campaign.getMovieKey());
        campaignForm.setViewCount(youTubeService.getViewsCountForVideo(campaign.getMovieKey()));

        return campaignForm;
    }
}
