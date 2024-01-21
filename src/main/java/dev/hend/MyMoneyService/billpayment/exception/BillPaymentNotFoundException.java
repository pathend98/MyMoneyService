package dev.hend.MyMoneyService.billpayment.exception;

import dev.hend.MyMoneyService.exception.ResourceNotFoundException;

public class BillPaymentNotFoundException extends ResourceNotFoundException {

    public BillPaymentNotFoundException(String resourceName, String identifier) {
        super(resourceName, identifier);
    }
}
