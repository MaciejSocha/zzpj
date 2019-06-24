package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.CampaignForm;
import razdwatrzy.zzpj.model.Campaign;

public class CampaignToCampaignForm implements Converter<Campaign, CampaignForm> {
    @Override
    public CampaignForm convert(Campaign campaign) {
        return null;
    }
}
