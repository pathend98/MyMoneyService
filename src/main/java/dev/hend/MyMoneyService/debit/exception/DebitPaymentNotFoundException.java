package dev.hend.MyMoneyService.debit.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class DebitPaymentNotFoundException extends ResourceNotFoundException {

    public DebitPaymentNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
