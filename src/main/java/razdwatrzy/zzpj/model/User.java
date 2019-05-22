package razdwatrzy.zzpj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter @Setter
@Table(name ="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Name")
    private @NonNull String name;
    @Column(name = "Surname")
    private @NonNull String Surname;
    @Column(name = "e-mail")
    private @NonNull String email;
}
