package mainhospital.services;

import mainhospital.dao.LaboratoryTestDAO;
import mainhospital.models.LaboratoryTest;

import java.time.LocalDateTime;
import java.util.List;

public class LaboratoryTestService {

    private final LaboratoryTestDAO laboratoryTestDAO;

    public LaboratoryTestService() {
        laboratoryTestDAO = new LaboratoryTestDAO();
    }


    // =========================================================
    // CREATE LABORATORY TEST
    // =========================================================

    public boolean createLaboratoryTest(LaboratoryTest test) {

        if (test == null) {
            System.out.println("Laboratory test information is required.");
            return false;
        }

        if (test.getPatient() == null || test.getPatient().getPatientID() <= 0) {
            System.out.println("A valid patient is required.");
            return false;
        }

        if (test.getTechnician() == null || test.getTechnician().getStaffID() <= 0) {
            System.out.println("A valid laboratory technician is required.");
            return false;
        }

        if (test.getTestName() == null || test.getTestName().isBlank()) {
            System.out.println("Test name is required.");
            return false;
        }

        if (test.getTestDate() == null) {
            test.setTestDate(LocalDateTime.now());
        }

        if (test.getStatus() == null || test.getStatus().isBlank()) {
            test.setStatus("Pending");
        }

        return laboratoryTestDAO.addLaboratoryTest(test);
    }


    // =========================================================
    // GET ALL LABORATORY TESTS
    // =========================================================

    public List<LaboratoryTest> getAllLaboratoryTests() {
        return laboratoryTestDAO.findAllLaboratoryTests();
    }


    // =========================================================
    // GET LABORATORY TESTS BY PATIENT
    // =========================================================

    public List<LaboratoryTest> getLaboratoryTestsByPatient(int patientId) {

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return List.of();
        }

        return laboratoryTestDAO.findLaboratoryTestsByPatient(patientId);
    }


    // =========================================================
    // GET PENDING LABORATORY TESTS
    // =========================================================

    public List<LaboratoryTest> getPendingLaboratoryTests() {
        return laboratoryTestDAO.findPendingLaboratoryTests();
    }


    // =========================================================
    // GET COMPLETED LABORATORY TESTS
    // =========================================================

    public List<LaboratoryTest> getCompletedLaboratoryTests() {
        return laboratoryTestDAO.findCompletedLaboratoryTests();
    }


    // =========================================================
    // GET LABORATORY TEST BY ID
    // =========================================================

    public LaboratoryTest getLaboratoryTestById(int id) {

        if (id <= 0) {
            System.out.println("Invalid test ID.");
            return null;
        }

        return laboratoryTestDAO.findLaboratoryTestById(id);
    }


    // =========================================================
    // UPDATE LABORATORY TEST
    // =========================================================

    public boolean updateLaboratoryTest(LaboratoryTest test) {

        if (test == null || test.getId() <= 0) {
            System.out.println("Invalid laboratory test information.");
            return false;
        }

        if (test.getTestName() == null || test.getTestName().isBlank()) {
            System.out.println("Test name is required.");
            return false;
        }

        return laboratoryTestDAO.update(test);
    }


    // =========================================================
    // RECORD TEST RESULT
    // =========================================================

    public boolean recordTestResult(int id, String result, String status) {

        if (id <= 0) {
            System.out.println("Invalid test ID.");
            return false;
        }

        if (result == null || result.isBlank()) {
            System.out.println("Result is required.");
            return false;
        }

        if (status == null || status.isBlank()) {
            status = "Completed";
        }

        return laboratoryTestDAO.recordResult(id, result, status);
    }


    // =========================================================
    // DELETE LABORATORY TEST
    // =========================================================

    public boolean deleteLaboratoryTest(int id) {

        if (id <= 0) {
            System.out.println("Invalid test ID.");
            return false;
        }

        return laboratoryTestDAO.delete(id);
    }
}