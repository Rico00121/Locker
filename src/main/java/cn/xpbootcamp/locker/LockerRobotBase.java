package cn.xpbootcamp.locker;

import java.util.List;

public abstract class LockerRobotBase {
    protected final List<Locker> lockers;

    protected LockerRobotBase(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Ticket save(Bag bag);

    public Bag pickUp(Ticket ticket) {
        for (Locker locker: lockers) {
            if (locker.contains(ticket))
                return locker.pickUpBy(ticket);
        }
        throw new InvalidTicketException();
    }
}
