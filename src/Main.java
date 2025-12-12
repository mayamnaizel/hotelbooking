import model.Room;
import model.Reservation;
import service.HotelManager;

import java.time.LocalDate;

/**
 * Entry point for the Hotel Booking System.
 * This class demonstrates the core system functionality.
 */
public class Main {

    public static void main(String[] args) {

        // Create hotel manager
        HotelManager hotelManager = new HotelManager();

        // Add rooms to the hotel
        hotelManager.addRoom(new Room(101, "Single", 80.0));
        hotelManager.addRoom(new Room(102, "Double", 120.0));
        hotelManager.addRoom(new Room(103, "Suite", 200.0));

        System.out.println("=== Available Rooms ===");
        hotelManager.getAvailableRooms().forEach(System.out::println);

        // Create a reservation
        System.out.println("\n=== Creating Reservation ===");
        Reservation reservation = hotelManager.createReservation(
                "Maya",
                101,
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        System.out.println("Reservation created:");
        System.out.println(reservation);

        // Show available rooms after booking
        System.out.println("\n=== Available Rooms After Booking ===");
        hotelManager.getAvailableRooms().forEach(System.out::println);

        // Check in
        System.out.println("\n=== Checking In ===");
        hotelManager.checkIn(reservation.getReservationId());
        System.out.println("Checked in reservation:");
        System.out.println(reservation);

        // Check out
        System.out.println("\n=== Checking Out ===");
        hotelManager.checkOut(reservation.getReservationId());
        System.out.println("Checked out reservation:");
        System.out.println(reservation);

        // Show available rooms after checkout
        System.out.println("\n=== Available Rooms After Checkout ===");
        hotelManager.getAvailableRooms().forEach(System.out::println);

        // Show total price
        System.out.println("\nTotal price: $" + reservation.calculateTotalPrice());
    }
}
