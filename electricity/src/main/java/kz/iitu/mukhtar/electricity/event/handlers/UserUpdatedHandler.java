package kz.iitu.mukhtar.electricity.event.handlers;

import kz.iitu.mukhtar.electricity.event.UserCreateEvent;
import kz.iitu.mukhtar.electricity.event.UserUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserUpdatedHandler implements ApplicationListener<UserUpdateEvent> {

    @Override
    public void onApplicationEvent(UserUpdateEvent userUpdateEvent) {
        System.out.println("UserUpdatedHandler.onApplicationEvent");
        System.out.println("Updated user info: " + userUpdateEvent.getUser().getName());
        System.out.println("Updated user money: " + userUpdateEvent.getUser().getMoney());
    }
}
