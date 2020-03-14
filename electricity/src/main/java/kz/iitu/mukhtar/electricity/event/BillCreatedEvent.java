package kz.iitu.mukhtar.electricity.event;

import kz.iitu.mukhtar.electricity.entity.Bill;
import org.springframework.context.ApplicationEvent;

public class BillCreatedEvent extends ApplicationEvent {

    private Bill bill;

    public BillCreatedEvent(Object source, Bill bill) {
        super(source);
        this.bill = bill;
    }

    public Bill getEvent() {
        return bill;
    }
}