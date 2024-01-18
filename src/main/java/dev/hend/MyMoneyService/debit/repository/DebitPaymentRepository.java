package dev.hend.MyMoneyService.debit.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hend.MyMoneyService.debit.model.DebitPayment;

@Repository
public interface DebitPaymentRepository extends CrudRepository<DebitPayment, UUID> {}
