package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.UserForm;
import razdwatrzy.zzpj.model.User;

public class UserToUserForm implements Converter<User, UserForm> {
    @Override
    public UserForm convert(User user) {
        UserForm userForm = new UserForm();
        userForm.setId(user.getId());
        userForm.setLogin(user.getLogin());
        userForm.setUserCredentialsForm(new UserCredentialsToUserCredentialsForm().convert(user.getUserCredentials()));
        userForm.setRegistrationTime(user.getRegistrationTime());
        userForm.setIsActivated(user.getIsActiveted());
        userForm.setIsBanned(user.getIsBanned());
        userForm.setLastLogin(user.getLastLogin());
        return userForm;
    }
}
