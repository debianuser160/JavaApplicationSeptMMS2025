    package mainhospital.userview;

import mainhospital.models.LaboratoryTechnician;

import java.util.List;

public class LaboratoryTechnicianView {

    // =========================================================
    // DISPLAY ALL LABORATORY TECHNICIANS
    // =========================================================

    public void displayLaboratoryTechnicians(
            List<LaboratoryTechnician> technicians
    ) {

        if (technicians == null ||
                technicians.isEmpty()) {

            System.out.println(
                    "No laboratory technicians found."
            );

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

        for (LaboratoryTechnician technician : technicians) {

            String departmentName =
                    "N/A";

            if (technician.getDepartment() != null) {

                departmentName =
                        technician.getDepartment()
                                .getName();
            }

            System.out.printf(
                    "%-5d %-12s %-12s %-7s %-12s %-15s %-22s %-18s %-18s %-18s %-12.2f%n",

                    technician.getStaffID(),
                    technician.getFirstName(),
                    technician.getLastName(),
                    technician.getGender(),
                    technician.getPhone(),
                    technician.getCity(),
                    departmentName,
                    technician.getQualification(),
                    technician.getLicenseNumber(),
                    technician.getEmploymentDate(),
                    technician.getSalary()
            );
        }

        System.out.println(
                "==========================================================================================================================================================================" 
        );
    }


    // =========================================================
    // DISPLAY ONE LABORATORY TECHNICIAN
    // =========================================================

    public void displayLaboratoryTechnician(
            LaboratoryTechnician technician
    ) {

        if (technician == null) {

            System.out.println(
                    "Laboratory technician not found."
            );

            return;
        }

        String departmentName =
                "N/A";

        int departmentId = 0;

        if (technician.getDepartment() != null) {

            departmentId =
                    technician.getDepartment()
                            .getId();

            departmentName =
                    technician.getDepartment()
                            .getName();
        }


        System.out.println();

        System.out.println(
                "======================================================"
        );

        System.out.println(
                "          LABORATORY TECHNICIAN DETAILS"
        );

        System.out.println(
                "======================================================"
        );

        System.out.printf(
                "%-20s : %s%n",
                "Staff ID",
                technician.getStaffID()
        );

        System.out.printf(
                "%-20s : %s%n",
                "First Name",
                technician.getFirstName()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Last Name",
                technician.getLastName()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Gender",
                technician.getGender()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Date of Birth",
                technician.getDateOfBirth()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Phone",
                technician.getPhone()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Email",
                technician.getEmail()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Street",
                technician.getStreet()
        );

        System.out.printf(
                "%-20s : %s%n",
                "City",
                technician.getCity()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Country",
                technician.getCountry()
        );

        System.out.println(
                "------------------------------------------------------"
        );

        System.out.printf(
                "%-20s : %s%n",
                "Staff ID",
                technician.getStaffID()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Employment Date",
                technician.getEmploymentDate()
        );

        System.out.printf(
                "%-20s : %.2f%n",
                "Salary",
                technician.getSalary()
        );

        System.out.printf(
                "%-20s : %s%n",
                "Department ID",
                departmentId
        );

        System.out.printf(
                "%-20s : %s%n",
                "Department",
                departmentName
        );

        System.out.println(
                "------------------------------------------------------"
        );

        System.out.printf(
                "%-20s : %s%n",
                "Qualification",
                technician.getQualification()
        );

        System.out.printf(
                "%-20s : %s%n",
                "License Number",
                technician.getLicenseNumber()
        );

        System.out.println(
                "======================================================"
        );
    }
}