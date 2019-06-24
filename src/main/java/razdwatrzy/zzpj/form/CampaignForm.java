package razdwatrzy.zzpj.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CampaignForm {
    private long id;
    private UserCampaignForm userCampaignForm;
    private int points;
    private int pointsToWin;
    private Boolean isFinished;
    private String title;
    private String shortDescription;
    private String bgIMG;
    private String profileIMG;
    private Date endDate;

    public CampaignForm() {
    }
}
