package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SmartLockerRobotTest {
    @Test
    public void should_saved_to_first_capacity_locker_when_first_locker_is_3_and_second_is_2_when_smart_robot_save_bag() {
        Locker firstLocker = new Locker(3);
        Locker secondLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        Bag bag = new Bag();

        Ticket ticket = smartLockerRobot.save(bag);

        Assertions.assertTrue(firstLocker.contains(ticket));

    }
    @Test
    public void should_saved_to_second_capacity_locker_when_first_locker_is_2_and_second_is_3_when_smart_robot_save_bag() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(3);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        Bag bag = new Bag();

        Ticket ticket = smartLockerRobot.save(bag);

        Assertions.assertTrue(secondLocker.contains(ticket));

    }
    @Test
    public void should_saved_to_first_when_both_2_available_when_smart_robot_save_bag() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));
        Bag bag = new Bag();

        Ticket ticket = smartLockerRobot.save(bag);

        Assertions.assertTrue(firstLocker.contains(ticket));
    }
    @Test
    public void should_throw_exception_when_both_lockers_is_full_when_smart_robot_save_bag() {
        Locker firstLocker = new Locker(0);
        Locker secondLocker = new Locker(0);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(firstLocker, secondLocker));

        Assertions.assertThrows(LockerIsFullException.class, () -> smartLockerRobot.save(new Bag()));
    }
    @Test
    public void should_return_bag_when_smart_robot_pick_up() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        ArrayList<Locker> lockers = Lists.newArrayList(firstLocker, secondLocker);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

        Bag bag = new Bag();

        Ticket ticket = smartLockerRobot.save(bag);

        Assertions.assertSame(bag, smartLockerRobot.pickUp(ticket));
    }

    @Test
    public void should_throw_exception_when_smart_robot_pick_up_by_fake_ticket() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        ArrayList<Locker> lockers = Lists.newArrayList(firstLocker, secondLocker);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

        smartLockerRobot.save(new Bag());
        Ticket fakeTicket = new Ticket();

        Assertions.assertThrows(InvalidTicketException.class, () -> smartLockerRobot.pickUp(fakeTicket));
    }

    @Test
    public void should_return_bag_when_primary_robot_save_and_smart_robot_pick_up() {
        Locker firstLocker = new Locker(2);
        Locker secondLocker = new Locker(2);
        ArrayList<Locker> lockers = Lists.newArrayList(firstLocker, secondLocker);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);

        Bag bag = new Bag();

        Ticket ticket = primaryLockerRobot.save(bag);

        Assertions.assertSame(bag, smartLockerRobot.pickUp(ticket));
    }
}
