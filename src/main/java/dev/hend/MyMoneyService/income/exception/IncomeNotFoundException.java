package dev.hend.MyMoneyService.income.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class IncomeNotFoundException extends ResourceNotFoundException {

    public IncomeNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
