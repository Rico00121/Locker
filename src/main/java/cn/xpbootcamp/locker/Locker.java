package cn.xpbootcamp.locker;

import java.util.HashMap;

public class Locker {
    private int capacity;
    private final HashMap<Ticket, Bag> bags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save(Bag bag) {
        if (capacity == 0){
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        bags.put(ticket,bag);
        capacity--;
        return ticket;
    }

    public Bag pickUpBy(Ticket ticket) {
        return bags.get(ticket);
    }
}
