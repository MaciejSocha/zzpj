package razdwatrzy.zzpj.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
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

    @NotNull
    @Column
    private long parentID;

    @NotNull
    @Column
    private int points;

    public UserCampaign() {

    }

    public UserCampaign(Campaign campaign, User user, @NotNull long parentID, @NotNull int points) {
        this.campaign = campaign;
        this.user = user;
        this.parentID = parentID;
        this.points = points;
    }
}
