package razdwatrzy.zzpj.model;

import javax.persistence.*;

@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String userID;

    @Column
    private String email;

    @Column
    private String password;
}
