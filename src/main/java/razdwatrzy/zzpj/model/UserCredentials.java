package razdwatrzy.zzpj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @Setter
    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    @NotNull
    @Column
    private String password;

    public UserCredentials() {

    }

    public UserCredentials(User user, @NotNull @Email String email, @NotNull String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }
}
