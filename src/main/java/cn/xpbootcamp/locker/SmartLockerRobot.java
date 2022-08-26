package cn.xpbootcamp.locker;

import java.util.List;

public class SmartLockerRobot extends LockerRobotBase{

    protected SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket save(Bag bag) {
        return getMaxAvailableCapacityLocker().save(bag);
    }

    private Locker getMaxAvailableCapacityLocker() {
        Locker maxAvailableCapacityLocker = lockers.get(0);
        for (Locker locker : lockers) {
            if (locker.getAvailableCapacity()> maxAvailableCapacityLocker.getAvailableCapacity())
                maxAvailableCapacityLocker=locker;
        }
        return maxAvailableCapacityLocker;
    }
}
