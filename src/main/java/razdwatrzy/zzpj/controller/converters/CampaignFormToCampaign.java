package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;

public class CampaignFormToCampaign implements Converter<CampaignForm, Campaign> {
    @Override
    public Campaign convert(CampaignForm campaignForm) {
        return null;
    }
}
