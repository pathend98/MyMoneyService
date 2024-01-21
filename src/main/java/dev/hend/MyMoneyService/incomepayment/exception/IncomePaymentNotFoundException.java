package dev.hend.MyMoneyService.incomepayment.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class IncomePaymentNotFoundException extends ResourceNotFoundException {

    public IncomePaymentNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
