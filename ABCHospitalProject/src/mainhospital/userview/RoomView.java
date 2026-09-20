package mainhospital.userview;

import mainhospital.models.Room;

import java.util.List;

public class RoomView {

    // =========================================================
    // DISPLAY ALL ROOMS
    // =========================================================

    public void displayRooms(List<Room> rooms) {

        if (rooms == null || rooms.isEmpty()) {
            System.out.println("No rooms found.");
            return;
        }

        System.out.println();
        System.out.println("======================================================================");

        System.out.printf(
                "%-8s %-14s %-20s %-16s %-10s%n",
                "Room ID", "Room Number", "Ward", "Type", "Capacity"
        );

        System.out.println("----------------------------------------------------------------------");

        for (Room room : rooms) {

            String wardName = room.getWard() != null
                    ? room.getWard().getName()
                    : "N/A";

            System.out.printf(
                    "%-8d %-14s %-20s %-16s %-10d%n",
                    room.getId(),
                    room.getRoomNumber(),
                    wardName,
                    room.getRoomType(),
                    room.getCapacity()
            );
        }

        System.out.println("======================================================================");
    }


    // =========================================================
    // DISPLAY ONE ROOM
    // =========================================================

    public void displayRoom(Room room) {

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        String wardName = room.getWard() != null
                ? room.getWard().getName()
                : "N/A";

        int wardId = room.getWard() != null
                ? room.getWard().getId()
                : 0;

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                  ROOM DETAILS");
        System.out.println("======================================================");

        System.out.printf("%-15s : %s%n", "Room ID", room.getId());
        System.out.printf("%-15s : %s%n", "Room Number", room.getRoomNumber());
        System.out.printf("%-15s : %s%n", "Ward ID", wardId);
        System.out.printf("%-15s : %s%n", "Ward Name", wardName);
        System.out.printf("%-15s : %s%n", "Type", room.getRoomType());
        System.out.printf("%-15s : %s%n", "Capacity", room.getCapacity());

        System.out.println("======================================================");
    }
}