package mainhospital.userview;

import mainhospital.models.NurseAssignment;

import java.util.List;

public class NurseAssignmentView {

    // =========================================================
    // DISPLAY ALL ASSIGNMENTS
    // =========================================================

    public void displayAssignments(List<NurseAssignment> assignments) {

        if (assignments == null || assignments.isEmpty()) {
            System.out.println("No nurse assignments found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================================================");

        System.out.printf(
                "%-6s %-18s %-18s %-10s %-10s%n",
                "ID", "Nurse", "Patient", "Shift", "Status"
        );

        System.out.println("--------------------------------------------------------------------------------------");

        for (NurseAssignment assignment : assignments) {

            String nurseName = assignment.getNurse().getFirstName()
                    + " " + assignment.getNurse().getLastName();

            String patientName = assignment.getPatient().getFirstName()
                    + " " + assignment.getPatient().getLastName();

            System.out.printf(
                    "%-6d %-18s %-18s %-10s %-10s%n",
                    assignment.getId(),
                    nurseName,
                    patientName,
                    assignment.getShift(),
                    assignment.getStatus()
            );
        }

        System.out.println("======================================================================================");
    }


    // =========================================================
    // DISPLAY ONE ASSIGNMENT
    // =========================================================

    public void displayAssignment(NurseAssignment assignment) {

        if (assignment == null) {
            System.out.println("Assignment not found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("             NURSE ASSIGNMENT DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-16s : %s%n", "Assignment ID", assignment.getId());
        System.out.printf("%-16s : %s %s%n", "Nurse",
                assignment.getNurse().getFirstName(), assignment.getNurse().getLastName());
        System.out.printf("%-16s : %s %s%n", "Patient",
                assignment.getPatient().getFirstName(), assignment.getPatient().getLastName());
        System.out.printf("%-16s : %s%n", "Admission ID",
                assignment.getAdmission() != null ? assignment.getAdmission().getId() : "N/A");
        System.out.printf("%-16s : %s%n", "Shift", assignment.getShift());
        System.out.printf("%-16s : %s%n", "Status", assignment.getStatus());
        System.out.printf("%-16s : %s%n", "Assigned", assignment.getAssingmentDate());
        System.out.printf("%-16s : %s%n",
                "Ended", assignment.getEndDate() != null ? assignment.getEndDate() : "-");
        System.out.printf("%-16s : %s%n", "Notes", assignment.getNotes());

        System.out.println("======================================================");
    }
}