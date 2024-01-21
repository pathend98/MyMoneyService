package dev.hend.MyMoneyService.debit.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.debit.exception.DebitPaymentNotFoundException;
import dev.hend.MyMoneyService.debit.model.DebitPayment;
import dev.hend.MyMoneyService.debit.model.DebitPaymentQuery;
import dev.hend.MyMoneyService.debit.repository.DebitPaymentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DebitService {

    private final DebitPaymentRepository debitPaymentRepository;

    public List<DebitPayment> getAllDebitPayments() {
        return StreamSupport.stream(debitPaymentRepository.findAll().spliterator(), false)
                .toList();
    }

    public DebitPayment getDebitPaymentById(UUID id) {
        Optional<DebitPayment> result = debitPaymentRepository.findById(id);

        if (result.isEmpty()) {
            throw new DebitPaymentNotFoundException("Debit Payment", id.toString());
        }

        return result.get();
    }

    public DebitPayment createDebitPayment(DebitPayment debitPayment) {
        return debitPaymentRepository.save(debitPayment);
    }

    public List<DebitPayment> queryDebitPayments(DebitPaymentQuery query) {
        return debitPaymentRepository.findAllByDateGreaterThanEqualAndDateLessThanEqual(
                query.getStartDate(), query.getEndDate());
    }

    public void deleteDebitPaymentById(UUID id) {
        debitPaymentRepository.deleteById(id);
    }
}
