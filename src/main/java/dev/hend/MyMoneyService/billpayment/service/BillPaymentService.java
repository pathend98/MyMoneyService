package dev.hend.MyMoneyService.billpayment.service;

import java.util.List;
import java.util.UUID;

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
        return billPaymentRepository.findAllByDateOfPaymentBetween(query.getStartDate(), query.getEndDate());
    }

    public BillPayment upsertBillPayment(BillPayment billPayment) {
        UUID paymentId = billPayment.getId();

        if (nonNull(paymentId) && billPaymentRepository.findById(paymentId).isEmpty()) {
            throw new BillPaymentNotFoundException("Bill Payment", paymentId.toString());
        }

        return billPaymentRepository.save(billPayment);
    }
}
