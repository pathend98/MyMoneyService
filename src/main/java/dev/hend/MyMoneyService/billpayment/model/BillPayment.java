package dev.hend.MyMoneyService.billpayment.model;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bill_payment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID billId;
    private Float value;
    private LocalDate dateOfBill;
    private Boolean paid;
}
