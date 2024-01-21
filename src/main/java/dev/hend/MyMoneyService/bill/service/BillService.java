package dev.hend.MyMoneyService.bill.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.bill.exception.BillNotFoundException;
import dev.hend.MyMoneyService.bill.model.Bill;
import dev.hend.MyMoneyService.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class BillService {

    private final BillRepository billRepository;

    public List<Bill> getAllBills() {
        return StreamSupport.stream(billRepository.findAll().spliterator(), false)
                .toList();
    }

    public Bill upsertBill(Bill bill) {
        if (nonNull(bill.getId()) && billRepository.findById(bill.getId()).isEmpty()) {
            throw new BillNotFoundException("Bill", bill.getId().toString());
        }

        return billRepository.save(bill);
    }
}
