package dev.hend.MyMoneyService.debit.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hend.MyMoneyService.debit.model.DebitPayment;
import dev.hend.MyMoneyService.debit.service.DebitService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/debit")
public class DebitController {

    private final DebitService debitService;

    @GetMapping
    public List<DebitPayment> getAllDebitPayments() {
        return debitService.getAllDebitPayments();
    }

    @GetMapping("/{id}")
    public DebitPayment getDebitPaymentById(@PathVariable("id") UUID id) {
        return debitService.getDebitPaymentById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DebitPayment createDebitPayment(@RequestBody DebitPayment debitPayment) {
        return debitService.createDebitPayment(debitPayment);
    }

    @DeleteMapping("/{id}")
    public void deleteDebitPaymentById(@PathVariable("id") UUID id) {
        debitService.deleteDebitPaymentById(id);
    }
}
