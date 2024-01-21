package dev.hend.MyMoneyService.debit.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.debit.model.Debit;

@Repository
public interface DebitRepository extends CrudRepository<Debit, UUID> {

    List<Debit> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}
