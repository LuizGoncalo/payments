package br.com.luizgoncalo.paymentreceivable.repository;

import br.com.luizgoncalo.paymentreceivable.domain.PaymentReceivableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReceivableRepository extends JpaRepository<PaymentReceivableEntity, Long> {
}
