package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import razdwatrzy.zzpj.model.User;
import razdwatrzy.zzpj.repository.Queries;
import razdwatrzy.zzpj.repository.UserRepository;

import java.util.Optional;

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
}
