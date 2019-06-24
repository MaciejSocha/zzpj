package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.UserCampaignForm;
import razdwatrzy.zzpj.model.UserCampaign;

public class UserCampaignFormToUserCampaign implements Converter<UserCampaignForm, UserCampaign> {
    @Override
    public UserCampaign convert(UserCampaignForm userCampaignForm) {
        UserCampaign userCampaign = new UserCampaign();
        userCampaign.setId(userCampaignForm.getId());
        userCampaign.setCampaign(new CampaignFormToCampaign().convert(userCampaignForm.getCampaignForm()));
        userCampaign.setUser(new UserFormToUser().convert(userCampaignForm.getUserForm()));
        userCampaign.setParent(new UserFormToUser().convert(userCampaignForm.getParent()));
        userCampaign.setPoints(userCampaignForm.getPoints());
        return null;
    }
}
