package razdwatrzy.zzpj.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCampaignForm {
    private long id;
    private CampaignForm campaignForm;
    private UserForm userForm;
    private UserForm parent;
    private int points;

    public UserCampaignForm() {
    }
}
