package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Room;
import mainhospital.models.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    // =========================================================
    // CREATE ROOM
    // =========================================================

    public boolean addRoom(Room room) {

        String sql = "INSERT INTO Room (RoomNumber, WardId, RoomType, Capacity) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, room.getRoomNumber());
            statement.setInt(2, room.getWard().getId());
            statement.setString(3, room.getRoomType());
            statement.setInt(4, room.getCapacity());

            int rows = statement.executeUpdate();

            if (rows > 0) {

                ResultSet keys = statement.getGeneratedKeys();

                if (keys.next()) {
                    room.setId(keys.getInt(1));
                }

                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating room: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL ROOMS
    // =========================================================

    public List<Room> findAllRooms() {

        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT r.RoomId, r.RoomNumber, r.WardId, r.RoomType, r.Capacity, "
                   + "w.Name AS WardName "
                   + "FROM Room r "
                   + "INNER JOIN Ward w ON r.WardId = w.WardId "
                   + "ORDER BY r.RoomId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                rooms.add(mapRoom(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving rooms: " + e.getMessage());
        }

        return rooms;
    }


    // =========================================================
    // FIND ROOMS BY WARD
    // =========================================================

    public List<Room> findRoomsByWard(int wardId) {

        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT r.RoomId, r.RoomNumber, r.WardId, r.RoomType, r.Capacity, "
                   + "w.Name AS WardName "
                   + "FROM Room r "
                   + "INNER JOIN Ward w ON r.WardId = w.WardId "
                   + "WHERE r.WardId = ? "
                   + "ORDER BY r.RoomId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, wardId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                rooms.add(mapRoom(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving rooms for ward: " + e.getMessage());
        }

        return rooms;
    }


    // =========================================================
    // FIND ROOM BY ID
    // =========================================================

    public Room findRoomById(int roomId) {

        String sql = "SELECT r.RoomId, r.RoomNumber, r.WardId, r.RoomType, r.Capacity, "
                   + "w.Name AS WardName "
                   + "FROM Room r "
                   + "INNER JOIN Ward w ON r.WardId = w.WardId "
                   + "WHERE r.RoomId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Room room = mapRoom(resultSet);
                connection.close();
                return room;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding room: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE ROOM
    // =========================================================

    public boolean update(Room room) {

        String sql = "UPDATE Room SET RoomNumber = ?, WardId = ?, RoomType = ?, Capacity = ? "
                   + "WHERE RoomId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, room.getRoomNumber());
            statement.setInt(2, room.getWard().getId());
            statement.setString(3, room.getRoomType());
            statement.setInt(4, room.getCapacity());
            statement.setInt(5, room.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating room: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // DELETE ROOM
    // =========================================================

    public boolean delete(int roomId) {

        String sql = "DELETE FROM Room WHERE RoomId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting room: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // MAP RESULTSET TO ROOM
    // =========================================================

    private Room mapRoom(ResultSet resultSet) throws SQLException {

        Room room = new Room();

        room.setId(resultSet.getInt("RoomId"));
        room.setRoomNumber(resultSet.getString("RoomNumber"));
        room.setRoomType(resultSet.getString("RoomType"));
        room.setCapacity(resultSet.getInt("Capacity"));

        Ward ward = new Ward();
        ward.setId(resultSet.getInt("WardId"));
        ward.setName(resultSet.getString("WardName"));

        room.setWard(ward);

        return room;
    }
}