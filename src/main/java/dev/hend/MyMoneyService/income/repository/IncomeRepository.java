package dev.hend.MyMoneyService.income.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.income.model.Income;

@Repository
public interface IncomeRepository extends CrudRepository<Income, UUID> {}
