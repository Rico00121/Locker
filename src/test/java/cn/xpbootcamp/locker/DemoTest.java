package cn.xpbootcamp.locker;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DemoTest {
    //这个测试文件只是一个demo，仅供参考，提交代码时需要删除

    @Test
    public void should_return_ticket_when_locker_save_bag_given_locker_has_available_capacity() {
        Locker locker = new Locker(10);

        Ticket ticket = locker.save(new Bag());

        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_locker_is_full() {
        Locker locker = new Locker(1);

        locker.save(new Bag());

        Assertions.assertThrows(LockerIsFullException.class, () -> locker.save(new Bag()));

    }

}
