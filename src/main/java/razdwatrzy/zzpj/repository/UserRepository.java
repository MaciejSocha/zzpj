package razdwatrzy.zzpj.repository;

import org.springframework.data.repository.CrudRepository;
import razdwatrzy.zzpj.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
