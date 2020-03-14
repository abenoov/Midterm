package kz.iitu.mukhtar.electricity.event;

import kz.iitu.mukhtar.electricity.entity.User;
import org.springframework.context.ApplicationEvent;

public class UserUpdateEvent  extends ApplicationEvent {

    private User user;

    public UserUpdateEvent(Object source, User employee) {
        super(source);
        this.user = employee;
    }

    public User getUser() {
        return user;
    }
}
