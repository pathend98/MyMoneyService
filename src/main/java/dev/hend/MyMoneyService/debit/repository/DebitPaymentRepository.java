package dev.hend.MyMoneyService.debit.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.debit.model.DebitPayment;

@Repository
public interface DebitPaymentRepository extends CrudRepository<DebitPayment, UUID> {

    List<DebitPayment> findAllByDateGreaterThanEqualAndDateLessThanEqual(LocalDate startDate, LocalDate endDate);
}
