package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a reservation made by a guest for a hotel room.
 * A reservation has a guest name, room, date range, and check-in status.
 */
public class Reservation {

    private static int counter = 1; // used to generate unique reservation IDs

    private int reservationId;
    private String guestName;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean checkedIn;

    /**
     * Constructor to create a new Reservation.
     *
     * @param guestName the name of the guest
     * @param room the room being reserved
     * @param startDate the check-in date
     * @param endDate the check-out date
     */
    public Reservation(String guestName, Room room,
                       LocalDate startDate, LocalDate endDate) {

        this.reservationId = counter++;
        this.guestName = guestName;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkedIn = false; // guest is not checked in initially
    }

    // Getters

    public int getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    // Behaviour methods

    /**
     * Marks the reservation as checked in.
     */
    public void checkIn() {
        this.checkedIn = true;
    }

    /**
     * Marks the reservation as checked out.
     */
    public void checkOut() {
        this.checkedIn = false;
    }

    /**
     * Calculates the total price of the reservation
     * based on number of nights and room price.
     *
     * @return total cost of the stay
     */
    public double calculateTotalPrice() {
        long nights = ChronoUnit.DAYS.between(startDate, endDate);
        return nights * room.getPricePerNight();
    }

    @Override
    public String toString() {
        return "Reservation #" + reservationId +
                " | Guest: " + guestName +
                " | Room: " + room.getRoomNumber() +
                " | From: " + startDate +
                " | To: " + endDate +
                " | Checked in: " + checkedIn;
    }
}
