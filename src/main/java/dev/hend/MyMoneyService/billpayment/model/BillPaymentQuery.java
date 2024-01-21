package dev.hend.MyMoneyService.billpayment.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BillPaymentQuery {

    private LocalDate dateOfBillStart;
    private LocalDate dateOfBillEnd;
}
