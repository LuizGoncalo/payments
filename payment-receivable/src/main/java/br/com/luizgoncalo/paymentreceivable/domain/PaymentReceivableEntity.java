package br.com.luizgoncalo.paymentreceivable.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_receivable")
public class PaymentReceivableEntity {

    @Id
    @Column(name = "receivable_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "payment_identification")
    private Long paymentIdentification;

    @Enumerated
    @Column(name = "status")
    private ReceivableStatusEnum status;

}
