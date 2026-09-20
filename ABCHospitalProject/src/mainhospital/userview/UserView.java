package mainhospital.userview;

import mainhospital.models.User;

import java.util.List;

public class UserView {

    // =========================================================
    // DISPLAY ALL USERS
    // =========================================================

    public void displayUsers(List<User> users) {

        if (users == null || users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println();
        System.out.println("==================================================================");

        System.out.printf(
                "%-8s %-20s %-24s %-10s %-8s%n",
                "User ID", "Username", "Role", "Staff ID", "Active"
        );

        System.out.println("------------------------------------------------------------------");

        for (User user : users) {

            String staffIdDisplay = user.getStaffID() > 0
                    ? String.valueOf(user.getStaffID())
                    : "N/A";

            System.out.printf(
                    "%-8d %-20s %-24s %-10s %-8s%n",
                    user.getId(),
                    user.getUsername(),
                    user.getRole(),
                    staffIdDisplay,
                    user.isActive() ? "Yes" : "No"
            );
        }

        System.out.println("==================================================================");
    }


    // =========================================================
    // DISPLAY ONE USER
    // =========================================================

    public void displayUser(User user) {

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        String staffIdDisplay = user.getStaffID() > 0
                ? String.valueOf(user.getStaffID())
                : "N/A";

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                 USER DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-15s : %s%n", "User ID", user.getId());
        System.out.printf("%-15s : %s%n", "Username", user.getUsername());
        System.out.printf("%-15s : %s%n", "Role", user.getRole());
        System.out.printf("%-15s : %s%n", "Staff ID", staffIdDisplay);
        System.out.printf("%-15s : %s%n", "Active", user.isActive() ? "Yes" : "No");

        System.out.println("======================================================");
    }
}