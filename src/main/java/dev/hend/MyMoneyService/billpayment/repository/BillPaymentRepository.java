package dev.hend.MyMoneyService.billpayment.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.billpayment.model.BillPayment;

@Repository
public interface BillPaymentRepository extends CrudRepository<BillPayment, UUID> {

    List<BillPayment> findAllByDateOfBillBetween(LocalDate startDate, LocalDate endDate);
}
