package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import razdwatrzy.zzpj.controller.DataHolders.SignIn;
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

    @PostMapping("signUp")
    @ResponseStatus(HttpStatus.OK)
    public UserForm addUser(@RequestBody SignupData dataHolder){
        User newUser = DataAccess.addUser(dataHolder.getLogin(),dataHolder.getEmail(),dataHolder.getPassword());
        return userToUserForm.convert(newUser);
    }

    @PostMapping("signIn")
    @ResponseStatus(HttpStatus.OK)
    public UserForm signIn(@RequestBody SignIn dataHolder){
        return userToUserForm.convert(DataAccess.getUser(dataHolder.getEmail(), dataHolder.getPassword()));
    }

    @RequestMapping(path = "follow/{user_id}/{parent_id}/{campaign_id}")
    public String getFollowLink(@PathVariable("user_id") Long user_id,@PathVariable("parent_id") Long parent_id,@PathVariable("campaign_id") Long campaign_id){
        DataAccess.followCampaign(user_id,parent_id,campaign_id);
        return "ok";
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
