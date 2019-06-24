package razdwatrzy.zzpj.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserForm {
    private long id;
    private String login;
    private Date registrationTime;
    private Boolean isActivated;
    private Boolean isBanned;
    private Date lastLogin;

    public UserForm() {
    }
}
