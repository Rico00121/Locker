package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimaryLockerRobotTest {

    public static final int CAPACITY = 2;

    @Test
    public void should_return_ticket_and_save_in_first_locker_when_all_lockers_have_available_capacity() {
        Locker locker1 = new Locker(CAPACITY);
        Locker locker2 = new Locker(CAPACITY);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(
                Lists.newArrayList(locker1, locker2));

        Ticket ticket = primaryLockerRobot.save(new Bag());

        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(locker1.getAvailableCapacity(), 1);
    }

}
