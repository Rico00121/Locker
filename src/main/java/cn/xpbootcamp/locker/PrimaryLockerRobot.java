package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers;
    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        Ticket ticket = lockers.get(0).save(bag);
        return ticket;
    }
}
