package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Admission;
import mainhospital.models.Nurse;
import mainhospital.models.NurseAssignment;
import mainhospital.models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NurseAssignmentDAO {

    // =========================================================
    // CREATE ASSIGNMENT
    // =========================================================

    public boolean addAssignment(NurseAssignment assignment) {

        String sql = "INSERT INTO NurseAssignment "
                   + "(NurseId, PatientId, AdmissionId, AssignmentDate, Shift, Status, Notes) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, assignment.getNurse().getStaffID());
            statement.setInt(2, assignment.getPatient().getPatientID());

            if (assignment.getAdmission() != null) {
                statement.setInt(3, assignment.getAdmission().getId());
            } else {
                statement.setNull(3, java.sql.Types.INTEGER);
            }

            statement.setObject(4, assignment.getAssingmentDate());
            statement.setString(5, assignment.getShift());
            statement.setString(6, assignment.getStatus());
            statement.setString(7, assignment.getNotes());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    assignment.setId(keys.getInt(1));
                }
                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating nurse assignment: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL ASSIGNMENTS
    // =========================================================

    public List<NurseAssignment> findAllAssignments() {

        List<NurseAssignment> assignments = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY na.NurseAssignmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                assignments.add(mapAssignment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving assignments: " + e.getMessage());
        }

        return assignments;
    }


    // =========================================================
    // FIND ASSIGNMENTS BY NURSE
    // =========================================================

    public List<NurseAssignment> findAssignmentsByNurse(int nurseId) {

        List<NurseAssignment> assignments = new ArrayList<>();

        String sql = baseSelect() + " WHERE na.NurseId = ? ORDER BY na.NurseAssignmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, nurseId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                assignments.add(mapAssignment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving assignments for nurse: " + e.getMessage());
        }

        return assignments;
    }


    // =========================================================
    // FIND ASSIGNMENT BY ID
    // =========================================================

    public NurseAssignment findAssignmentById(int id) {

        String sql = baseSelect() + " WHERE na.NurseAssignmentId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                NurseAssignment assignment = mapAssignment(resultSet);
                connection.close();
                return assignment;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding assignment: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // END ASSIGNMENT
    // =========================================================

    public boolean endAssignment(int id, java.time.LocalDateTime endDate) {

        String sql = "UPDATE NurseAssignment SET EndDate = ?, Status = 'Completed' "
                   + "WHERE NurseAssignmentId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, endDate);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error ending assignment: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // DELETE ASSIGNMENT
    // =========================================================

    public boolean delete(int id) {

        String sql = "DELETE FROM NurseAssignment WHERE NurseAssignmentId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting assignment: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // BASE SELECT
    // =========================================================

    private String baseSelect() {

        return "SELECT na.NurseAssignmentId, na.NurseId, na.PatientId, na.AdmissionId, "
             + "na.AssignmentDate, na.EndDate, na.Shift, na.Status, na.Notes, "
             + "np.FirstName AS NurseFirstName, np.LastName AS NurseLastName, "
             + "pp.FirstName AS PatientFirstName, pp.LastName AS PatientLastName "
             + "FROM NurseAssignment na "
             + "INNER JOIN Staff ns ON na.NurseId = ns.StaffId "
             + "INNER JOIN Person np ON ns.PersonId = np.PersonId "
             + "INNER JOIN Patient pt ON na.PatientId = pt.PatientId "
             + "INNER JOIN Person pp ON pt.PersonId = pp.PersonId";
    }


    // =========================================================
    // MAP RESULTSET TO NURSE ASSIGNMENT
    // =========================================================

    private NurseAssignment mapAssignment(ResultSet resultSet) throws SQLException {

        NurseAssignment assignment = new NurseAssignment();

        assignment.setId(resultSet.getInt("NurseAssignmentId"));
        assignment.setShift(resultSet.getString("Shift"));
        assignment.setStatus(resultSet.getString("Status"));
        assignment.setNotes(resultSet.getString("Notes"));

        Timestamp assignedTs = resultSet.getTimestamp("AssignmentDate");
        if (assignedTs != null) {
            assignment.setAssingmentDate(assignedTs.toLocalDateTime());
        }

        Timestamp endTs = resultSet.getTimestamp("EndDate");
        if (endTs != null) {
            assignment.setEndDate(endTs.toLocalDateTime());
        }

        Nurse nurse = new Nurse();
        nurse.setStaffID(resultSet.getInt("NurseId"));
        nurse.setFirstName(resultSet.getString("NurseFirstName"));
        nurse.setLastName(resultSet.getString("NurseLastName"));
        assignment.setNurse(nurse);

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("PatientFirstName"));
        patient.setLastName(resultSet.getString("PatientLastName"));
        assignment.setPatient(patient);

        int admissionId = resultSet.getInt("AdmissionId");
        if (!resultSet.wasNull()) {
            Admission admission = new Admission();
            admission.setId(admissionId);
            assignment.setAdmission(admission);
        }

        return assignment;
    }
}