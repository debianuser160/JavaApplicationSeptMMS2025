package mainhospital.services;

import mainhospital.dao.NurseAssignmentDAO;
import mainhospital.models.NurseAssignment;

import java.time.LocalDateTime;
import java.util.List;

public class NurseAssignmentService {

    private final NurseAssignmentDAO assignmentDAO;

    public NurseAssignmentService() {
        assignmentDAO = new NurseAssignmentDAO();
    }


    // =========================================================
    // CREATE ASSIGNMENT
    // =========================================================

    public boolean createAssignment(NurseAssignment assignment) {

        if (assignment == null) {
            System.out.println("Assignment information is required.");
            return false;
        }

        if (assignment.getNurse() == null || assignment.getNurse().getStaffID() <= 0) {
            System.out.println("A valid nurse is required.");
            return false;
        }

        if (assignment.getPatient() == null || assignment.getPatient().getPatientID() <= 0) {
            System.out.println("A valid patient is required.");
            return false;
        }

        if (assignment.getAssingmentDate() == null) {
            assignment.setAssingmentDate(LocalDateTime.now());
        }

        if (assignment.getShift() == null || assignment.getShift().isBlank()) {
            System.out.println("Shift is required.");
            return false;
        }

        if (assignment.getStatus() == null || assignment.getStatus().isBlank()) {
            assignment.setStatus("Active");
        }

        return assignmentDAO.addAssignment(assignment);
    }


    // =========================================================
    // GET ALL ASSIGNMENTS
    // =========================================================

    public List<NurseAssignment> getAllAssignments() {
        return assignmentDAO.findAllAssignments();
    }


    // =========================================================
    // GET ASSIGNMENTS BY NURSE
    // =========================================================

    public List<NurseAssignment> getAssignmentsByNurse(int nurseId) {

        if (nurseId <= 0) {
            System.out.println("Invalid nurse ID.");
            return List.of();
        }

        return assignmentDAO.findAssignmentsByNurse(nurseId);
    }


    // =========================================================
    // GET ASSIGNMENT BY ID
    // =========================================================

    public NurseAssignment getAssignmentById(int id) {

        if (id <= 0) {
            System.out.println("Invalid assignment ID.");
            return null;
        }

        return assignmentDAO.findAssignmentById(id);
    }


    // =========================================================
    // END ASSIGNMENT
    // =========================================================

    public boolean endAssignment(int id) {

        if (id <= 0) {
            System.out.println("Invalid assignment ID.");
            return false;
        }

        return assignmentDAO.endAssignment(id, LocalDateTime.now());
    }


    // =========================================================
    // DELETE ASSIGNMENT
    // =========================================================

    public boolean deleteAssignment(int id) {

        if (id <= 0) {
            System.out.println("Invalid assignment ID.");
            return false;
        }

        return assignmentDAO.delete(id);
    }
}