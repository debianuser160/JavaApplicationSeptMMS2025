package mainhospital.services;

import mainhospital.dao.MedicalRecordDAO;
import mainhospital.models.MedicalRecord;
import mainhospital.models.Patient;

import java.time.LocalDate;

public class MedicalRecordService {

    private final MedicalRecordDAO medicalRecordDAO;
    private final DiagnosisService diagnosisService;
    private final TreatmentService treatmentService;
    private final AdmissionService admissionService;

    public MedicalRecordService() {
        medicalRecordDAO = new MedicalRecordDAO();
        diagnosisService = new DiagnosisService();
        treatmentService = new TreatmentService();
        admissionService = new AdmissionService();
    }


    // =========================================================
    // CREATE MEDICAL RECORD (the "folder" for a patient)
    // =========================================================

    public boolean createMedicalRecord(Patient patient) {

        if (patient == null || patient.getPatientID() <= 0) {
            System.out.println("A valid patient is required.");
            return false;
        }

        if (medicalRecordDAO.findByPatientId(patient.getPatientID()) != null) {
            System.out.println("This patient already has a medical record.");
            return false;
        }

        MedicalRecord record = new MedicalRecord();
        record.setPatient(patient);
        record.setCreatedDate(LocalDate.now());

        return medicalRecordDAO.addMedicalRecord(record);
    }


    // =========================================================
    // GET FULL MEDICAL HISTORY FOR A PATIENT
    // (pulls together diagnoses, treatments, admissions)
    // =========================================================

    public MedicalRecord getFullMedicalHistory(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return null;
        }

        MedicalRecord record = medicalRecordDAO.findByPatientId(patientId);

        if (record == null) {
            System.out.println("No medical record found for this patient.");
            return null;
        }

        record.setDiagnoses(diagnosisService.getDiagnosesByPatient(patientId));
        record.setTreatment(treatmentService.getTreatmentsByPatient(patientId));
        record.setAdmission(admissionService.getAdmissionsByPatient(patientId));

        return record;
    }
}