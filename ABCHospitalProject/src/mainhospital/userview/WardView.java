package mainhospital.userview;

import mainhospital.models.Ward;

import java.util.List;

public class WardView {

    // =========================================================
    // DISPLAY ALL WARDS
    // =========================================================

    public void displayWards(List<Ward> wards) {

        if (wards == null || wards.isEmpty()) {
            System.out.println("No wards found.");
            return;
        }

        System.out.println();
        System.out.println("==========================================================");

        System.out.printf(
                "%-8s %-20s %-20s %-10s%n",
                "Ward ID", "Name", "Type", "Capacity"
        );

        System.out.println("----------------------------------------------------------");

        for (Ward ward : wards) {

            System.out.printf(
                    "%-8d %-20s %-20s %-10d%n",
                    ward.getId(),
                    ward.getName(),
                    ward.getWardType(),
                    ward.getCapacity()
            );
        }

        System.out.println("==========================================================");
    }


    // =========================================================
    // DISPLAY ONE WARD
    // =========================================================

    public void displayWard(Ward ward) {

        if (ward == null) {
            System.out.println("Ward not found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                  WARD DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-15s : %s%n", "Ward ID", ward.getId());
        System.out.printf("%-15s : %s%n", "Name", ward.getName());
        System.out.printf("%-15s : %s%n", "Type", ward.getWardType());
        System.out.printf("%-15s : %s%n", "Capacity", ward.getCapacity());

        System.out.println("======================================================");
    }
}