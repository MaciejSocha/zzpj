package razdwatrzy.zzpj.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bonuses")
public class Bonus {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @Getter
    @Setter
    @NotNull
    @Size(max = 16)
    @Column(unique = true)
    private String title;

    @Getter
    @Setter
    @NotNull
    @Size(max = 128)
    @Column
    private String description;

    @Getter
    @Setter
    @NotNull
    @Column
    private int pointsToGet;

    //url
    @Getter
    @Setter
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
