package BookingReservationSystem;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        ReservationSystem rs = new ReservationSystem(50);
        Thread t1 = new Thread(()->rs.reservedSeats("user1",5));
        Thread t2 = new Thread(()->rs.reservedSeats("user2",23));
        Thread t3 = new Thread(()->rs.reservedSeats("user3",20));

        t1.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Remaining available seats: " +
                rs.getAvailableSeats());
    }
}