package dev.hend.MyMoneyService.incomepayment.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.incomepayment.model.IncomePayment;

@Repository
public interface IncomePaymentRepository extends CrudRepository<IncomePayment, UUID> {

    List<IncomePayment> findAllByDateOfPaymentBetween(LocalDate startDate, LocalDate endDate);
}
