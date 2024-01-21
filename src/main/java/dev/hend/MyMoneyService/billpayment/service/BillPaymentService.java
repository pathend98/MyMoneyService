package dev.hend.MyMoneyService.billpayment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.billpayment.exception.BillPaymentNotFoundException;
import dev.hend.MyMoneyService.billpayment.model.BillPayment;
import dev.hend.MyMoneyService.billpayment.model.BillPaymentQuery;
import dev.hend.MyMoneyService.billpayment.repository.BillPaymentRepository;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class BillPaymentService {

    private final BillPaymentRepository billPaymentRepository;

    public List<BillPayment> queryBillPayments(BillPaymentQuery query) {
        return billPaymentRepository.findAllByDateOfBillBetween(query.getDateOfBillStart(), query.getDateOfBillEnd());
    }

    public BillPayment upsertBillPayment(BillPayment billPayment) {
        if (nonNull(billPayment.getId())
                && billPaymentRepository.findById(billPayment.getId()).isEmpty()) {
            throw new BillPaymentNotFoundException(
                    "Bill Payment", billPayment.getId().toString());
        }

        return billPaymentRepository.save(billPayment);
    }
}
