package kz.iitu.mukhtar.electricity.controller;

import io.swagger.annotations.ApiOperation;
import kz.iitu.mukhtar.electricity.entity.Bill;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.exceptions.UserNotFoundException;
import kz.iitu.mukhtar.electricity.service.BillService;
import kz.iitu.mukhtar.electricity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/bills")
public class BillController {

    private BillService billService;
    private UserService userService;

    @ApiOperation(value = "Create a new bills", response = List.class)
    @PostMapping("/newBill")
    public Bill newBills(@RequestBody Bill bill) {
        return billService.newBill(bill);
    }

    @ApiOperation(value = "Add bill to user", response = List.class)
    @PostMapping("/addBill")
    public User addBill(@RequestParam("user_id") Long userId, @RequestParam("bill_id") Long billId) throws UserNotFoundException {
        User user = userService.findUserById(userId);
        Bill bill = billService.findBillById(billId);

        return billService.addBill(user, bill);
    }
}
