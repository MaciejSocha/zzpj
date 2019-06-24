package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import razdwatrzy.zzpj.converters.CampaignFormToCampaign;
import razdwatrzy.zzpj.converters.CampaignToCampaignForm;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;
import razdwatrzy.zzpj.repository.Queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CampaignController {
    private CampaignFormToCampaign campaignFormToCampaign;
    private CampaignToCampaignForm campaignToCampaignForm;


    @Autowired
    Queries DataAccess;
    //TODO Add sign in and sign up

    @GetMapping("campaign/{campaign_id}")
    public CampaignForm getCampaignForm(@PathVariable Long campaign_id) {
        return campaignToCampaignForm.convert(DataAccess.getCampaignById(campaign_id));
    }

    @PostMapping("addcampaign")
    public Campaign addCampaign(@RequestBody CampaignForm campaignForm) {
        Campaign campaign = campaignFormToCampaign.convert(campaignForm);
        DataAccess.addCampaign(campaign);
        return campaign;
    }

    //TODO use Real Query
    @GetMapping("campaigns/{numberOfCampaigns}")
    public List<CampaignForm> getCampaignsForMainPage(@PathVariable int numberOfCampaigns) {
        {
            List<Campaign> selectedCampaigns;
            Iterable<Campaign> result = DataAccess.getCampaignRepository().findAll();
            List<Campaign> CampaignsList = new ArrayList<>();
            result.forEach(CampaignsList::add);
            Collections.shuffle(CampaignsList);
            if (numberOfCampaigns >= CampaignsList.size()) {
                selectedCampaigns = CampaignsList;
            } else {
                selectedCampaigns = new ArrayList<>(CampaignsList.subList(0, numberOfCampaigns));
            }
            return selectedCampaigns.stream().map(c -> campaignToCampaignForm.convert(c)).collect(Collectors.toList());
        }
    }

    @Autowired
    public void setCampaignFormToCampaign(CampaignFormToCampaign campaignFormToCampaign) {
        this.campaignFormToCampaign = campaignFormToCampaign;
    }

    @Autowired
    public void setCampaignToCampaignForm(CampaignToCampaignForm campaignToCampaignForm) {
        this.campaignToCampaignForm = campaignToCampaignForm;
    }
}
