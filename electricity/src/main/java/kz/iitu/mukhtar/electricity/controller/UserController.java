package kz.iitu.mukhtar.electricity.controller;

import io.swagger.annotations.ApiOperation;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.exceptions.UserNotFoundException;
import kz.iitu.mukhtar.electricity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    @ApiOperation(value = "Get all users", response = List.class)
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.showAllUsers();
    }

    @ApiOperation(value = "Get user with given id", response = User.class)
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.findUserById(id);
    }

    @ApiOperation(value = "Register a new user", response = User.class)
    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }






//    private UserService userService;
//
//    @Autowired
//    public MainController(UserService userService){
//        this.userService = userService;
//    }
//
//
//    public void showMenu(){
//        System.out.println("Welcome!");
//        System.out.println("Select an option:");
//        System.out.println("1) list all users");
//        System.out.println("2) update user");
//        System.out.println("3) add bill");
//        System.out.println("4) pay bill");
//    }
//
//    public void showAllUsers(){
//        userService.showAllUsers();
//    }
//
//    public void updateUser(int id, int money){
//        userService.updateUserMoney(id, money);
//    }
//
//
//    public void addBill(){
//        userService.addBillToUser();
//    }
//
//    public void payBill(int id){
//        userService.payBill(id);
//    }
}
