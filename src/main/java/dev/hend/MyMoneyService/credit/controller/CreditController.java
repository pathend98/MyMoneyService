package dev.hend.MyMoneyService.credit.controller;

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

import dev.hend.MyMoneyService.credit.model.Credit;
import dev.hend.MyMoneyService.credit.model.CreditQuery;
import dev.hend.MyMoneyService.credit.service.CreditService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/credit")
@CrossOrigin
public class CreditController {

    private final CreditService creditService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Credit upsertCredit(@RequestBody Credit credit) {
        return creditService.upsertCredit(credit);
    }

    @PostMapping(
            value = "/query",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Credit> queryCredits(@RequestBody CreditQuery query) {
        return creditService.queryCredits(query);
    }

    @DeleteMapping("/{id}")
    public void deleteCreditById(@PathVariable("id") UUID id) {
        creditService.deleteCreditById(id);
    }
}
