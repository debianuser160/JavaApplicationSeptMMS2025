package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WardDAO {

    // =========================================================
    // CREATE WARD
    // =========================================================

    public boolean addWard(Ward ward) {

        String sql = "INSERT INTO Ward (Name, WardType, Capacity) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, ward.getName());
            statement.setString(2, ward.getWardType());
            statement.setInt(3, ward.getCapacity());

            int rows = statement.executeUpdate();

            if (rows > 0) {

                ResultSet keys = statement.getGeneratedKeys();

                if (keys.next()) {
                    ward.setId(keys.getInt(1));
                }

                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating ward: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL WARDS
    // =========================================================

    public List<Ward> findAllWards() {

        List<Ward> wards = new ArrayList<>();

        String sql = "SELECT WardId, Name, WardType, Capacity FROM Ward ORDER BY WardId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                wards.add(mapWard(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving wards: " + e.getMessage());
        }

        return wards;
    }


    // =========================================================
    // FIND WARD BY ID
    // =========================================================

    public Ward findWardById(int wardId) {

        String sql = "SELECT WardId, Name, WardType, Capacity FROM Ward WHERE WardId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, wardId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Ward ward = mapWard(resultSet);
                connection.close();
                return ward;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding ward: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE WARD
    // =========================================================

    public boolean update(Ward ward) {

        String sql = "UPDATE Ward SET Name = ?, WardType = ?, Capacity = ? WHERE WardId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, ward.getName());
            statement.setString(2, ward.getWardType());
            statement.setInt(3, ward.getCapacity());
            statement.setInt(4, ward.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating ward: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // DELETE WARD
    // =========================================================

    public boolean delete(int wardId) {

        String sql = "DELETE FROM Ward WHERE WardId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, wardId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting ward: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // MAP RESULTSET TO WARD
    // =========================================================

    private Ward mapWard(ResultSet resultSet) throws SQLException {

        Ward ward = new Ward();

        ward.setId(resultSet.getInt("WardId"));
        ward.setName(resultSet.getString("Name"));
        ward.setWardType(resultSet.getString("WardType"));
        ward.setCapacity(resultSet.getInt("Capacity"));

        return ward;
    }
}