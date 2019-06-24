package razdwatrzy.zzpj.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.UserCredentialsForm;
import razdwatrzy.zzpj.model.UserCredentials;

public class UserCredentialsFormToUserCredentials implements Converter<UserCredentialsForm, UserCredentials> {
    @Override
    public UserCredentials convert(UserCredentialsForm userCredentialsForm) {
        UserCredentials userCredentials = new UserCredentials();
        if (userCredentialsForm.getId() != 0) {
            userCredentials.setId(userCredentialsForm.getId());
        }
        userCredentials.setUser(new UserFormToUser().convert(userCredentialsForm.getUserForm()));
        userCredentials.setEmail(userCredentialsForm.getEmail());
        userCredentials.setPassword(userCredentialsForm.getPassword());
        return userCredentials;
    }
}
