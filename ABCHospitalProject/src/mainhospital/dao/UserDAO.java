package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.StaffRole;
import mainhospital.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // =========================================================
    // CREATE USER
    // =========================================================

    public boolean addUser(User user) {

        String sql = "INSERT INTO Users (Username, PasswordHash, Role, StaffId, IsActive) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPasswordHash());
            statement.setString(3, user.getRole().name());

            if (user.getStaffID() > 0) {
                statement.setInt(4, user.getStaffID());
            } else {
                statement.setNull(4, Types.INTEGER);
            }

            statement.setBoolean(5, user.isActive());

            int rows = statement.executeUpdate();

            if (rows > 0) {

                ResultSet keys = statement.getGeneratedKeys();

                if (keys.next()) {
                    user.setId(keys.getInt(1));
                }

                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating user: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL USERS
    // =========================================================

    public List<User> findAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT UserId, Username, PasswordHash, Role, StaffId, IsActive "
                   + "FROM Users ORDER BY UserId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(mapUser(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }

        return users;
    }


    // =========================================================
    // FIND USER BY ID
    // =========================================================

    public User findUserById(int userId) {

        String sql = "SELECT UserId, Username, PasswordHash, Role, StaffId, IsActive "
                   + "FROM Users WHERE UserId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = mapUser(resultSet);
                connection.close();
                return user;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding user: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // FIND USER BY USERNAME
    // =========================================================

    public User findByUsername(String username) {

        String sql = "SELECT UserId, Username, PasswordHash, Role, StaffId, IsActive "
                   + "FROM Users WHERE Username = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = mapUser(resultSet);
                connection.close();
                return user;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding user: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE USER (username, role, staff link)
    // =========================================================

    public boolean update(User user) {

        String sql = "UPDATE Users SET Username = ?, Role = ?, StaffId = ? WHERE UserId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getRole().name());

            if (user.getStaffID() > 0) {
                statement.setInt(3, user.getStaffID());
            } else {
                statement.setNull(3, Types.INTEGER);
            }

            statement.setInt(4, user.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // SET ACTIVE STATUS (used by activate/deactivate)
    // =========================================================

    public boolean setActiveStatus(int userId, boolean active) {

        String sql = "UPDATE Users SET IsActive = ? WHERE UserId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setBoolean(1, active);
            statement.setInt(2, userId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating user status: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // RESET PASSWORD
    // =========================================================

    public boolean resetPassword(int userId, String newPassword) {

        String sql = "UPDATE Users SET PasswordHash = ? WHERE UserId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, newPassword);
            statement.setInt(2, userId);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error resetting password: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // MAP RESULTSET TO USER
    // =========================================================

    private User mapUser(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("UserId");
        String username = resultSet.getString("Username");
        String passwordHash = resultSet.getString("PasswordHash");

        StaffRole role = StaffRole.valueOf(resultSet.getString("Role"));

        int staffID = resultSet.getInt("StaffId");

        if (resultSet.wasNull()) {
            staffID = 0;
        }

        boolean active = resultSet.getBoolean("IsActive");

        User user = new User(id, username, passwordHash, role, null, active);
        user.setStaffID(staffID);

        return user;
    }
}