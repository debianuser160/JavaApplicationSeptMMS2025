package mainhospital.userview;

import mainhospital.models.Diagnosis;

import java.util.List;

public class DiagnosisView {

    // =========================================================
    // DISPLAY ALL DIAGNOSES
    // =========================================================

    public void displayDiagnoses(List<Diagnosis> diagnoses) {

        if (diagnoses == null || diagnoses.isEmpty()) {
            System.out.println("No diagnoses currently.");
            return;
        }

        System.out.println();
        System.out.println("======================================================================================");

        System.out.printf(
                "%-6s %-18s %-18s %-20s %-12s%n",
                "ID", "Patient", "Doctor", "Condition", "Date"
        );

        System.out.println("--------------------------------------------------------------------------------------");

        for (Diagnosis diagnosis : diagnoses) {

            String patientName = diagnosis.getPatient().getFirstName()
                    + " " + diagnosis.getPatient().getLastName();

            String doctorName = "Dr. " + diagnosis.getDoctor().getFirstName()
                    + " " + diagnosis.getDoctor().getLastName();

            System.out.printf(
                    "%-6d %-18s %-18s %-20s %-12s%n",
                    diagnosis.getId(),
                    patientName,
                    doctorName,
                    diagnosis.getConditionName(),
                    diagnosis.getDiagnosisDate()
            );
        }

        System.out.println("======================================================================================");
    }


    // =========================================================
    // DISPLAY ONE DIAGNOSIS
    // =========================================================

    public void displayDiagnosis(Diagnosis diagnosis) {

        if (diagnosis == null) {
            System.out.println("Diagnosis not found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                DIAGNOSIS DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-16s : %s%n", "Diagnosis ID", diagnosis.getId());
        System.out.printf("%-16s : %s %s%n", "Patient",
                diagnosis.getPatient().getFirstName(), diagnosis.getPatient().getLastName());
        System.out.printf("%-16s : Dr. %s %s%n", "Doctor",
                diagnosis.getDoctor().getFirstName(), diagnosis.getDoctor().getLastName());
        System.out.printf("%-16s : %s%n", "Condition", diagnosis.getConditionName());
        System.out.printf("%-16s : %s%n", "Date", diagnosis.getDiagnosisDate());
        System.out.printf("%-16s : %s%n", "Description", diagnosis.getDescription());
        System.out.printf("%-16s : %s%n", "Notes", diagnosis.getNotes());

        System.out.println("======================================================");
    }
}