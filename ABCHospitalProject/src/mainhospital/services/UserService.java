package mainhospital.services;

import mainhospital.dao.UserDAO;
import mainhospital.models.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }


    // =========================================================
    // LOGIN
    // =========================================================

    public User login(String username, String password) {

        User user = userDAO.findByUsername(username);

        if (user == null) {
            System.out.println("Username not found.");
            return null;
        }

        if (!user.isActive()) {
            System.out.println("This account is inactive.");
            return null;
        }

        if (!user.getPasswordHash().equals(password)) {
            System.out.println("Incorrect password.");
            return null;
        }

        return user;
    }


    // =========================================================
    // CREATE USER
    // =========================================================

    public boolean createUser(User user) {

        if (user == null) {
            System.out.println("User information is required.");
            return false;
        }

        if (user.getUsername() == null || user.getUsername().isBlank()) {
            System.out.println("Username is required.");
            return false;
        }

        if (user.getPasswordHash() == null || user.getPasswordHash().isBlank()) {
            System.out.println("Password is required.");
            return false;
        }

        if (user.getRole() == null) {
            System.out.println("Role is required.");
            return false;
        }

        if (userDAO.findByUsername(user.getUsername()) != null) {
            System.out.println("That username is already taken.");
            return false;
        }

        return userDAO.addUser(user);
    }


    // =========================================================
    // GET ALL USERS
    // =========================================================

    public List<User> getAllUsers() {

        return userDAO.findAllUsers();
    }


    // =========================================================
    // GET USER BY ID
    // =========================================================

    public User getUserById(int id) {

        if (id <= 0) {
            System.out.println("Invalid user ID.");
            return null;
        }

        return userDAO.findUserById(id);
    }


    // =========================================================
    // UPDATE USER
    // =========================================================

    public boolean updateUser(User user) {

        if (user == null || user.getId() <= 0) {
            System.out.println("Invalid user information.");
            return false;
        }

        if (user.getUsername() == null || user.getUsername().isBlank()) {
            System.out.println("Username is required.");
            return false;
        }

        if (user.getRole() == null) {
            System.out.println("Role is required.");
            return false;
        }

        return userDAO.update(user);
    }


    // =========================================================
    // DEACTIVATE USER
    // =========================================================

    public boolean deactivateUser(int id) {

        if (id <= 0) {
            System.out.println("Invalid user ID.");
            return false;
        }

        return userDAO.setActiveStatus(id, false);
    }


    // =========================================================
    // ACTIVATE USER
    // =========================================================

    public boolean activateUser(int id) {

        if (id <= 0) {
            System.out.println("Invalid user ID.");
            return false;
        }

        return userDAO.setActiveStatus(id, true);
    }


    // =========================================================
    // RESET PASSWORD
    // =========================================================

    public boolean resetPassword(int id, String newPassword) {

        if (id <= 0) {
            System.out.println("Invalid user ID.");
            return false;
        }

        if (newPassword == null || newPassword.isBlank()) {
            System.out.println("New password cannot be empty.");
            return false;
        }

        return userDAO.resetPassword(id, newPassword);
    }
}