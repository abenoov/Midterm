package kz.iitu.mukhtar.electricity.event.handlers;

import kz.iitu.mukhtar.electricity.event.BillPayedEvent;
import kz.iitu.mukhtar.electricity.event.UserCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BillPayedEventHandler implements ApplicationListener<BillPayedEvent> {
    @Override
    public void onApplicationEvent(BillPayedEvent billPayedEvent) {
        System.out.println("BillPayedEventHandler.onApplicationEvent");
        System.out.println("Payed bill id: " + billPayedEvent.getEvent().getId());
        System.out.println("Payed bill price: " + (billPayedEvent.getEvent().getKwh() * billPayedEvent.getEvent().getPrice()));
    }
}
