package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import razdwatrzy.zzpj.controller.DataHolders.SignupData;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.repository.Queries;

@RestController
public class UserControler {
    @Autowired
    Queries DataAccess;
    //TODO Add sign in and sign up

    @GetMapping("user/{user_id}")
    public User getUser(@PathVariable Long user_id){
        User user = DataAccess.getUserById(user_id);
        return user;
    }
    @PostMapping("signup")
    public User addUser(@RequestBody SignupData dataHolder){
        User newUser = DataAccess.addUser(dataHolder.getLogin(),dataHolder.getEmail(),dataHolder.getPassword());
        return newUser;

    }
    @GetMapping("follow/{user_id}/{campaign_id}")
    public String getFollowLink(){
        return null;
    }
}
