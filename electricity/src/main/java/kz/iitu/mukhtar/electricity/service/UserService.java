package kz.iitu.mukhtar.electricity.service;

import kz.iitu.mukhtar.electricity.Accountant;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BillService billService;

    @Autowired
    Accountant accountant;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void updateUserMoney(int id, int money) {
        userDao.updateMoney(id, money);
    }

    public void showAllUsers() {
        List<User> employees = userDao.getAll();
        System.out.println();
        System.out.println("Employees list: ");
        for (User employee : employees) {
            System.out.println(employee.toString());
        }
        System.out.println();
    }

    public void addBillToUser(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter name of the tariff:");
        String name = sc.nextLine();
        System.out.println("Enter price for the tarif:");
        int price = sc.nextInt();
        System.out.println("Enter kwh used:");
        int kwh = sc.nextInt();
        System.out.println("Enter user_id:");
        int user_id = sc.nextInt();

        billService.addBill(name,price, kwh, user_id);
    }


    public void payBill(int id){
        accountant.payBill(id);
    }

}
