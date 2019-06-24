package razdwatrzy.zzpj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

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
