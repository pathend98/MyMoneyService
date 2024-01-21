package dev.hend.MyMoneyService.debit.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DebitQuery {

    private LocalDate startDate;
    private LocalDate endDate;
}
