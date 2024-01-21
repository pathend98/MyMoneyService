package dev.hend.MyMoneyService.debit.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class DebitNotFoundException extends ResourceNotFoundException {

    public DebitNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
