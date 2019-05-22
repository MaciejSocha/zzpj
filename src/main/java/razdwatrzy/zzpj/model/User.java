package razdwatrzy.zzpj.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column
    private String login;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private UserCredentials userCredentials;


    @Column
    private Date registrationTime;

    @Column
    private Boolean isActiveted;

    @Column
    private Boolean isBanned;

    @Column
    private Date lastLogin;

}
