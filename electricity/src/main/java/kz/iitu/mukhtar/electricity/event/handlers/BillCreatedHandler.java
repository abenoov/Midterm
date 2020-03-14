package kz.iitu.mukhtar.electricity.event.handlers;

import kz.iitu.mukhtar.electricity.event.BillCreatedEvent;
import kz.iitu.mukhtar.electricity.event.BillPayedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BillCreatedHandler implements ApplicationListener<BillCreatedEvent> {
    @Override
    public void onApplicationEvent(BillCreatedEvent billCreatedEvent) {
        System.out.println("BillPayedEventHandler.onApplicationEvent");
        System.out.println("Payed bill id: " + billCreatedEvent.getEvent().getId());
        System.out.println("Payed bill price: " + billCreatedEvent.getEvent().getPrice());
        System.out.println("Payed bill kwh: " + billCreatedEvent.getEvent().getKwh());
    }

}