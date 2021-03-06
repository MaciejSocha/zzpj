package razdwatrzy.zzpj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_campaigns")
public class UserCampaign {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_id", nullable = false)
    private User parent;


    @Getter
    @Setter
    @NotNull
    @Column
    private int points;

    public UserCampaign() {

    }

    public UserCampaign(Campaign campaignID, User userID, User parent, @NotNull int points) {
        this.campaign = campaignID;
        this.user = userID;
        this.parent = parent;
        this.points = points;
    }
}
