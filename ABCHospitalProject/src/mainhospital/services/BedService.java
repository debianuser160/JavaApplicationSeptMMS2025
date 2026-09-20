package mainhospital.services;

import mainhospital.dao.BedDAO;
import mainhospital.models.Bed;

import java.util.List;

public class BedService {

    private final BedDAO bedDAO;

    public BedService() {
        bedDAO = new BedDAO();
    }


    // =========================================================
    // CREATE BED
    // =========================================================

    public boolean createBed(Bed bed) {

        if (bed == null) {
            System.out.println("Bed information is required.");
            return false;
        }

        if (bed.getBedNumber() == null || bed.getBedNumber().isBlank()) {
            System.out.println("Bed number is required.");
            return false;
        }

        if (bed.getRoom() == null || bed.getRoom().getId() <= 0) {
            System.out.println("A valid room is required.");
            return false;
        }

        return bedDAO.addBed(bed);
    }


    // =========================================================
    // GET ALL BEDS
    // =========================================================

    public List<Bed> getAllBeds() {

        return bedDAO.findAllBeds();
    }


    // =========================================================
    // GET BEDS BY ROOM
    // =========================================================

    public List<Bed> getBedsByRoom(int roomId) {

        if (roomId <= 0) {
            System.out.println("Invalid room ID.");
            return List.of();
        }

        return bedDAO.findBedsByRoom(roomId);
    }


    // =========================================================
    // GET AVAILABLE BEDS
    // =========================================================

    public List<Bed> getAvailableBeds() {

        return bedDAO.findAvailableBeds();
    }


    // =========================================================
    // GET OCCUPIED BEDS
    // =========================================================

    public List<Bed> getOccupiedBeds() {

        return bedDAO.findOccupiedBeds();
    }


    // =========================================================
    // GET BED BY ID
    // =========================================================

    public Bed getBedById(int id) {

        if (id <= 0) {
            System.out.println("Invalid bed ID.");
            return null;
        }

        return bedDAO.findBedById(id);
    }


    // =========================================================
    // UPDATE BED
    // =========================================================

    public boolean updateBed(Bed bed) {

        if (bed == null || bed.getId() <= 0) {
            System.out.println("Invalid bed information.");
            return false;
        }

        if (bed.getBedNumber() == null || bed.getBedNumber().isBlank()) {
            System.out.println("Bed number is required.");
            return false;
        }

        if (bed.getRoom() == null || bed.getRoom().getId() <= 0) {
            System.out.println("A valid room is required.");
            return false;
        }

        return bedDAO.update(bed);
    }


    // =========================================================
    // DELETE BED
    // =========================================================

    public boolean deleteBed(int id) {

        if (id <= 0) {
            System.out.println("Invalid bed ID.");
            return false;
        }

        Bed bed = bedDAO.findBedById(id);

        if (bed != null && bed.isOccupied()) {
            System.out.println("Cannot delete an occupied bed.");
            return false;
        }

        return bedDAO.delete(id);
    }
}