package dev.hend.MyMoneyService.income.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hend.MyMoneyService.income.model.Income;
import dev.hend.MyMoneyService.income.service.IncomeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/income")
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Income upsertIncome(@RequestBody Income income) {
        return incomeService.upsertIncome(income);
    }
}
