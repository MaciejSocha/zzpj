package razdwatrzy.zzpj.model;

import javax.persistence.*;

@Entity
@Table(name = "bonuses")
public class Bonuses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int pointsToGet;

    //url
    @Column
    private String icon;
}
