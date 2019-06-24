package razdwatrzy.zzpj.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BonusForm {
    private long id;
    private CampaignForm campaign;
    private String title;
    private String description;
    private int pointsToGet;
    private String icon;

    public BonusForm(){}
}
