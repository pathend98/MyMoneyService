package dev.hend.MyMoneyService.income.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.income.exception.IncomeNotFoundException;
import dev.hend.MyMoneyService.income.model.Income;
import dev.hend.MyMoneyService.income.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public List<Income> getAllIncomes() {
        return StreamSupport.stream(incomeRepository.findAll().spliterator(), false)
                .toList();
    }

    public Income upsertIncome(Income income) {
        if (nonNull(income.getId()) && incomeRepository.findById(income.getId()).isEmpty()) {
            throw new IncomeNotFoundException("Income", income.getId().toString());
        }

        return incomeRepository.save(income);
    }
}
