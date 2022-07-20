package cn.xpbootcamp.locker;

public class Locker {
    private  int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save(Bag bag) {
        if (capacity == 0){
            throw new LockerIsFullException();
        }
        capacity--;
        return new Ticket();
    }
}
