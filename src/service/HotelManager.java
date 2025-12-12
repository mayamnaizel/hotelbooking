package service;

import model.Room;
import model.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages hotel rooms and reservations.
 * This class contains the core business logic of the system.
 */
public class HotelManager {

    private List<Room> rooms;
    private List<Reservation> reservations;

    /**
     * Creates a new HotelManager with empty room and reservation lists.
     */
    public HotelManager() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    /* =========================
       ROOM MANAGEMENT (ADMIN)
       ========================= */

    /**
     * Adds a new room to the hotel.
     *
     * @param room the room to add
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Returns a list of all rooms.
     *
     * @return list of rooms
     */
    public List<Room> getAllRooms() {
        return rooms;
    }

    /**
     * Returns a list of available rooms only.
     *
     * @return list of available rooms
     */
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /* =========================
       RESERVATION MANAGEMENT
       ========================= */

    /**
     * Creates a reservation for a given room.
     *
     * @param guestName name of the guest
     * @param roomNumber room number to reserve
     * @param startDate check-in date
     * @param endDate check-out date
     * @return created Reservation
     */
    public Reservation createReservation(String guestName,
                                         int roomNumber,
                                         LocalDate startDate,
                                         LocalDate endDate) {

        Room room = findRoomByNumber(roomNumber);

        if (room == null) {
            throw new IllegalArgumentException("Room not found.");
        }

        if (!room.isAvailable()) {
            throw new IllegalStateException("Room is not available.");
        }

        Reservation reservation =
                new Reservation(guestName, room, startDate, endDate);

        room.setAvailable(false);
        reservations.add(reservation);

        return reservation;
    }

    /**
     * Cancels an existing reservation.
     *
     * @param reservationId ID of the reservation
     */
    public void cancelReservation(int reservationId) {
        Reservation reservation = findReservationById(reservationId);

        if (reservation == null) {
            throw new IllegalArgumentException("Reservation not found.");
        }

        reservation.getRoom().setAvailable(true);
        reservations.remove(reservation);
    }

    /**
     * Checks in a guest for a reservation.
     *
     * @param reservationId ID of the reservation
     */
    public void checkIn(int reservationId) {
        Reservation reservation = findReservationById(reservationId);

        if (reservation == null) {
            throw new IllegalArgumentException("Reservation not found.");
        }

        reservation.checkIn();
    }

    /**
     * Checks out a guest and frees the room.
     *
     * @param reservationId ID of the reservation
     */
    public void checkOut(int reservationId) {
        Reservation reservation = findReservationById(reservationId);

        if (reservation == null) {
            throw new IllegalArgumentException("Reservation not found.");
        }

        reservation.checkOut();
        reservation.getRoom().setAvailable(true);
    }

    /**
     * Returns all reservations.
     *
     * @return list of reservations
     */
    public List<Reservation> getAllReservations() {
        return reservations;
    }

    /* =========================
       HELPER METHODS
       ========================= */

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private Reservation findReservationById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }
}
