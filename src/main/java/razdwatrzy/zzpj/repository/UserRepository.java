package razdwatrzy.zzpj.repository;

import org.springframework.data.repository.CrudRepository;

import razdwatrzy.zzpj.model.User;

import java.util.List;


public interface UserRepository extends CrudRepository<User,Long> {
    List<User> getUserByUserCredentialsEmail(String email);
}
