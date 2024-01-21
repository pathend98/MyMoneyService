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

import dev.hend.MyMoneyService.debit.model.Debit;
import dev.hend.MyMoneyService.debit.model.DebitQuery;
import dev.hend.MyMoneyService.debit.service.DebitService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/debit")
public class DebitController {

    private final DebitService debitService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Debit> getAllDebits() {
        return debitService.getAllDebits();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Debit getDebitById(@PathVariable("id") UUID id) {
        return debitService.getDebitById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Debit createDebit(@RequestBody Debit debit) {
        return debitService.createDebit(debit);
    }

    @PostMapping(
            value = "/query",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Debit> queryDebits(@RequestBody DebitQuery query) {
        return debitService.queryDebits(query);
    }

    @DeleteMapping("/{id}")
    public void deleteDebitById(@PathVariable("id") UUID id) {
        debitService.deleteDebitById(id);
    }
}
