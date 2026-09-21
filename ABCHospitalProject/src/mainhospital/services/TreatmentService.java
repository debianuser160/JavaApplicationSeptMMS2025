package mainhospital.services;

import mainhospital.dao.TreatmentDAO;
import mainhospital.models.Treatment;

import java.time.LocalDate;
import java.util.List;

public class TreatmentService {

    private final TreatmentDAO treatmentDAO;

    public TreatmentService() {
        treatmentDAO = new TreatmentDAO();
    }


    // =========================================================
    // CREATE TREATMENT
    // =========================================================

    public boolean createTreatment(Treatment treatment) {

        if (treatment == null) {
            System.out.println("Treatment information is required.");
            return false;
        }

        if (treatment.getPatient() == null || treatment.getPatient().getPatientID() <= 0) {
            System.out.println("A valid patient is required.");
            return false;
        }

        if (treatment.getDoctor() == null || treatment.getDoctor().getStaffID() <= 0) {
            System.out.println("A valid doctor is required.");
            return false;
        }

        if (treatment.getTreatmentName() == null || treatment.getTreatmentName().isBlank()) {
            System.out.println("Treatment name is required.");
            return false;
        }

        if (treatment.getTreatmentDate() == null) {
            treatment.setTreatmentDate(LocalDate.now());
        }

        if (treatment.getStatus() == null || treatment.getStatus().isBlank()) {
            treatment.setStatus("Ongoing");
        }

        return treatmentDAO.addTreatment(treatment);
    }


    // =========================================================
    // GET ALL TREATMENTS
    // =========================================================

    public List<Treatment> getAllTreatments() {
        return treatmentDAO.findAllTreatments();
    }


    // =========================================================
    // GET TREATMENTS BY PATIENT
    // =========================================================

    public List<Treatment> getTreatmentsByPatient(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return List.of();
        }

        return treatmentDAO.findTreatmentsByPatient(patientId);
    }


    // =========================================================
    // GET TREATMENT BY ID
    // =========================================================

    public Treatment getTreatmentById(int id) {

        if (id <= 0) {
            System.out.println("Invalid treatment ID.");
            return null;
        }

        return treatmentDAO.findTreatmentById(id);
    }


    // =========================================================
    // UPDATE TREATMENT
    // =========================================================

    public boolean updateTreatment(Treatment treatment) {

        if (treatment == null || treatment.getId() <= 0) {
            System.out.println("Invalid treatment information.");
            return false;
        }

        if (treatment.getTreatmentName() == null || treatment.getTreatmentName().isBlank()) {
            System.out.println("Treatment name is required.");
            return false;
        }

        return treatmentDAO.update(treatment);
    }


    // =========================================================
    // DELETE TREATMENT
    // =========================================================

    public boolean deleteTreatment(int id) {

        if (id <= 0) {
            System.out.println("Invalid treatment ID.");
            return false;
        }

        return treatmentDAO.delete(id);
    }
}