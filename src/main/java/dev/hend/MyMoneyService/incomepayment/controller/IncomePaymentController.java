package dev.hend.MyMoneyService.incomepayment.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hend.MyMoneyService.incomepayment.model.IncomePayment;
import dev.hend.MyMoneyService.incomepayment.model.IncomePaymentQuery;
import dev.hend.MyMoneyService.incomepayment.service.IncomePaymentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/income-payment")
@CrossOrigin
public class IncomePaymentController {

    private final IncomePaymentService incomePaymentService;

    @PostMapping(
            value = "/query",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IncomePayment> queryIncomePayments(@RequestBody IncomePaymentQuery query) {
        return incomePaymentService.queryIncomePayments(query);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public IncomePayment upsertIncomePayment(@RequestBody IncomePayment incomePayment) {
        return incomePaymentService.upsertIncomePayment(incomePayment);
    }
}
