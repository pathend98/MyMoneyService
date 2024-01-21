package dev.hend.MyMoneyService.deposit.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class DepositNotFoundException extends ResourceNotFoundException {

    public DepositNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
