package kz.iitu.mukhtar.electricity.controller;

import io.swagger.annotations.ApiOperation;
import kz.iitu.mukhtar.electricity.entity.Checkouts;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.exceptions.CheckNotFoundException;
import kz.iitu.mukhtar.electricity.exceptions.UserNotFoundException;
import kz.iitu.mukhtar.electricity.service.CheckoutService;
import kz.iitu.mukhtar.electricity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;
    private UserService userService;

    @ApiOperation(value = "Get all checkouts", response = List.class)
    @GetMapping("")
    public List<Checkouts> getAllUsers() {
        return checkoutService.showAllCheckouts();
    }

    @ApiOperation(value = "Get specific checkout", response = User.class)
    @GetMapping("/{id}")
    public Checkouts findUserById(@PathVariable("id") Long id) throws CheckNotFoundException {
        return checkoutService.findCheckoutById(id);
    }

    @ApiOperation(value = "Get make checkout for user", response = User.class)
    @PostMapping("/checkout/")
    public Checkouts addCheckout(@RequestParam("checkout_id") Long checkoutId, @RequestParam("user_id") Long userId) throws UserNotFoundException, CheckNotFoundException {
        User user = userService.findUserById(userId);
        Checkouts checkout = checkoutService.findCheckoutById(checkoutId);

        return checkoutService.addCheckout(user, checkout);

    }

    @ApiOperation(value = "Get make checkout for user", response = User.class)
    @PostMapping("/new/")
    public Checkouts newCheckout(@RequestParam("user_id") Long userId) throws UserNotFoundException {
        User user = userService.findUserById(userId);
        return checkoutService.newCheckout(user);

    }

}
