package dev.hend.MyMoneyService.credit.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class CreditNotFoundException extends ResourceNotFoundException {

    public CreditNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
