package kz.iitu.mukhtar.electricity.service;

import kz.iitu.mukhtar.electricity.entity.Checkouts;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.exceptions.CheckNotFoundException;
import kz.iitu.mukhtar.electricity.repository.BillRepository;
import kz.iitu.mukhtar.electricity.repository.CheckoutsRepository;
import kz.iitu.mukhtar.electricity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Component
public class CheckoutService {
    private BillRepository billRepository;
    private UserRepository userRepository;
    private CheckoutsRepository checkoutsRepository;

    public Checkouts newCheckout(User user){
        Checkouts checkout = new Checkouts();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        checkout.setPayDate(date);
        checkout.setPayedStatus(true);
        Set<User> users = checkout.getUsers();
        users.add(user);

        return checkoutsRepository.save(checkout);
    }

    public Checkouts addCheckout(User user, Checkouts checkout){
        Set<User> users = checkout.getUsers();
        users.add(user);
        checkout.setUsers(users);
        return checkoutsRepository.save(checkout);
    }

    public Checkouts removeCheckout(User user, Checkouts checkout){
        Set<User> users = checkout.getUsers();
        users.remove(user);
        checkout.setUsers(users);
        return checkoutsRepository.save(checkout);
    }

    public List<Checkouts> showAllCheckouts(){
        return checkoutsRepository.findAll();
    }

    public Checkouts findCheckoutById(Long id) throws CheckNotFoundException {
        Checkouts checkout = checkoutsRepository.findById(id).orElse(null);
        if (checkout == null){
            throw new CheckNotFoundException();
        }
        return checkout;
    }


}
