package kz.iitu.mukhtar.electricity.service;

import kz.iitu.mukhtar.electricity.entity.Bill;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.exceptions.UserNotFoundException;
import kz.iitu.mukhtar.electricity.repository.BillRepository;
import kz.iitu.mukhtar.electricity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Component
public class BillService {

    private BillRepository billRepository;
    private UserRepository userRepository;


    public List<Bill> showAllBills(Long id) {
        return billRepository.findBillByUserId(id);
    }

    public User addBill(User user, Bill bill) {
        Set<Bill> bills = user.getBills();
        bills.add(bill);
        user.setBills(bills);
        return user;
    }


    public User removeBill(User user, Bill bill) {
        Set<Bill> bills = user.getBills();
        bills.remove(bill);
        user.setBills(bills);
        return user;
    }

    public Bill newBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill findBillById(Long id) throws UserNotFoundException {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill == null) {
            throw new UserNotFoundException();
        }
        return bill.get();
    }


}
