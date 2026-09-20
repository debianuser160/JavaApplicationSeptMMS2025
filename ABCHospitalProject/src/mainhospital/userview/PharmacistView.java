package mainhospital.userview;

import mainhospital.models.Pharmacist;

import java.util.List;

public class PharmacistView {

    // =========================================================
    // DISPLAY ALL PHARMACISTS
    // =========================================================

    public void displayPharmacists(List<Pharmacist> pharmacists) {

        if (pharmacists == null || pharmacists.isEmpty()) {

            System.out.println("No pharmacists found.");

            return;
        }

        System.out.println();

        System.out.println(
                "=========================================================================================================================================================================="
        );

        System.out.printf(
                "%-5s %-12s %-12s %-7s %-12s %-15s %-22s %-18s %-18s %-18s %-12s%n",
                "Staff ID",
                "First Name",
                "Last Name",
                "Gender",
                "Phone",
                "City",
                "Department",
                "Qualification",
                "License No.",
                "Employment Date",
                "Salary"
        );

        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
        );

        for (Pharmacist pharmacist : pharmacists) {

            String departmentName = "N/A";

            if (pharmacist.getDepartment() != null) {
                departmentName = pharmacist.getDepartment().getName();
            }

            System.out.printf(
                    "%-5d %-12s %-12s %-7s %-12s %-15s %-22s %-18s %-18s %-18s %-12.2f%n",

                    pharmacist.getStaffID(),
                    pharmacist.getFirstName(),
                    pharmacist.getLastName(),
                    pharmacist.getGender(),
                    pharmacist.getPhone(),
                    pharmacist.getCity(),
                    departmentName,
                    pharmacist.getQualification(),
                    pharmacist.getLicenseNumber(),
                    pharmacist.getEmploymentDate(),
                    pharmacist.getSalary()
            );
        }

        System.out.println(
                "=========================================================================================================================================================================="
        );
    }


    // =========================================================
    // DISPLAY ONE PHARMACIST
    // =========================================================

    public void displayPharmacist(Pharmacist pharmacist) {

        if (pharmacist == null) {

            System.out.println("Pharmacist not found.");

            return;
        }

        String departmentName = "N/A";

        int departmentId = 0;

        if (pharmacist.getDepartment() != null) {

            departmentId = pharmacist.getDepartment().getId();
            departmentName = pharmacist.getDepartment().getName();
        }

        System.out.println();

        System.out.println(
                "======================================================"
        );

        System.out.println(
                "              PHARMACIST DETAILS"
        );

        System.out.println(
                "======================================================"
        );

        System.out.printf("%-20s : %s%n", "Staff ID", pharmacist.getStaffID());
        System.out.printf("%-20s : %s%n", "First Name", pharmacist.getFirstName());
        System.out.printf("%-20s : %s%n", "Last Name", pharmacist.getLastName());
        System.out.printf("%-20s : %s%n", "Gender", pharmacist.getGender());
        System.out.printf("%-20s : %s%n", "Date of Birth", pharmacist.getDateOfBirth());
        System.out.printf("%-20s : %s%n", "Phone", pharmacist.getPhone());
        System.out.printf("%-20s : %s%n", "Email", pharmacist.getEmail());
        System.out.printf("%-20s : %s%n", "Street", pharmacist.getStreet());
        System.out.printf("%-20s : %s%n", "City", pharmacist.getCity());
        System.out.printf("%-20s : %s%n", "Country", pharmacist.getCountry());

        System.out.println(
                "------------------------------------------------------"
        );

        System.out.printf("%-20s : %s%n", "Staff ID", pharmacist.getStaffID());
        System.out.printf("%-20s : %s%n", "Employment Date", pharmacist.getEmploymentDate());
        System.out.printf("%-20s : %.2f%n", "Salary", pharmacist.getSalary());
        System.out.printf("%-20s : %s%n", "Department ID", departmentId);
        System.out.printf("%-20s : %s%n", "Department", departmentName);

        System.out.println(
                "------------------------------------------------------"
        );

        System.out.printf("%-20s : %s%n", "Qualification", pharmacist.getQualification());
        System.out.printf("%-20s : %s%n", "License Number", pharmacist.getLicenseNumber());

        System.out.println(
                "======================================================"
        );
    }
}