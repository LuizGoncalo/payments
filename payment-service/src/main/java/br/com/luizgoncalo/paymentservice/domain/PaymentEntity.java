package br.com.luizgoncalo.paymentservice.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    @Column(name = "payment_identification", nullable = false)
    private Long paymentIdentification;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PaymentStatusEnum status;

    @CreationTimestamp
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

}
