package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.UserForm;
import razdwatrzy.zzpj.model.User;

public class UserFormToUser implements Converter<UserForm, User> {
    @Override
    public User convert(UserForm userForm) {
        User user = new User();
        user.setId(userForm.getId());
        user.setLogin(userForm.getLogin());
        user.setUserCredentials(new UserCredentialsFormToUserCredentials().convert(userForm.getUserCredentialsForm()));
        user.setRegistrationTime(userForm.getRegistrationTime());
        user.setIsActiveted(userForm.getIsActivated());
        user.setIsBanned(userForm.getIsBanned());
        user.setLastLogin(userForm.getLastLogin());
        return user;
    }
}
