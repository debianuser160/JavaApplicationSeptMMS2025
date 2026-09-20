package mainhospital.services;

import mainhospital.dao.PharmacistDAO;
import mainhospital.models.Pharmacist;

import java.util.List;

public class PharmacistService {

    private final PharmacistDAO pharmacistDAO;

    public PharmacistService() {

        pharmacistDAO = new PharmacistDAO();
    }


    // =========================================================
    // REGISTER PHARMACIST
    // =========================================================

    public boolean registerPharmacist(Pharmacist pharmacist) {

        if (pharmacist == null) {

            System.out.println("Pharmacist information is required.");

            return false;
        }

        if (pharmacist.getFirstName() == null ||
                pharmacist.getFirstName().isBlank()) {

            System.out.println("First name is required.");

            return false;
        }

        if (pharmacist.getLastName() == null ||
                pharmacist.getLastName().isBlank()) {

            System.out.println("Last name is required.");

            return false;
        }

        if (pharmacist.getDateOfBirth() == null) {

            System.out.println("Date of birth is required.");

            return false;
        }

        if (pharmacist.getEmploymentDate() == null) {

            System.out.println("Employment date is required.");

            return false;
        }

        if (pharmacist.getDepartment() == null) {

            System.out.println("Department is required.");

            return false;
        }

        if (pharmacist.getQualification() == null ||
                pharmacist.getQualification().isBlank()) {

            System.out.println("Qualification is required.");

            return false;
        }

        if (pharmacist.getLicenseNumber() == null ||
                pharmacist.getLicenseNumber().isBlank()) {

            System.out.println("License number is required.");

            return false;
        }

        if (pharmacist.getSalary() < 0) {

            System.out.println("Salary cannot be negative.");

            return false;
        }

        return pharmacistDAO.addPharmacist(pharmacist);
    }


    // =========================================================
    // GET ALL PHARMACISTS
    // =========================================================

    public List<Pharmacist> getAllPharmacists() {

        return pharmacistDAO.findAllPharmacists();
    }


    // =========================================================
    // GET PHARMACIST BY ID
    // =========================================================

    public Pharmacist getPharmacistById(int id) {

        if (id <= 0) {

            System.out.println("Invalid pharmacist ID.");

            return null;
        }

        return pharmacistDAO.findPharmacistById(id);
    }


    // =========================================================
    // UPDATE PHARMACIST
    // =========================================================

    public boolean updatePharmacist(Pharmacist pharmacist) {

        if (pharmacist == null) {

            System.out.println("Pharmacist information is required.");

            return false;
        }

        if (pharmacist.getStaffID() <= 0) {

            System.out.println("Invalid pharmacist ID.");

            return false;
        }

        if (pharmacist.getFirstName() == null ||
                pharmacist.getFirstName().isBlank()) {

            System.out.println("First name is required.");

            return false;
        }

        if (pharmacist.getLastName() == null ||
                pharmacist.getLastName().isBlank()) {

            System.out.println("Last name is required.");

            return false;
        }

        if (pharmacist.getDateOfBirth() == null) {

            System.out.println("Date of birth is required.");

            return false;
        }

        if (pharmacist.getDepartment() == null) {

            System.out.println("Department is required.");

            return false;
        }

        if (pharmacist.getQualification() == null ||
                pharmacist.getQualification().isBlank()) {

            System.out.println("Qualification is required.");

            return false;
        }

        if (pharmacist.getLicenseNumber() == null ||
                pharmacist.getLicenseNumber().isBlank()) {

            System.out.println("License number is required.");

            return false;
        }

        return pharmacistDAO.update(pharmacist);
    }


    // =========================================================
    // DELETE PHARMACIST
    // =========================================================

    public boolean deletePharmacist(int id) {

        if (id <= 0) {

            System.out.println("Invalid pharmacist ID.");

            return false;
        }

        return pharmacistDAO.delete(id);
    }
}