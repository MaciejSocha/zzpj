package razdwatrzy.zzpj.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentialsForm {
    private long id;
    private UserForm userForm;
    private String email;
    private String password;

    public UserCredentialsForm() {
    }
}
