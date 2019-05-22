package razdwatrzy.zzpj.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long campaignId;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "campaign")
    private UserCampaign userCampaign;

    @Column
    private int points;

    @Column
    private int pointsToWin;

    @Column
    private Boolean isFinished;

    @Column
    private String title;

    @Column
    private String shortDescription;

    @Column
    private String description;

    //url
    @Column
    private String bgIMG;

    //url
    @Column
    private String profileIMG;

    @Column
    private Date endDate;
}
