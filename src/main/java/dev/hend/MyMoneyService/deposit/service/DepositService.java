package dev.hend.MyMoneyService.deposit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.deposit.exception.DepositNotFoundException;
import dev.hend.MyMoneyService.deposit.model.Deposit;
import dev.hend.MyMoneyService.deposit.model.DepositQuery;
import dev.hend.MyMoneyService.deposit.repository.DepositRepository;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class DepositService {

    private final DepositRepository depositRepository;

    public List<Deposit> queryDeposits(DepositQuery query) {
        return depositRepository.findAllByDateBetween(query.getStartDate(), query.getEndDate());
    }

    public Deposit upsertDeposit(Deposit deposit) {
        UUID depositId = deposit.getId();

        if (nonNull(depositId) && depositRepository.findById(depositId).isEmpty()) {
            throw new DepositNotFoundException("Deposit", depositId.toString());
        }

        return depositRepository.save(deposit);
    }

    public void deleteDepositById(UUID id) {
        depositRepository.deleteById(id);
    }
}
