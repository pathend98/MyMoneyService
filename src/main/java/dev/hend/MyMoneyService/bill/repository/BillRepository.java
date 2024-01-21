package dev.hend.MyMoneyService.bill.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import dev.hend.MyMoneyService.bill.model.Bill;

public interface BillRepository extends CrudRepository<Bill, UUID> {}
