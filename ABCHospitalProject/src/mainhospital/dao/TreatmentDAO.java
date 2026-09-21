package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Diagnosis;
import mainhospital.models.Doctor;
import mainhospital.models.Patient;
import mainhospital.models.Treatment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class TreatmentDAO {

    // =========================================================
    // CREATE TREATMENT
    // =========================================================

    public boolean addTreatment(Treatment treatment) {

        String sql = "INSERT INTO Treatment "
                   + "(PatientId, DoctorId, DiagnosisId, TreatmentDate, TreatmentName, Description, Notes, Status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, treatment.getPatient().getPatientID());
            statement.setInt(2, treatment.getDoctor().getStaffID());

            if (treatment.getDiagnosis() != null) {
                statement.setInt(3, treatment.getDiagnosis().getId());
            } else {
                statement.setNull(3, Types.INTEGER);
            }

            statement.setDate(4, Date.valueOf(treatment.getTreatmentDate()));
            statement.setString(5, treatment.getTreatmentName());
            statement.setString(6, treatment.getDescription());
            statement.setString(7, treatment.getNotes());
            statement.setString(8, treatment.getStatus());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    treatment.setId(keys.getInt(1));
                }
                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating treatment: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL TREATMENTS
    // =========================================================

    public List<Treatment> findAllTreatments() {

        List<Treatment> treatments = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY t.TreatmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                treatments.add(mapTreatment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving treatments: " + e.getMessage());
        }

        return treatments;
    }


    // =========================================================
    // FIND TREATMENTS BY PATIENT
    // =========================================================

    public List<Treatment> findTreatmentsByPatient(int patientId) {

        List<Treatment> treatments = new ArrayList<>();

        String sql = baseSelect() + " WHERE t.PatientId = ? ORDER BY t.TreatmentId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                treatments.add(mapTreatment(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving treatments for patient: " + e.getMessage());
        }

        return treatments;
    }


    // =========================================================
    // FIND TREATMENT BY ID
    // =========================================================

    public Treatment findTreatmentById(int id) {

        String sql = baseSelect() + " WHERE t.TreatmentId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Treatment treatment = mapTreatment(resultSet);
                connection.close();
                return treatment;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding treatment: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE TREATMENT
    // =========================================================

    public boolean update(Treatment treatment) {

        String sql = "UPDATE Treatment SET TreatmentName = ?, Description = ?, Notes = ?, Status = ? "
                   + "WHERE TreatmentId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, treatment.getTreatmentName());
            statement.setString(2, treatment.getDescription());
            statement.setString(3, treatment.getNotes());
            statement.setString(4, treatment.getStatus());
            statement.setInt(5, treatment.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating treatment: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // DELETE TREATMENT
    // =========================================================

    public boolean delete(int id) {

        String sql = "DELETE FROM Treatment WHERE TreatmentId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting treatment: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // BASE SELECT
    // =========================================================

    private String baseSelect() {

        return "SELECT t.TreatmentId, t.PatientId, t.DoctorId, t.DiagnosisId, "
             + "t.TreatmentDate, t.TreatmentName, t.Description, t.Notes, t.Status, "
             + "d.ConditionName, "
             + "pp.FirstName AS PatientFirstName, pp.LastName AS PatientLastName, "
             + "dp.FirstName AS DoctorFirstName, dp.LastName AS DoctorLastName "
             + "FROM Treatment t "
             + "INNER JOIN Patient pt ON t.PatientId = pt.PatientId "
             + "INNER JOIN Person pp ON pt.PersonId = pp.PersonId "
             + "INNER JOIN Staff s ON t.DoctorId = s.StaffId "
             + "INNER JOIN Person dp ON s.PersonId = dp.PersonId "
             + "LEFT JOIN Diagnosis d ON t.DiagnosisId = d.DiagnosisId";
    }


    // =========================================================
    // MAP RESULTSET TO TREATMENT
    // =========================================================

    private Treatment mapTreatment(ResultSet resultSet) throws SQLException {

        Treatment treatment = new Treatment();

        treatment.setId(resultSet.getInt("TreatmentId"));
        treatment.setTreatmentName(resultSet.getString("TreatmentName"));
        treatment.setDescription(resultSet.getString("Description"));
        treatment.setNotes(resultSet.getString("Notes"));
        treatment.setStatus(resultSet.getString("Status"));

        Date treatmentDate = resultSet.getDate("TreatmentDate");
        if (treatmentDate != null) {
            treatment.setTreatmentDate(treatmentDate.toLocalDate());
        }

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("PatientFirstName"));
        patient.setLastName(resultSet.getString("PatientLastName"));
        treatment.setPatient(patient);

        Doctor doctor = new Doctor();
        doctor.setStaffID(resultSet.getInt("DoctorId"));
        doctor.setFirstName(resultSet.getString("DoctorFirstName"));
        doctor.setLastName(resultSet.getString("DoctorLastName"));
        treatment.setDoctor(doctor);

        int diagnosisId = resultSet.getInt("DiagnosisId");
        if (!resultSet.wasNull()) {
            Diagnosis diagnosis = new Diagnosis();
            diagnosis.setId(diagnosisId);
            diagnosis.setConditionName(resultSet.getString("ConditionName"));
            treatment.setDiagnosis(diagnosis);
        }

        return treatment;
    }
}