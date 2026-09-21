package mainhospital.userview;

import mainhospital.models.Treatment;

import java.util.List;

public class TreatmentView {

    // =========================================================
    // DISPLAY ALL TREATMENTS
    // =========================================================

    public void displayTreatments(List<Treatment> treatments) {

        if (treatments == null || treatments.isEmpty()) {
            System.out.println("No treatments currently.");
            return;
        }

        System.out.println();
        System.out.println("======================================================================================");

        System.out.printf(
                "%-6s %-18s %-18s %-20s %-10s%n",
                "ID", "Patient", "Doctor", "Treatment", "Status"
        );

        System.out.println("--------------------------------------------------------------------------------------");

        for (Treatment treatment : treatments) {

            String patientName = treatment.getPatient().getFirstName()
                    + " " + treatment.getPatient().getLastName();

            String doctorName = "Dr. " + treatment.getDoctor().getFirstName()
                    + " " + treatment.getDoctor().getLastName();

            System.out.printf(
                    "%-6d %-18s %-18s %-20s %-10s%n",
                    treatment.getId(),
                    patientName,
                    doctorName,
                    treatment.getTreatmentName(),
                    treatment.getStatus()
            );
        }

        System.out.println("======================================================================================");
    }


    // =========================================================
    // DISPLAY ONE TREATMENT
    // =========================================================

    public void displayTreatment(Treatment treatment) {

        if (treatment == null) {
            System.out.println("Treatment not found.");
            return;
        }

        String diagnosisName = treatment.getDiagnosis() != null
                ? treatment.getDiagnosis().getConditionName()
                : "N/A";

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                TREATMENT DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-16s : %s%n", "Treatment ID", treatment.getId());
        System.out.printf("%-16s : %s %s%n", "Patient",
                treatment.getPatient().getFirstName(), treatment.getPatient().getLastName());
        System.out.printf("%-16s : Dr. %s %s%n", "Doctor",
                treatment.getDoctor().getFirstName(), treatment.getDoctor().getLastName());
        System.out.printf("%-16s : %s%n", "Linked Diagnosis", diagnosisName);
        System.out.printf("%-16s : %s%n", "Treatment", treatment.getTreatmentName());
        System.out.printf("%-16s : %s%n", "Date", treatment.getTreatmentDate());
        System.out.printf("%-16s : %s%n", "Status", treatment.getStatus());
        System.out.printf("%-16s : %s%n", "Description", treatment.getDescription());
        System.out.printf("%-16s : %s%n", "Notes", treatment.getNotes());

        System.out.println("======================================================");
    }
}