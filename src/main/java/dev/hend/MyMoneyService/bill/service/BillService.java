package dev.hend.MyMoneyService.bill.service;

import java.util.List;
import java.util.UUID;
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
        UUID billId = bill.getId();

        if (nonNull(billId) && billRepository.findById(billId).isEmpty()) {
            throw new BillNotFoundException("Bill", billId.toString());
        }

        return billRepository.save(bill);
    }
}
