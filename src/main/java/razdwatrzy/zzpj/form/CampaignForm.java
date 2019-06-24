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
    private String description;
    private String bgIMG;
    private String profileIMG;
    private Date endDate;

    public CampaignForm() {
    }

    public CampaignForm(UserCampaignForm userCampaignForm, int points, int pointsToWin, Boolean isFinished, String title, String shortDescription, String description, String bgIMG, String profileIMG, Date endDate) {
        this.userCampaignForm = userCampaignForm;
        this.points = points;
        this.pointsToWin = pointsToWin;
        this.isFinished = isFinished;
        this.title = title;
        this.shortDescription = shortDescription;
        this.description = description;
        this.bgIMG = bgIMG;
        this.profileIMG = profileIMG;
        this.endDate = endDate;
    }
}
