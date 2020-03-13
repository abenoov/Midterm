package kz.iitu.mukhtar.electricity;

import kz.iitu.mukhtar.electricity.controller.MainController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);


        MainController controller
                = context.getBean("mainController", MainController.class);

        controller.showMenu();

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1){
            controller.showAllEmployees();
        } else if (input == 2){
            System.out.println("Enter an id:");
            int id = sc.nextInt();
            System.out.println("Enter an id:");
            int money = sc.nextInt();
            controller.updateEmployee(id, money);
        } else if (input == 3){
            controller.addBill();
        }
    }
}
