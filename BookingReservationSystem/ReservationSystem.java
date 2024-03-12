package BookingReservationSystem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class ReservationSystem{
    private int availableSeats;
    private Lock lock = new ReentrantLock();

    public ReservationSystem(int availableSeats){
        this.availableSeats = availableSeats;
    }

    public void reservedSeats(String user, int seats){
        try{
            lock.lock();
            if( seats > 0 && seats <= availableSeats){
                availableSeats-=seats;
                System.out.println(user+" reserved "+seats+" seats");
            }
            else{
                System.out.println("Not enough seats were available for user"+user);
            }
        }
        finally {
            lock.unlock();
        }
    }

    public int getAvailableSeats(){
        return availableSeats;
    }

}