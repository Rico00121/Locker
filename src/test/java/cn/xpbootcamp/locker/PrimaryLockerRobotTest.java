package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimaryLockerRobotTest {

    public static final int CAPACITY = 2;
    public static final int IS_FULL = 0;

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

    @Test
    public void should_return_ticket_and_save_in_second_locker_when_first_locker_is_full() {
        Locker locker1 = new Locker(IS_FULL);
        Locker locker2 = new Locker(CAPACITY);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(
                Lists.newArrayList(locker1, locker2));

        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);

        Assertions.assertEquals(locker1.getAvailableCapacity(), 0);
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(locker2.getAvailableCapacity(), 1);
        Assertions.assertSame(locker2.pickUpBy(ticket),bag);
    }

    @Test
    public void should_return_exception_when_all_lockers_is_full() {
        Locker locker1 = new Locker(IS_FULL);
        Locker locker2 = new Locker(IS_FULL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(
                Lists.newArrayList(locker1, locker2));

        Assertions.assertThrows(LockerIsFullException.class, () -> primaryLockerRobot.save(new Bag()));

    }

    @Test
    public void should_pick_up_bag_successfully_when_use_valid_ticket() {
        Locker locker1 = new Locker(CAPACITY);
        Locker locker2 = new Locker(CAPACITY);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(
                Lists.newArrayList(locker1, locker2));
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);

        Bag returnBag = primaryLockerRobot.pickUp(ticket);

        Assertions.assertEquals(bag, returnBag);

    }
}
