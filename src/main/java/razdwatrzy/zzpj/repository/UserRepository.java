package razdwatrzy.zzpj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import razdwatrzy.zzpj.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> getUserByUserCredentialsEmail(String email);
}
