package razdwatrzy.zzpj.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(max = 32)
    @Column(unique = true)
    private String login;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private UserCredentials userCredentials;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column
    private Date registrationTime;

    @NotNull
    @Column
    private Boolean isActiveted;

    @NotNull
    @Column
    private Boolean isBanned;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column
    private Date lastLogin;

    public User() {

    }

    public User(@NotNull @Size(max = 256) String login, UserCredentials userCredentials, @NotNull Date registrationTime, @NotNull Boolean isActiveted, @NotNull Boolean isBanned, @NotNull Date lastLogin) {
        this.login = login;
        this.userCredentials = userCredentials;
        this.registrationTime = registrationTime;
        this.isActiveted = isActiveted;
        this.isBanned = isBanned;
        this.lastLogin = lastLogin;
    }

    public User(Long id, String login, UserCredentials userCredentials, Date registrationTime, Boolean isActiveted, Boolean isBanned, Date lastLogin) {
        this.id = id;
        this.login = login;
        this.userCredentials = userCredentials;
        this.registrationTime = registrationTime;
        this.isActiveted = isActiveted;
        this.isBanned = isBanned;
        this.lastLogin = lastLogin;
    }
}