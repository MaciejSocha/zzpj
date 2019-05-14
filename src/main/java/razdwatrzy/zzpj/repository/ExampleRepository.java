package razdwatrzy.zzpj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import razdwatrzy.zzpj.model.Example;

import java.util.List;

public interface ExampleRepository extends JpaRepository<Example, Long> {
    List<Example> findAll();
}
