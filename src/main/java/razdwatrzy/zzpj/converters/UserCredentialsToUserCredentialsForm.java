package razdwatrzy.zzpj.converters;


import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.UserCredentialsForm;
import razdwatrzy.zzpj.model.UserCredentials;

public class UserCredentialsToUserCredentialsForm implements Converter<UserCredentials, UserCredentialsForm> {

    @Override
    public UserCredentialsForm convert(UserCredentials userCredentials) {
        UserCredentialsForm userCredentialsForm = new UserCredentialsForm();
        userCredentialsForm.setId(userCredentials.getId());
        userCredentialsForm.setUserForm(new UserToUserForm().convert(userCredentials.getUser()));
        userCredentialsForm.setEmail(userCredentials.getEmail());
        userCredentialsForm.setPassword(userCredentials.getPassword());
        return userCredentialsForm;
    }
}
