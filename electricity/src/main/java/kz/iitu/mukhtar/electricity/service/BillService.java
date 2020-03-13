package kz.iitu.mukhtar.electricity.service;

import kz.iitu.mukhtar.electricity.dao.BillDao;
import kz.iitu.mukhtar.electricity.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BillService {

    @Autowired
    private BillDao billDao;


    public void addBill(String name, int price, int kwh, int user_id){
        billDao.addBill(name, price, kwh, user_id);
    }
}
