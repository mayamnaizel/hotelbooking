package model;

/**
 * Represents a hotel room in the booking system.
 * A room has a number, type, price per night, and availability status.
 */
public class Room {

    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean available;

    /**
     * Constructor to create a new Room.
     *
     * @param roomNumber the unique room number
     * @param roomType the type of the room (Single, Double)
     * @param pricePerNight the cost per night
     */
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.available = true; // rooms start as available
    }

    // Getters

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void updatePrice(double newPrice) {
        this.pricePerNight = newPrice;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber +
                " (" + roomType + ") - $" +
                pricePerNight +
                " per night - Available: " +
                available;
    }
}
