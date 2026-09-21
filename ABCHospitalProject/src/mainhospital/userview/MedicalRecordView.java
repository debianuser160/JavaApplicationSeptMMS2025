package mainhospital.userview;

import mainhospital.models.Admission;
import mainhospital.models.Diagnosis;
import mainhospital.models.MedicalRecord;
import mainhospital.models.Treatment;

public class MedicalRecordView {

    // =========================================================
    // DISPLAY FULL MEDICAL HISTORY
    // =========================================================

    public void displayMedicalRecord(MedicalRecord record) {

        if (record == null) {
            System.out.println("No medical record found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("            PATIENT MEDICAL HISTORY");
        System.out.println("======================================================");

        System.out.printf("%-16s : %s%n", "Record ID", record.getId());
        System.out.printf("%-16s : %s %s%n", "Patient",
                record.getPatient().getFirstName(), record.getPatient().getLastName());
        System.out.printf("%-16s : %s%n", "Created", record.getCreatedDate());

        System.out.println();
        System.out.println("--- DIAGNOSES ---");

        if (record.getDiagnoses().isEmpty()) {
            System.out.println("None recorded.");
        } else {
            for (Diagnosis d : record.getDiagnoses()) {
                System.out.println("- " + d.getDiagnosisDate() + " : " + d.getConditionName());
            }
        }

        System.out.println();
        System.out.println("--- TREATMENTS ---");

        if (record.getTreatment().isEmpty()) {
            System.out.println("None recorded.");
        } else {
            for (Treatment t : record.getTreatment()) {
                System.out.println("- " + t.getTreatmentDate() + " : "
                        + t.getTreatmentName() + " (" + t.getStatus() + ")");
            }
        }

        System.out.println();
        System.out.println("--- ADMISSIONS ---");

        if (record.getAdmission().isEmpty()) {
            System.out.println("None recorded.");
        } else {
            for (Admission a : record.getAdmission()) {
                System.out.println("- " + a.getAdmissionDate() + " : "
                        + a.getReason() + " (" + a.getStatus() + ")");
            }
        }

        System.out.println("======================================================");
    }
}