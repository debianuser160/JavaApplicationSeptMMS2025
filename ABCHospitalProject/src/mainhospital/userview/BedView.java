package mainhospital.userview;

import mainhospital.models.Bed;

import java.util.List;

public class BedView {

    // =========================================================
    // DISPLAY ALL BEDS
    // =========================================================

    public void displayBeds(List<Bed> beds) {

        if (beds == null || beds.isEmpty()) {
            System.out.println("No beds found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================================================");

        System.out.printf(
                "%-7s %-12s %-20s %-16s %-14s %-10s%n",
                "Bed ID", "Bed Number", "Ward", "Room", "Room Type", "Occupied"
        );

        System.out.println("--------------------------------------------------------------------------------------");

        for (Bed bed : beds) {

            String wardName = "N/A";
            String roomNumber = "N/A";
            String roomType = "N/A";

            if (bed.getRoom() != null) {

                roomNumber = bed.getRoom().getRoomNumber();
                roomType = bed.getRoom().getRoomType();

                if (bed.getRoom().getWard() != null) {
                    wardName = bed.getRoom().getWard().getName();
                }
            }

            System.out.printf(
                    "%-7d %-12s %-20s %-16s %-14s %-10s%n",
                    bed.getId(),
                    bed.getBedNumber(),
                    wardName,
                    roomNumber,
                    roomType,
                    bed.isOccupied() ? "Yes" : "No"
            );
        }

        System.out.println("======================================================================================");
    }


    // =========================================================
    // DISPLAY ONE BED
    // =========================================================

    public void displayBed(Bed bed) {

        if (bed == null) {
            System.out.println("Bed not found.");
            return;
        }

        String wardName = "N/A";
        String roomNumber = "N/A";
        String roomType = "N/A";
        int roomId = 0;

        if (bed.getRoom() != null) {

            roomId = bed.getRoom().getId();
            roomNumber = bed.getRoom().getRoomNumber();
            roomType = bed.getRoom().getRoomType();

            if (bed.getRoom().getWard() != null) {
                wardName = bed.getRoom().getWard().getName();
            }
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                  BED DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-15s : %s%n", "Bed ID", bed.getId());
        System.out.printf("%-15s : %s%n", "Bed Number", bed.getBedNumber());
        System.out.printf("%-15s : %s%n", "Room ID", roomId);
        System.out.printf("%-15s : %s%n", "Room Number", roomNumber);
        System.out.printf("%-15s : %s%n", "Room Type", roomType);
        System.out.printf("%-15s : %s%n", "Ward", wardName);
        System.out.printf("%-15s : %s%n", "Occupied", bed.isOccupied() ? "Yes" : "No");

        System.out.println("======================================================");
    }
}