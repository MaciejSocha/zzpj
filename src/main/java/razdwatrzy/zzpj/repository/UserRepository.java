package razdwatrzy.zzpj.repository;

import org.springframework.data.repository.CrudRepository;
import razdwatrzy.zzpj.model.Example;

public interface UserRepository extends CrudRepository<Example,Long> {
}
