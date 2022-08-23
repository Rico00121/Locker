package cn.xpbootcamp.locker;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LockerTest {
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

    @Test
    public void should_return_bag_when_locker_is_given_valid_ticket() {
        Locker locker = new Locker(1);
        Bag savedBag = new Bag();
        Ticket ticket = locker.save(savedBag);

        Bag pickUpBag = locker.pickUpBy(ticket);

        Assertions.assertEquals(savedBag,pickUpBag);
        Assertions.assertEquals(locker.getAvailableCapacity(),1);
    }

    @Test
    public void should_throw_InvalidTicketException_when_locker_pick_up_bag_given_an_invalid_ticket() {
        Locker locker = new Locker(1);
        Ticket invalidTicket = new Ticket();

        locker.save(new Bag());

        Assertions.assertThrows(InvalidTicketException.class, () -> locker.pickUpBy(invalidTicket));
    }

    @Test
    public void should_throw_InvalidTicketException_when_locker_pick_up_bag_given_a_reused_ticket() {
        Locker locker = new Locker(1);
        Ticket ticket = locker.save(new Bag());

        locker.pickUpBy(ticket);

        Assertions.assertThrows(InvalidTicketException.class,() -> locker.pickUpBy(ticket));
    }


}
