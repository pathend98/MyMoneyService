package dev.hend.MyMoneyService.bill.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class BillNotFoundException extends ResourceNotFoundException {

    public BillNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
