package kz.iitu.mukhtar.electricity.event;

import kz.iitu.mukhtar.electricity.entity.Bill;
import kz.iitu.mukhtar.electricity.entity.User;
import org.springframework.context.ApplicationEvent;

public class BillPayedEvent extends ApplicationEvent {

    private Bill bill;

    public BillPayedEvent(Object source, Bill bill) {
        super(source);
        this.bill = bill;
        ;
    }

    public Bill getEvent() {
        return bill;
    }
}
