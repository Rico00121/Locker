package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers;
    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.getAvailableCapacity()>0)
                return locker.save(bag);
        }
        return null;
    }
}
