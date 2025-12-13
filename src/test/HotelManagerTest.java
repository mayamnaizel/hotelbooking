package test;

import model.Room;
import model.Reservation;
import service.HotelManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


 //unit tests for HotelManager class.

public class HotelManagerTest {

    private HotelManager hotelManager;

    @BeforeEach
    void setUp() {
        hotelManager = new HotelManager();

        // Add sample rooms before each test
        hotelManager.addRoom(new Room(101, "Single", 80.0));
        hotelManager.addRoom(new Room(102, "Double", 120.0));
    }


     //test that a reservation can be created successfully.

    @Test
    void testCreateReservation() {
        Reservation reservation = hotelManager.createReservation(
                "Maya",
                101,
                LocalDate.now(),
                LocalDate.now().plusDays(3)
        );

        assertNotNull(reservation);
        assertEquals("Maya", reservation.getGuestName());
        assertFalse(reservation.getRoom().isAvailable());
    }


     //test that only available rooms are returned.

    @Test
    void testGetAvailableRooms() {
        hotelManager.createReservation(
                "Ali",
                101,
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        assertEquals(1, hotelManager.getAvailableRooms().size());
        assertEquals(102, hotelManager.getAvailableRooms().get(0).getRoomNumber());
    }


    //test total price calculation for a reservation.

    @Test
    void testCalculateTotalPrice() {
        Reservation reservation = hotelManager.createReservation(
                "Sara",
                102,
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        double expectedPrice = 2 * 120.0;
        assertEquals(expectedPrice, reservation.calculateTotalPrice());
    }


     //test that cancelling a reservation frees the room.

    @Test
    void testCancelReservation() {
        Reservation reservation = hotelManager.createReservation(
                "Omar",
                101,
                LocalDate.now(),
                LocalDate.now().plusDays(1)
        );

        hotelManager.cancelReservation(reservation.getReservationId());

        assertTrue(hotelManager.getAvailableRooms().size() == 2);
    }
}
