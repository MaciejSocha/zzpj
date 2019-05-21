package razdwatrzy.zzpj.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String login;

    @Column
    private Date registrationTime;

    @Column
    private Boolean isActiveted;

    @Column
    private Boolean isBanned;

    @Column
    private Date lastLogin;

}
