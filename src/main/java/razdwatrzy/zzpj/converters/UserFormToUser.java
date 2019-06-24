package razdwatrzy.zzpj.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import razdwatrzy.zzpj.form.UserForm;
import razdwatrzy.zzpj.model.User;

@Component
public class UserFormToUser implements Converter<UserForm, User> {
    @Override
    public User convert(UserForm userForm) {
        User user = new User();
        if (userForm.getId() != 0) {
            user.setId(userForm.getId());
        }
        user.setLogin(userForm.getLogin());
        user.setRegistrationTime(userForm.getRegistrationTime());
        user.setIsActiveted(userForm.getIsActivated());
        user.setIsBanned(userForm.getIsBanned());
        user.setLastLogin(userForm.getLastLogin());
        return user;
    }
}
