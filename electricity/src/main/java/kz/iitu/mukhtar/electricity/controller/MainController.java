package kz.iitu.mukhtar.electricity.controller;

import kz.iitu.mukhtar.electricity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MainController {
    private UserService userService;

    @Autowired
    public MainController(UserService userService){
        this.userService = userService;
    }


    public void showMenu(){
        System.out.println("Welcome!");
        System.out.println("Select an option:");
        System.out.println("1) list all users");
        System.out.println("2) update user");
        System.out.println("3) add bill");
    }

    public void showAllEmployees(){
        userService.showAllUsers();
    }

    public void updateEmployee(int id, int money){
        userService.updateUserMoney(id, money);
    }


    public void addBill(){
        userService.addBillToUser();
    }
}
