package com.thenobrainguy.nobrainclient;

import java.sql.*;

public class DatabaseManager {

    private static final String URL = "jdbc:mariadb://79.249.76.121:3306/nobrainclient";
    private static final String USER = "client_user";
    private static final String PASSWORD = "D4aT1btmtQMDMb9KPq4Jng";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed.");
        }
    }

    public static void checkUuid(String playerUuid) { // Parameter already exists
        System.out.println("Checking UUID: " + playerUuid);

        try (Connection connection = connect()) {

            // Check if the UUID is in the whitelist
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM whitelist WHERE uuid = ?")) {
                stmt.setString(1, playerUuid);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Player is whitelisted.");
                    return;
                }
            }

            // Check if the UUID is in the blacklist
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM blacklist WHERE uuid = ?")) {
                stmt.setString(1, playerUuid);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Player is blacklisted. Exiting game.");
                    throw new RuntimeException("Access denied. Player is blacklisted.");
                }
            }

            // If UUID is neither whitelisted nor blacklisted, exit
            System.out.println("Player is not whitelisted. Exiting game.");
            throw new RuntimeException("Access denied. Player is not whitelisted.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during UUID verification.");
        }
    }
}
