package dev.hend.MyMoneyService.bill.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.bill.model.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, UUID> {}
