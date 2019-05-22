package razdwatrzy.zzpj.model;

import javax.persistence.*;

@Entity
@Table(name = "user_campaigns")
public class UserCampaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column
    private long parentID;

    @Column
    private int points;
}
