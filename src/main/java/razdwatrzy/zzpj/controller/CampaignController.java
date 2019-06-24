package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import razdwatrzy.zzpj.converters.CampaignFormToCampaign;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.repository.Queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CampaignController {
    @Autowired
    Queries DataAccess;
    //TODO Add sign in and sign up

    @GetMapping("campaign/{campaign_id}")
    public Campaign getCampaign(@PathVariable Long campaign_id){
        Campaign campaign = DataAccess.getCampaignById(campaign_id);
        return campaign;
    }
    @PostMapping("addcampaign")
    public Campaign addCampaign(@RequestBody CampaignForm newCampaign){
        CampaignForm campaignForm = new CampaignForm(
                newCampaign.getUserCampaignForm(),
                newCampaign.getPoints(),
                newCampaign.getPointsToWin(),
                newCampaign.getIsFinished(),
                newCampaign.getTitle(),
                newCampaign.getShortDescription(),
                newCampaign.getDescription(),
                newCampaign.getBgIMG(),
                newCampaign.getProfileIMG(),
                newCampaign.getEndDate());
        Campaign campaign = new CampaignFormToCampaign().convert(campaignForm);
        DataAccess.addCampaign(campaign);
        return campaign;
    }
    //TODO use Real Query
    @GetMapping("campaigns/{numberOfCampaigns}")
    public List<Campaign> getCampaignsForMainPage(@PathVariable int numberOfCampaigns){
        {
            Iterable<Campaign> result = DataAccess.getCampaignRepository().findAll();
            List<Campaign> CampaignsList = new ArrayList<Campaign>();
            result.forEach(CampaignsList::add);
            Collections.shuffle(CampaignsList);
            if(numberOfCampaigns >= CampaignsList.size()){
                return CampaignsList;
            }else {
                return new ArrayList<>(CampaignsList.subList(0,numberOfCampaigns));
            }
        }
    }
}
