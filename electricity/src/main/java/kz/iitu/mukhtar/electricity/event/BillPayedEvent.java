package kz.iitu.mukhtar.electricity.event;

import kz.iitu.mukhtar.electricity.entity.User;
import org.springframework.context.ApplicationEvent;

public class BillPayedEvent extends ApplicationEvent {

    private User user;

    public BillPayedEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
