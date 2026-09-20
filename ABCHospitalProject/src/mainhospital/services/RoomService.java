package mainhospital.services;

import mainhospital.dao.RoomDAO;
import mainhospital.models.Room;

import java.util.List;

public class RoomService {

    private final RoomDAO roomDAO;

    public RoomService() {
        roomDAO = new RoomDAO();
    }


    // =========================================================
    // CREATE ROOM
    // =========================================================

    public boolean createRoom(Room room) {

        if (room == null) {
            System.out.println("Room information is required.");
            return false;
        }

        if (room.getRoomNumber() == null || room.getRoomNumber().isBlank()) {
            System.out.println("Room number is required.");
            return false;
        }

        if (room.getWard() == null || room.getWard().getId() <= 0) {
            System.out.println("A valid ward is required.");
            return false;
        }

        if (room.getRoomType() == null || room.getRoomType().isBlank()) {
            System.out.println("Room type is required.");
            return false;
        }

        if (room.getCapacity() <= 0) {
            System.out.println("Capacity must be greater than zero.");
            return false;
        }

        return roomDAO.addRoom(room);
    }


    // =========================================================
    // GET ALL ROOMS
    // =========================================================

    public List<Room> getAllRooms() {

        return roomDAO.findAllRooms();
    }


    // =========================================================
    // GET ROOMS BY WARD
    // =========================================================

    public List<Room> getRoomsByWard(int wardId) {

        if (wardId <= 0) {
            System.out.println("Invalid ward ID.");
            return List.of();
        }

        return roomDAO.findRoomsByWard(wardId);
    }


    // =========================================================
    // GET ROOM BY ID
    // =========================================================

    public Room getRoomById(int id) {

        if (id <= 0) {
            System.out.println("Invalid room ID.");
            return null;
        }

        return roomDAO.findRoomById(id);
    }


    // =========================================================
    // UPDATE ROOM
    // =========================================================

    public boolean updateRoom(Room room) {

        if (room == null || room.getId() <= 0) {
            System.out.println("Invalid room information.");
            return false;
        }

        if (room.getRoomNumber() == null || room.getRoomNumber().isBlank()) {
            System.out.println("Room number is required.");
            return false;
        }

        if (room.getWard() == null || room.getWard().getId() <= 0) {
            System.out.println("A valid ward is required.");
            return false;
        }

        if (room.getCapacity() <= 0) {
            System.out.println("Capacity must be greater than zero.");
            return false;
        }

        return roomDAO.update(room);
    }


    // =========================================================
    // DELETE ROOM
    // =========================================================

    public boolean deleteRoom(int id) {

        if (id <= 0) {
            System.out.println("Invalid room ID.");
            return false;
        }

        return roomDAO.delete(id);
    }
}