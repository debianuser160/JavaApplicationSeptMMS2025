package mainhospital.services;

import mainhospital.dao.LaboratoryTechnicianDAO;
import mainhospital.models.LaboratoryTechnician;

import java.util.List;

public class LaboratoryTechnicianService {

    private final LaboratoryTechnicianDAO laboratoryTechnicianDAO;

    public LaboratoryTechnicianService() {

        laboratoryTechnicianDAO = new LaboratoryTechnicianDAO();
    }


    // =========================================================
    // REGISTER LABORATORY TECHNICIAN
    // =========================================================

    public boolean registerLaboratoryTechnician(
            LaboratoryTechnician technician
    ) {

        if (technician == null) {

            System.out.println(
                    "Laboratory technician information is required."
            );

            return false;
        }

        if (technician.getFirstName() == null ||
                technician.getFirstName().isBlank()) {

            System.out.println(
                    "First name is required."
            );

            return false;
        }

        if (technician.getLastName() == null ||
                technician.getLastName().isBlank()) {

            System.out.println(
                    "Last name is required."
            );

            return false;
        }

        if (technician.getDateOfBirth() == null) {

            System.out.println(
                    "Date of birth is required."
            );

            return false;
        }

        if (technician.getEmploymentDate() == null) {

            System.out.println(
                    "Employment date is required."
            );

            return false;
        }

        if (technician.getDepartment() == null) {

            System.out.println(
                    "Department is required."
            );

            return false;
        }

        if (technician.getQualification() == null ||
                technician.getQualification().isBlank()) {

            System.out.println(
                    "Qualification is required."
            );

            return false;
        }

        if (technician.getLicenseNumber() == null ||
                technician.getLicenseNumber().isBlank()) {

            System.out.println(
                    "License number is required."
            );

            return false;
        }

        if (technician.getSalary() < 0) {

            System.out.println(
                    "Salary cannot be negative."
            );

            return false;
        }

        return laboratoryTechnicianDAO.addLaboratoryTechnician(
                technician
        );
    }


    // =========================================================
    // GET ALL LABORATORY TECHNICIANS
    // =========================================================

    public List<LaboratoryTechnician> getAllLaboratoryTechnicians() {

        return laboratoryTechnicianDAO.findAllLaboratoryTechnicians();
    }


    // =========================================================
    // GET LABORATORY TECHNICIAN BY ID
    // =========================================================

    public LaboratoryTechnician getLaboratoryTechnicianById(
            int id
    ) {

        if (id <= 0) {

            System.out.println(
                    "Invalid laboratory technician ID."
            );

            return null;
        }

        return laboratoryTechnicianDAO.findLaboratoryTechnicianById(
                id
        );
    }


    // =========================================================
    // UPDATE LABORATORY TECHNICIAN
    // =========================================================

    public boolean updateLaboratoryTechnician(
            LaboratoryTechnician technician
    ) {

        if (technician == null) {

            System.out.println(
                    "Laboratory technician information is required."
            );

            return false;
        }

        if (technician.getStaffID() <= 0) {

            System.out.println(
                    "Invalid laboratory technician ID."
            );

            return false;
        }

        if (technician.getFirstName() == null ||
                technician.getFirstName().isBlank()) {

            System.out.println(
                    "First name is required."
            );

            return false;
        }

        if (technician.getLastName() == null ||
                technician.getLastName().isBlank()) {

            System.out.println(
                    "Last name is required."
            );

            return false;
        }

        if (technician.getDateOfBirth() == null) {

            System.out.println(
                    "Date of birth is required."
            );

            return false;
        }

        if (technician.getDepartment() == null) {

            System.out.println(
                    "Department is required."
            );

            return false;
        }

        if (technician.getQualification() == null ||
                technician.getQualification().isBlank()) {

            System.out.println(
                    "Qualification is required."
            );

            return false;
        }

        if (technician.getLicenseNumber() == null ||
                technician.getLicenseNumber().isBlank()) {

            System.out.println(
                    "License number is required."
            );

            return false;
        }

        return laboratoryTechnicianDAO.update(
                technician
        );
    }


    // =========================================================
    // DELETE LABORATORY TECHNICIAN
    // =========================================================

    public boolean deleteLaboratoryTechnician(
            int id
    ) {

        if (id <= 0) {

            System.out.println(
                    "Invalid laboratory technician ID."
            );

            return false;
        }

        return laboratoryTechnicianDAO.delete(
                id
        );
    }
}