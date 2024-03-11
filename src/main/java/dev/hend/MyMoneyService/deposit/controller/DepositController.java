package dev.hend.MyMoneyService.deposit.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hend.MyMoneyService.deposit.model.Deposit;
import dev.hend.MyMoneyService.deposit.model.DepositQuery;
import dev.hend.MyMoneyService.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/deposit")
@CrossOrigin
public class DepositController {

    private final DepositService depositService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Deposit upsertDeposit(@RequestBody Deposit deposit) {
        return depositService.upsertDeposit(deposit);
    }

    @PostMapping(
            value = "/query",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Deposit> queryDeposits(@RequestBody DepositQuery query) {
        return depositService.queryDeposits(query);
    }

    @DeleteMapping("/{id}")
    public void deleteDepositById(@PathVariable UUID id) {
        depositService.deleteDepositById(id);
    }
}
