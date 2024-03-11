package dev.hend.MyMoneyService.billpayment.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hend.MyMoneyService.billpayment.model.BillPayment;
import dev.hend.MyMoneyService.billpayment.model.BillPaymentQuery;
import dev.hend.MyMoneyService.billpayment.service.BillPaymentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bill-payment")
@CrossOrigin
public class BillPaymentController {

    private final BillPaymentService billPaymentService;

    @PostMapping(
            value = "/query",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BillPayment> queryBillPayments(@RequestBody BillPaymentQuery query) {
        return billPaymentService.queryBillPayments(query);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BillPayment upsertBillPayment(@RequestBody BillPayment billPayment) {
        return billPaymentService.upsertBillPayment(billPayment);
    }
}
