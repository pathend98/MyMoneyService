package dev.hend.MyMoneyService.credit.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreditQuery {

    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid;
}
