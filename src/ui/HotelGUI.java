package ui;

import model.Room;
import service.HotelManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class HotelGUI {

    public static void main(String[] args) {

        HotelManager manager = new HotelManager();

        // Sample data
        manager.addRoom(new Room(101, "Single", 80));
        manager.addRoom(new Room(102, "Double", 120));
        manager.addRoom(new Room(103, "Suite", 200));

        JFrame frame = new JFrame("Hotel Booking System");

        JLabel titleLabel = new JLabel("Hotel Booking System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextArea output = new JTextArea(12, 35);
        output.setEditable(false);

        JButton showRoomsBtn = new JButton("Show Available Rooms");
        JButton reserveRoomBtn = new JButton("Create Sample Reservation");

        showRoomsBtn.addActionListener(e -> {
            output.setText("Available Rooms:\n");
            for (Room room : manager.getAvailableRooms()) {
                output.append(room.toString() + "\n");
            }
        });

        reserveRoomBtn.addActionListener(e -> {
            try {
                manager.createReservation(
                        "Guest",
                        101,
                        LocalDate.now(),
                        LocalDate.now().plusDays(2)
                );
                output.setText("Reservation created successfully for Room 101.\n");
            } catch (Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showRoomsBtn);
        buttonPanel.add(reserveRoomBtn);

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
