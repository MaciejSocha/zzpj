package razdwatrzy.zzpj.model;

import javax.persistence.*;

@Entity
@Table(name = "user_campaigns")
public class UserCampaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long campaignID;

    @Column
    private long userID;

    @Column
    private long parentID;

    @Column
    private int points;
}
