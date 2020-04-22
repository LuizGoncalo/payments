package br.com.luizgoncalo.paymentuser.repository;

import br.com.luizgoncalo.paymentuser.domain.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.cpf = :cpf")
    Optional<UserEntity> findUserWithCpf(@Param("cpf") String cpf);

}
