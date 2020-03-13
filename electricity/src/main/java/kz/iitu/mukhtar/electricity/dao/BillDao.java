package kz.iitu.mukhtar.electricity.dao;


import kz.iitu.mukhtar.electricity.dao.mappers.BillMapper;
import kz.iitu.mukhtar.electricity.database.Database;
import kz.iitu.mukhtar.electricity.entity.Bill;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.event.UserCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillDao implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;


    private final String GET_ALL_BILLS = "SELECT * FROM bills WHERE user_id=";
    private final String GET_BILL_BY_ID = "SELECT * FROM bills WHERE id =";
    private final String DELETE_BILL = "DELETE FROM bills WHERE id =";
    private final String ADD_BILL = "INSERT INTO bills(name , kwh, price, user_id) VALUES";


    @Autowired
    public BillDao(Database database) {
        this.jdbcTemplate = new JdbcTemplate(database.getDataSource());
    }

    public void create(User user) {
        this.eventPublisher.publishEvent(new UserCreateEvent(this, user));
    }

    public List<Bill> getAll() {
        return jdbcTemplate.query(GET_ALL_BILLS, new BillMapper());
    }

    public List<Bill> getUserById(int id) {
        return jdbcTemplate.query(GET_BILL_BY_ID + id, new BillMapper());
    }

    public void addBill(String name, int price, int kwh, int user_id) {
        jdbcTemplate.execute(ADD_BILL + "('" + name + "'," + kwh + "," + price + "," + user_id + ""+")");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
