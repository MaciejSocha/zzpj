package razdwatrzy.zzpj.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bonuses")
public class Bonus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @NotNull
    @Size(max = 16)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 128)
    @Column
    private String description;

    @NotNull
    @Column
    private int pointsToGet;

    //url
    @NotNull
    @Column
    private String icon;

    public Bonus() {

    }

    public Bonus(Campaign campaign, @NotNull @Size(max = 16) String title, @NotNull @Size(max = 128) String description, @NotNull int pointsToGet, @NotNull String icon) {
        this.campaign = campaign;
        this.title = title;
        this.description = description;
        this.pointsToGet = pointsToGet;
        this.icon = icon;
    }
}
