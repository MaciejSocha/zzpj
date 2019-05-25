package razdwatrzy.zzpj.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "campaign")
    private UserCampaign userCampaign;

    @NotNull
    @Column
    private int points;

    @NotNull
    @Column
    private int pointsToWin;

    @NotNull
    @Column
    private Boolean isFinished;

    @NotNull
    @Size(max = 16)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 32)
    @Column
    private String shortDescription;

    @NotNull
    @Size(max = 128)
    @Column
    private String description;

    //url
    @NotNull
    @Column
    private String bgIMG;

    //url
    @NotNull
    @Column
    private String profileIMG;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column
    private Date endDate;

    public Campaign() {

    }

    public Campaign(UserCampaign userCampaign, @NotNull int points, @NotNull int pointsToWin, @NotNull Boolean isFinished, @NotNull @Size(max = 16) String title, @NotNull @Size(max = 32) String shortDescription, @NotNull @Size(max = 128) String description, @NotNull String bgIMG, @NotNull String profileIMG, @NotNull Date endDate) {
        this.userCampaign = userCampaign;
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
