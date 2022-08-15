package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
