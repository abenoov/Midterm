package kz.iitu.mukhtar.electricity;

import kz.iitu.mukhtar.electricity.dao.BillDao;
import kz.iitu.mukhtar.electricity.dao.UserDao;
import kz.iitu.mukhtar.electricity.entity.Bill;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.event.BillPayedEvent;
import kz.iitu.mukhtar.electricity.event.UserCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Accountant  implements ApplicationEventPublisherAware {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BillDao billDao;

    private ApplicationEventPublisher eventPublisher;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void payBill(int id){
        for (int i = 0; i <userDao.getUserById(id).size() ; i++) {
            user = userDao.getUserById(id).get(i);
        }

        List<Bill> bills = billDao.getUserBill(id);

        for (int i = 0; i < bills.size(); i++) {
            System.out.println(bills.toString());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bill id:");

        int billId = sc.nextInt();

        Bill currentBill = billDao.getBillById(billId);

        int totalPrice = currentBill.getPrice() * currentBill.getKwh();

        user.setMoney(user.getMoney() - totalPrice);

        this.eventPublisher.publishEvent(new BillPayedEvent(this, currentBill));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
