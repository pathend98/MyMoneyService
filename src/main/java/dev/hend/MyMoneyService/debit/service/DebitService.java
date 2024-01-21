package dev.hend.MyMoneyService.debit.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.debit.exception.DebitNotFoundException;
import dev.hend.MyMoneyService.debit.model.Debit;
import dev.hend.MyMoneyService.debit.model.DebitQuery;
import dev.hend.MyMoneyService.debit.repository.DebitRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DebitService {

    private final DebitRepository debitRepository;

    public List<Debit> getAllDebitPayments() {
        return StreamSupport.stream(debitRepository.findAll().spliterator(), false)
                .toList();
    }

    public Debit getDebitPaymentById(UUID id) {
        Optional<Debit> result = debitRepository.findById(id);

        if (result.isEmpty()) {
            throw new DebitNotFoundException("Debit", id.toString());
        }

        return result.get();
    }

    public Debit createDebitPayment(Debit debitPayment) {
        return debitRepository.save(debitPayment);
    }

    public List<Debit> queryDebits(DebitQuery query) {
        return debitRepository.findAllByDateGreaterThanEqualAndDateLessThanEqual(
                query.getStartDate(), query.getEndDate());
    }

    public void deleteDebitById(UUID id) {
        debitRepository.deleteById(id);
    }
}
