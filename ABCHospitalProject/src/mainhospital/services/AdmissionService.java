package mainhospital.services;

import mainhospital.dao.AdmissionDAO;
import mainhospital.models.Admission;

import java.time.LocalDate;
import java.util.List;

public class AdmissionService {

    private final AdmissionDAO admissionDAO;

    public AdmissionService() {
        admissionDAO = new AdmissionDAO();
    }


    // =========================================================
    // ADMIT PATIENT
    // =========================================================

    public boolean admitPatient(Admission admission) {

        if (admission == null) {
            System.out.println("Admission information is required.");
            return false;
        }

        if (admission.getPatient() == null) {
            System.out.println("Patient is required.");
            return false;
        }

        if (admission.getBed() == null || admission.getBed().getId() <= 0) {
            System.out.println("A valid bed is required.");
            return false;
        }

        if (admission.getBed().isOccupied()) {
            System.out.println("That bed is already occupied.");
            return false;
        }

        if (admission.getAdmissionDate() == null) {
            admission.setAdmissionDate(LocalDate.now());
        }

        if (admission.getReason() == null || admission.getReason().isBlank()) {
            System.out.println("Reason for admission is required.");
            return false;
        }

        return admissionDAO.admitPatient(admission);
    }


    // =========================================================
    // DISCHARGE PATIENT
    // =========================================================

    public boolean dischargePatient(int admissionId) {

        if (admissionId <= 0) {
            System.out.println("Invalid admission ID.");
            return false;
        }

        return admissionDAO.dischargePatient(admissionId, LocalDate.now());
    }


    // =========================================================
    // GET ALL ADMISSIONS
    // =========================================================

    public List<Admission> getAllAdmissions() {
        return admissionDAO.findAllAdmissions();
    }


    // =========================================================
    // GET ACTIVE ADMISSIONS
    // =========================================================

    public List<Admission> getActiveAdmissions() {
        return admissionDAO.findActiveAdmissions();
    }


    // =========================================================
    // GET ADMISSION BY ID
    // =========================================================

    public Admission getAdmissionById(int id) {

        if (id <= 0) {
            System.out.println("Invalid admission ID.");
            return null;
        }

        return admissionDAO.findAdmissionById(id);
    }


    // =========================================================
    // UPDATE ADMISSION
    // =========================================================

    public boolean updateAdmission(Admission admission) {

        if (admission == null || admission.getId() <= 0) {
            System.out.println("Invalid admission information.");
            return false;
        }

        if (admission.getReason() == null || admission.getReason().isBlank()) {
            System.out.println("Reason is required.");
            return false;
        }

        return admissionDAO.update(admission);
    }
    
    // =========================================================
// GET ADMISSIONS BY PATIENT
// =========================================================

public List<Admission> getAdmissionsByPatient(int patientId) {

    if (patientId <= 0) {
        System.out.println("Invalid patient ID.");
        return List.of();
    }

    return admissionDAO.findAdmissionsByPatient(patientId);
}
}