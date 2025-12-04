package com.example.tasktracker;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    @Test
    void testConnection() throws Exception {
        try (Connection conn = Database.getConnection()) {
            assertNotNull(conn);
            System.out.println("Verbindung erfolgreich!");
        }
    }
}
