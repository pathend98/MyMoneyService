package dev.hend.MyMoneyService.bill.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hend.MyMoneyService.bill.model.Bill;
import dev.hend.MyMoneyService.bill.service.BillService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Bill createBill(@RequestBody Bill bill) {
        return billService.upsertBill(bill);
    }
}
