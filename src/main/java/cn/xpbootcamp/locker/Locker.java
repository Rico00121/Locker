package cn.xpbootcamp.locker;

import java.util.HashMap;

public class Locker {
    private int availableCapacity;
    private final HashMap<Ticket, Bag> bags = new HashMap<>();

    public Locker(int capacity) {
        this.availableCapacity = capacity;
    }

    public Ticket save(Bag bag) {
        if (availableCapacity == 0){
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        bags.put(ticket,bag);
        availableCapacity--;
        return ticket;
    }

    public Bag pickUpBy(Ticket ticket) {
        if (ticket == null || !bags.containsKey(ticket)) {
            throw new InvalidTicketException();
        }
        return bags.remove(ticket);
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }
}
