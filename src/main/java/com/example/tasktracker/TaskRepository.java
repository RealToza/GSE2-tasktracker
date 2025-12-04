package com.example.tasktracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public Task save(Task t) throws SQLException {
        String sql = """
            INSERT INTO Tasks (description, status)
            VALUES (?, ?);
            """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, t.getDescription());
            ps.setString(2, t.getStatus().name());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                t.setId(rs.getInt(1));
            }
        }
        return t;
    }

    public List<Task> findAll() throws SQLException {
        String sql = "SELECT id, description, status FROM Tasks;";
        List<Task> result = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Task t = new Task(rs.getString("description"));
                t.setId(rs.getInt("id"));
                t.setStatus(TaskStatus.valueOf(rs.getString("status")));
                result.add(t);
            }
        }
        return result;
    }

    public Task findById(int id) throws SQLException {
        String sql = "SELECT id, description, status FROM Tasks WHERE id = ?;";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Task t = new Task(rs.getString("description"));
                t.setId(rs.getInt("id"));
                t.setStatus(TaskStatus.valueOf(rs.getString("status")));
                return t;
            }
        }
        return null;
    }

    public boolean update(Task t) throws SQLException {
        String sql = """
            UPDATE Tasks
            SET description = ?, status = ?
            WHERE id = ?;
            """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, t.getDescription());
            ps.setString(2, t.getStatus().name());
            ps.setInt(3, t.getId());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Tasks WHERE id = ?;";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
