package cn.xpbootcamp.locker;

import java.util.List;

public class PrimaryLockerRobot extends LockerRobotBase{
    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket save(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.getAvailableCapacity()>0)
                return locker.save(bag);
        }
        throw new LockerIsFullException();
    }
}
