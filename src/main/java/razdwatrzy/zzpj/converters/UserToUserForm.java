package razdwatrzy.zzpj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import razdwatrzy.zzpj.form.UserForm;
import razdwatrzy.zzpj.model.User;

@Component
public class UserToUserForm implements Converter<User, UserForm> {
    @Override
    public UserForm convert(User user) {
        UserForm userForm = new UserForm();
        userForm.setId(user.getId());
        userForm.setLogin(user.getLogin());
        userForm.setRegistrationTime(user.getRegistrationTime());
        userForm.setIsActivated(user.getIsActiveted());
        userForm.setIsBanned(user.getIsBanned());
        userForm.setLastLogin(user.getLastLogin());
        return userForm;
    }
}
