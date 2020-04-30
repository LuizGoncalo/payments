package br.com.luizgoncalo.paymentreceivable.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
