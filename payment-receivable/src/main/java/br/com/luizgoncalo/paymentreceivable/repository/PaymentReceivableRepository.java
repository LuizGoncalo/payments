package br.com.luizgoncalo.paymentreceivable.repository;

import br.com.luizgoncalo.paymentreceivable.domain.PaymentReceivableEntity;
import br.com.luizgoncalo.paymentreceivable.domain.ReceivableStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReceivableRepository extends JpaRepository<PaymentReceivableEntity, Long> {

    @Query("UPDATE payment_receivable p SET p.status = :status WHERE p.cpf = :cpf")
    PaymentReceivableEntity updateStatusReceivable(@Param("cpf") String cpf, @Param("status") ReceivableStatusEnum status);

}
