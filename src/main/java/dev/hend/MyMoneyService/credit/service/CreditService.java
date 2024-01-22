package dev.hend.MyMoneyService.credit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.credit.exception.CreditNotFoundException;
import dev.hend.MyMoneyService.credit.model.Credit;
import dev.hend.MyMoneyService.credit.model.CreditQuery;
import dev.hend.MyMoneyService.credit.repository.CreditRepository;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class CreditService {

    private final CreditRepository creditRepository;

    public Credit upsertCredit(Credit credit) {
        UUID creditId = credit.getId();

        if (nonNull(creditId) && creditRepository.findById(creditId).isEmpty()) {
            throw new CreditNotFoundException("Credit", creditId.toString());
        }

        return creditRepository.save(credit);
    }

    public List<Credit> queryCredits(CreditQuery query) {
        if (nonNull(query.getPaid())) {
            return creditRepository.findAllByDateBetweenAndPaid(
                    query.getStartDate(), query.getEndDate(), query.getPaid());
        }

        return creditRepository.findAllByDateBetween(query.getStartDate(), query.getEndDate());
    }

    public void deleteCreditById(UUID id) {
        creditRepository.deleteById(id);
    }
}
