package razdwatrzy.zzpj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "campaigns")
public class Campaign {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "campaign")
    private UserCampaign userCampaign;

    @Getter
    @Setter
    @NotNull
    @Column
    private int points;

    @Getter
    @Setter
    @NotNull
    @Column
    private int pointsToWin;

    @Getter
    @Setter
    @NotNull
    @Column
    private Boolean isFinished;

    @Getter
    @Setter
    @NotNull
    @Size(max = 16)
    @Column(unique = true)
    private String title;

    @Getter
    @Setter
    @NotNull
    @Size(max = 32)
    @Column
    private String shortDescription;

    @Getter
    @Setter
    @NotNull
    @Size(max = 128)
    @Column
    private String description;

    //url
    @Getter
    @Setter
    @NotNull
    @Column
    private String bgIMG;

    //url
    @Getter
    @Setter
    @NotNull
    @Column
    private String profileIMG;

    @Getter
    @Setter
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