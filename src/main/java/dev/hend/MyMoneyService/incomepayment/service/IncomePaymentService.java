package dev.hend.MyMoneyService.incomepayment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.incomepayment.exception.IncomePaymentNotFoundException;
import dev.hend.MyMoneyService.incomepayment.model.IncomePayment;
import dev.hend.MyMoneyService.incomepayment.model.IncomePaymentQuery;
import dev.hend.MyMoneyService.incomepayment.repository.IncomePaymentRepository;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class IncomePaymentService {

    private final IncomePaymentRepository incomePaymentRepository;

    public List<IncomePayment> queryIncomePayments(IncomePaymentQuery query) {
        return incomePaymentRepository.findAllByDateOfPaymentBetween(query.getStartDate(), query.getEndDate());
    }

    public IncomePayment upsertIncomePayment(IncomePayment incomePayment) {
        if (nonNull(incomePayment.getId())
                && incomePaymentRepository.findById(incomePayment.getId()).isEmpty()) {
            throw new IncomePaymentNotFoundException(
                    "Income Payment", incomePayment.getId().toString());
        }

        return incomePaymentRepository.save(incomePayment);
    }
}
