package dev.hend.MyMoneyService.incomepayment.model;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import dev.hend.MyMoneyService.income.model.Income;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "income_payment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IncomePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Income income;

    private Float value;
    private LocalDate dateOfPayment;
    private Boolean paid;
}
