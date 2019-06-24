package razdwatrzy.zzpj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import razdwatrzy.zzpj.model.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
    UserCredentials getUserCredentialsByEmailAndPassword(String email, String password);
}
