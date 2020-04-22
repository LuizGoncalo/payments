package br.com.luizgoncalo.paymentservice.repository;

import br.com.luizgoncalo.paymentservice.domain.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
