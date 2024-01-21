package dev.hend.MyMoneyService.deposit.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.deposit.model.Deposit;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, UUID> {

    List<Deposit> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}
