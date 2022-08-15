package cn.xpbootcamp.locker;

import java.util.List;

public class SmartLockerRobot {

    private final List<Locker> lockers;
    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        Locker maxAvailableCapacityLocker = lockers.get(0);
        for (Locker locker : lockers) {
            if (locker.getAvailableCapacity()> maxAvailableCapacityLocker.getAvailableCapacity())
                maxAvailableCapacityLocker=locker;
        }
        return maxAvailableCapacityLocker.save(bag);
    }
}
