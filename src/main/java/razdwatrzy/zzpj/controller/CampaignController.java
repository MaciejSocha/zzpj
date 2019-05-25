package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.repository.Queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    //TODO use Real Query
    @GetMapping("campaign/{numberOfCampaigns}")
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
