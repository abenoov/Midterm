package kz.iitu.mukhtar.electricity;

import kz.iitu.mukhtar.electricity.controller.MainController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Facade {
    public void  startApplication(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);


        MainController controller
                = context.getBean("mainController", MainController.class);

        controller.showMenu();

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1){
            controller.showAllUsers();
        } else if (input == 2){
            System.out.println("Enter an id:");
            int id = sc.nextInt();
            System.out.println("Enter money to update:");
            int money = sc.nextInt();
            controller.updateUser(id, money);
        } else if (input == 3){
            controller.addBill();
        } else if (input == 4){
            System.out.println("Enter an id:");
            int id = sc.nextInt();
            controller.payBill(id);
        }
    }
}
