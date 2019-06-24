package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.UserCampaignForm;
import razdwatrzy.zzpj.model.UserCampaign;

public class UserCampaignToUserCampaignForm implements Converter<UserCampaign, UserCampaignForm> {
    @Override
    public UserCampaignForm convert(UserCampaign userCampaign) {
        UserCampaignForm userCampaignForm = new UserCampaignForm();
        userCampaignForm.setId(userCampaign.getId());
        userCampaignForm.setCampaignForm(new CampaignToCampaignForm().convert(userCampaign.getCampaign()));
        userCampaignForm.setUserForm(new UserToUserForm().convert(userCampaign.getUser()));
        userCampaignForm.setParent(new UserToUserForm().convert(userCampaign.getParent()));
        userCampaignForm.setPoints(userCampaign.getPoints());
        return userCampaignForm;
    }
}
