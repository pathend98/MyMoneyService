package dev.hend.MyMoneyService.bill.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import dev.hend.MyMoneyService.bill.model.Bill;
import dev.hend.MyMoneyService.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BillService {

    private final BillRepository billRepository;

    public List<Bill> getAllBills() {
        return StreamSupport.stream(billRepository.findAll().spliterator(), false)
                .toList();
    }

    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    public void deleteBillById(UUID id) {
        billRepository.deleteById(id);
    }
}
