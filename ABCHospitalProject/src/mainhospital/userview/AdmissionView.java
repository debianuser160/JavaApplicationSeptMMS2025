package mainhospital.userview;

import mainhospital.models.Admission;

import java.util.List;

public class AdmissionView {

    // =========================================================
    // DISPLAY ALL ADMISSIONS
    // =========================================================

    public void displayAdmissions(List<Admission> admissions) {

        if (admissions == null || admissions.isEmpty()) {
            System.out.println("No admissions found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================================================");

        System.out.printf(
                "%-6s %-18s %-14s %-8s %-12s %-10s%n",
                "ID", "Patient", "Ward/Bed", "Status", "Admitted", "Discharged"
        );

        System.out.println("--------------------------------------------------------------------------------------");

        for (Admission admission : admissions) {

            String patientName = admission.getPatient().getFirstName()
                    + " " + admission.getPatient().getLastName();

            String bedInfo = admission.getBed().getRoom().getWard().getName()
                    + " / " + admission.getBed().getBedNumber();

            String discharged = admission.getDischargeDate() != null
                    ? admission.getDischargeDate().toString()
                    : "-";

            System.out.printf(
                    "%-6d %-18s %-14s %-8s %-12s %-10s%n",
                    admission.getId(),
                    patientName,
                    bedInfo,
                    admission.getStatus(),
                    admission.getAdmissionDate(),
                    discharged
            );
        }

        System.out.println("======================================================================================");
    }


    // =========================================================
    // DISPLAY ONE ADMISSION
    // =========================================================

    public void displayAdmission(Admission admission) {

        if (admission == null) {
            System.out.println("Admission not found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("               ADMISSION DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-16s : %s%n", "Admission ID", admission.getId());
        System.out.printf("%-16s : %s %s%n", "Patient",
                admission.getPatient().getFirstName(), admission.getPatient().getLastName());
        System.out.printf("%-16s : %s%n", "Ward", admission.getBed().getRoom().getWard().getName());
        System.out.printf("%-16s : %s%n", "Room", admission.getBed().getRoom().getRoomNumber());
        System.out.printf("%-16s : %s%n", "Bed", admission.getBed().getBedNumber());
        System.out.printf("%-16s : %s%n", "Status", admission.getStatus());
        System.out.printf("%-16s : %s%n", "Admission Date", admission.getAdmissionDate());
        System.out.printf("%-16s : %s%n", "Discharge Date",
                admission.getDischargeDate() != null ? admission.getDischargeDate() : "-");
        System.out.printf("%-16s : %s%n", "Reason", admission.getReason());

        System.out.println("======================================================");
    }
}