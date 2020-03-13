package kz.iitu.mukhtar.electricity.dao;

import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.dao.mappers.UserMapper;
import kz.iitu.mukhtar.electricity.database.Database;
import kz.iitu.mukhtar.electricity.event.UserCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    private final String GET_ALL_USERS = "SELECT * FROM users";
    private final String GET_USER_BY_ID = "SELECT * FROM users WHERE id =";
    private final String UPDATE_USER_MONEY = "UPDATE users SET money =";
    private final String DELETE_USER = "DELETE FROM users WHERE id =";
    private final String CHANGE_USER_NAME = "UPDATE users SET name = ";


    @Autowired
    public UserDao(Database database) {
        this.jdbcTemplate = new JdbcTemplate(database.getDataSource());
    }

    public void create(User user) {
        this.eventPublisher.publishEvent(new UserCreateEvent(this, user));
    }

    public void updateSalary(int id, int money) {
        jdbcTemplate.execute(UPDATE_USER_MONEY + money + "WHERE id =" + id);
    }

    public List<User> getAll() {
        return jdbcTemplate.query(GET_ALL_USERS, new UserMapper());
    }

    public List<User> getUserById(int id) {
        return jdbcTemplate.query(GET_USER_BY_ID + id, new UserMapper());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
