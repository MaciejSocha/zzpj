package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import razdwatrzy.zzpj.controller.DataHolders.SignInEmailData;
import razdwatrzy.zzpj.controller.DataHolders.SignupData;
import razdwatrzy.zzpj.converters.UserFormToUser;
import razdwatrzy.zzpj.converters.UserToUserForm;
import razdwatrzy.zzpj.form.UserForm;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.repository.Queries;

@RestController
public class UserController {
    private UserFormToUser userFormToUser;
    private UserToUserForm userToUserForm;


    @Autowired
    Queries DataAccess;
    //TODO Add sign in and sign up

    @GetMapping("user/{user_id}")
    public UserForm getUser(@PathVariable Long user_id){
        return userToUserForm.convert(DataAccess.getUserById(user_id));
    }

    //TODO co z tym zrobić?
    @PostMapping("signup")
    public User addUser(@RequestBody SignupData dataHolder){
        User newUser = DataAccess.addUser(dataHolder.getLogin(),dataHolder.getEmail(),dataHolder.getPassword());
        return newUser;
    }

    @PostMapping("signInWithEmail")
    public UserForm signInWithEmail(@RequestBody SignInEmailData dataHolder){
        return userToUserForm.convert(DataAccess.getUser(dataHolder.getEmail(), dataHolder.getPassword()));
    }

    @GetMapping("follow/{user_id}/{campaign_id}")
    public String getFollowLink(){
        return null;
    }

    @Autowired
    public void setUserFormToUser(UserFormToUser userFormToUser) {
        this.userFormToUser = userFormToUser;
    }

    @Autowired
    public void setUserToUserForm(UserToUserForm userToUserForm) {
        this.userToUserForm = userToUserForm;
    }
}
