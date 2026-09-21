package mainhospital.services;

import mainhospital.dao.DiagnosisDAO;
import mainhospital.models.Diagnosis;

import java.time.LocalDate;
import java.util.List;

public class DiagnosisService {

    private final DiagnosisDAO diagnosisDAO;

    public DiagnosisService() {
        diagnosisDAO = new DiagnosisDAO();
    }


    // =========================================================
    // CREATE DIAGNOSIS
    // =========================================================

    public boolean createDiagnosis(Diagnosis diagnosis) {

        if (diagnosis == null) {
            System.out.println("Diagnosis information is required.");
            return false;
        }

        if (diagnosis.getPatient() == null || diagnosis.getPatient().getPatientID() <= 0) {
            System.out.println("A valid patient is required.");
            return false;
        }

        if (diagnosis.getDoctor() == null || diagnosis.getDoctor().getStaffID() <= 0) {
            System.out.println("A valid doctor is required.");
            return false;
        }

        if (diagnosis.getConditionName() == null || diagnosis.getConditionName().isBlank()) {
            System.out.println("Condition name is required.");
            return false;
        }

        if (diagnosis.getDiagnosisDate() == null) {
            diagnosis.setDiagnosisDate(LocalDate.now());
        }

        return diagnosisDAO.addDiagnosis(diagnosis);
    }


    // =========================================================
    // GET ALL DIAGNOSES
    // =========================================================

    public List<Diagnosis> getAllDiagnoses() {
        return diagnosisDAO.findAllDiagnoses();
    }


    // =========================================================
    // GET DIAGNOSES BY PATIENT
    // =========================================================

    public List<Diagnosis> getDiagnosesByPatient(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return List.of();
        }

        return diagnosisDAO.findDiagnosesByPatient(patientId);
    }


    // =========================================================
    // GET DIAGNOSIS BY ID
    // =========================================================

    public Diagnosis getDiagnosisById(int id) {

        if (id <= 0) {
            System.out.println("Invalid diagnosis ID.");
            return null;
        }

        return diagnosisDAO.findDiagnosisById(id);
    }


    // =========================================================
    // UPDATE DIAGNOSIS
    // =========================================================

    public boolean updateDiagnosis(Diagnosis diagnosis) {

        if (diagnosis == null || diagnosis.getId() <= 0) {
            System.out.println("Invalid diagnosis information.");
            return false;
        }

        if (diagnosis.getConditionName() == null || diagnosis.getConditionName().isBlank()) {
            System.out.println("Condition name is required.");
            return false;
        }

        return diagnosisDAO.update(diagnosis);
    }


    // =========================================================
    // DELETE DIAGNOSIS
    // =========================================================

    public boolean deleteDiagnosis(int id) {

        if (id <= 0) {
            System.out.println("Invalid diagnosis ID.");
            return false;
        }

        return diagnosisDAO.delete(id);
    }
}   