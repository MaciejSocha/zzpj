package razdwatrzy.zzpj.model;

import javax.persistence.*;

@Entity
@Table(name = "bonuses")
public class Bonuses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long campaignID;

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
