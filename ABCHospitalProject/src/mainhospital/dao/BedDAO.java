package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Bed;
import mainhospital.models.Room;
import mainhospital.models.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BedDAO {

    // =========================================================
    // CREATE BED
    // =========================================================

    public boolean addBed(Bed bed) {

        String sql = "INSERT INTO Bed (BedNumber, RoomId, Occupied) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, bed.getBedNumber());
            statement.setInt(2, bed.getRoom().getId());
            statement.setBoolean(3, bed.isOccupied());

            int rows = statement.executeUpdate();

            if (rows > 0) {

                ResultSet keys = statement.getGeneratedKeys();

                if (keys.next()) {
                    bed.setId(keys.getInt(1));
                }

                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating bed: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL BEDS
    // =========================================================

    public List<Bed> findAllBeds() {

        List<Bed> beds = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY b.BedId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                beds.add(mapBed(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving beds: " + e.getMessage());
        }

        return beds;
    }


    // =========================================================
    // FIND BEDS BY ROOM
    // =========================================================

    public List<Bed> findBedsByRoom(int roomId) {

        List<Bed> beds = new ArrayList<>();

        String sql = baseSelect() + " WHERE b.RoomId = ? ORDER BY b.BedId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                beds.add(mapBed(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving beds for room: " + e.getMessage());
        }

        return beds;
    }


    // =========================================================
    // FIND AVAILABLE BEDS
    // =========================================================

    public List<Bed> findAvailableBeds() {

        List<Bed> beds = new ArrayList<>();

        String sql = baseSelect() + " WHERE b.Occupied = 0 ORDER BY b.BedId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                beds.add(mapBed(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving available beds: " + e.getMessage());
        }

        return beds;
    }


    // =========================================================
    // FIND OCCUPIED BEDS
    // =========================================================

    public List<Bed> findOccupiedBeds() {

        List<Bed> beds = new ArrayList<>();

        String sql = baseSelect() + " WHERE b.Occupied = 1 ORDER BY b.BedId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                beds.add(mapBed(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving occupied beds: " + e.getMessage());
        }

        return beds;
    }


    // =========================================================
    // FIND BED BY ID
    // =========================================================

    public Bed findBedById(int bedId) {

        String sql = baseSelect() + " WHERE b.BedId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bedId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Bed bed = mapBed(resultSet);
                connection.close();
                return bed;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding bed: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE BED (number / room only - not occupied status)
    // =========================================================

    public boolean update(Bed bed) {

        String sql = "UPDATE Bed SET BedNumber = ?, RoomId = ? WHERE BedId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, bed.getBedNumber());
            statement.setInt(2, bed.getRoom().getId());
            statement.setInt(3, bed.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating bed: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // SET OCCUPIED STATUS (used by Admission check-in / discharge)
    // =========================================================

    public boolean setOccupied(int bedId, boolean occupied) {

        String sql = "UPDATE Bed SET Occupied = ? WHERE BedId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setBoolean(1, occupied);
            statement.setInt(2, bedId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating bed status: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // DELETE BED
    // =========================================================

    public boolean delete(int bedId) {

        String sql = "DELETE FROM Bed WHERE BedId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bedId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting bed: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // BASE SELECT (shared by every read method above)
    // =========================================================

    private String baseSelect() {

        return "SELECT b.BedId, b.BedNumber, b.RoomId, b.Occupied, "
             + "r.RoomNumber, r.RoomType, r.Capacity AS RoomCapacity, "
             + "w.WardId, w.Name AS WardName "
             + "FROM Bed b "
             + "INNER JOIN Room r ON b.RoomId = r.RoomId "
             + "INNER JOIN Ward w ON r.WardId = w.WardId";
    }


    // =========================================================
    // MAP RESULTSET TO BED
    // =========================================================

    private Bed mapBed(ResultSet resultSet) throws SQLException {

        Bed bed = new Bed();

        bed.setId(resultSet.getInt("BedId"));
        bed.setBedNumber(resultSet.getString("BedNumber"));
        bed.setOccupied(resultSet.getBoolean("Occupied"));

        Ward ward = new Ward();
        ward.setId(resultSet.getInt("WardId"));
        ward.setName(resultSet.getString("WardName"));

        Room room = new Room();
        room.setId(resultSet.getInt("RoomId"));
        room.setRoomNumber(resultSet.getString("RoomNumber"));
        room.setRoomType(resultSet.getString("RoomType"));
        room.setCapacity(resultSet.getInt("RoomCapacity"));
        room.setWard(ward);

        bed.setRoom(room);

        return bed;
    }
}