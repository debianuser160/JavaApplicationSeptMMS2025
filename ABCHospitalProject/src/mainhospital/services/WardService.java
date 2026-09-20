package mainhospital.services;

import mainhospital.dao.WardDAO;
import mainhospital.models.Ward;

import java.util.List;

public class WardService {

    private final WardDAO wardDAO;

    public WardService() {
        wardDAO = new WardDAO();
    }


    // =========================================================
    // CREATE WARD
    // =========================================================

    public boolean createWard(Ward ward) {

        if (ward == null) {
            System.out.println("Ward information is required.");
            return false;
        }

        if (ward.getName() == null || ward.getName().isBlank()) {
            System.out.println("Ward name is required.");
            return false;
        }

        if (ward.getWardType() == null || ward.getWardType().isBlank()) {
            System.out.println("Ward type is required.");
            return false;
        }

        if (ward.getCapacity() <= 0) {
            System.out.println("Capacity must be greater than zero.");
            return false;
        }

        return wardDAO.addWard(ward);
    }


    // =========================================================
    // GET ALL WARDS
    // =========================================================

    public List<Ward> getAllWards() {

        return wardDAO.findAllWards();
    }


    // =========================================================
    // GET WARD BY ID
    // =========================================================

    public Ward getWardById(int id) {

        if (id <= 0) {
            System.out.println("Invalid ward ID.");
            return null;
        }

        return wardDAO.findWardById(id);
    }


    // =========================================================
    // UPDATE WARD
    // =========================================================

    public boolean updateWard(Ward ward) {

        if (ward == null || ward.getId() <= 0) {
            System.out.println("Invalid ward information.");
            return false;
        }

        if (ward.getName() == null || ward.getName().isBlank()) {
            System.out.println("Ward name is required.");
            return false;
        }

        if (ward.getCapacity() <= 0) {
            System.out.println("Capacity must be greater than zero.");
            return false;
        }

        return wardDAO.update(ward);
    }


    // =========================================================
    // DELETE WARD
    // =========================================================

    public boolean deleteWard(int id) {

        if (id <= 0) {
            System.out.println("Invalid ward ID.");
            return false;
        }

        return wardDAO.delete(id);
    }
}