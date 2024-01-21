package dev.hend.MyMoneyService.debit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.debit.exception.DebitNotFoundException;
import dev.hend.MyMoneyService.debit.model.Debit;
import dev.hend.MyMoneyService.debit.model.DebitQuery;
import dev.hend.MyMoneyService.debit.repository.DebitRepository;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class DebitService {

    private final DebitRepository debitRepository;

    public Debit upsertDebit(Debit debitPayment) {
        if (nonNull(debitPayment.getId())
                && debitRepository.findById(debitPayment.getId()).isEmpty()) {
            throw new DebitNotFoundException("Debit", debitPayment.getId().toString());
        }
        return debitRepository.save(debitPayment);
    }

    public List<Debit> queryDebits(DebitQuery query) {
        return debitRepository.findAllByDateBetween(query.getStartDate(), query.getEndDate());
    }

    public void deleteDebitById(UUID id) {
        debitRepository.deleteById(id);
    }
}
