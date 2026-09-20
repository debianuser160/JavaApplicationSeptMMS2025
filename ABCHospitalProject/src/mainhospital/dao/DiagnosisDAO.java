package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Diagnosis;
import mainhospital.models.Doctor;
import mainhospital.models.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisDAO {

    // =========================================================
    // CREATE DIAGNOSIS
    // =========================================================

    public boolean addDiagnosis(Diagnosis diagnosis) {

        String sql = "INSERT INTO Diagnosis (PatientId, DoctorId, DiagnosisDate, ConditionName, Description, Notes) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, diagnosis.getPatient().getPatientID());
            statement.setInt(2, diagnosis.getDoctor().getStaffID());
            statement.setDate(3, Date.valueOf(diagnosis.getDiagnosisDate()));
            statement.setString(4, diagnosis.getConditionName());
            statement.setString(5, diagnosis.getDescription());
            statement.setString(6, diagnosis.getNotes());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    diagnosis.setId(keys.getInt(1));
                }
                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating diagnosis: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL DIAGNOSES
    // =========================================================

    public List<Diagnosis> findAllDiagnoses() {

        List<Diagnosis> diagnoses = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY d.DiagnosisId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                diagnoses.add(mapDiagnosis(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving diagnoses: " + e.getMessage());
        }

        return diagnoses;
    }


    // =========================================================
    // FIND DIAGNOSES BY PATIENT
    // =========================================================

    public List<Diagnosis> findDiagnosesByPatient(int patientId) {

        List<Diagnosis> diagnoses = new ArrayList<>();

        String sql = baseSelect() + " WHERE d.PatientId = ? ORDER BY d.DiagnosisId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                diagnoses.add(mapDiagnosis(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving diagnoses for patient: " + e.getMessage());
        }

        return diagnoses;
    }


    // =========================================================
    // FIND DIAGNOSIS BY ID
    // =========================================================

    public Diagnosis findDiagnosisById(int id) {

        String sql = baseSelect() + " WHERE d.DiagnosisId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Diagnosis diagnosis = mapDiagnosis(resultSet);
                connection.close();
                return diagnosis;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding diagnosis: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE DIAGNOSIS
    // =========================================================

    public boolean update(Diagnosis diagnosis) {

        String sql = "UPDATE Diagnosis SET ConditionName = ?, Description = ?, Notes = ? "
                   + "WHERE DiagnosisId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, diagnosis.getConditionName());
            statement.setString(2, diagnosis.getDescription());
            statement.setString(3, diagnosis.getNotes());
            statement.setInt(4, diagnosis.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating diagnosis: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // DELETE DIAGNOSIS
    // =========================================================

    public boolean delete(int id) {

        String sql = "DELETE FROM Diagnosis WHERE DiagnosisId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting diagnosis: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // BASE SELECT
    // =========================================================

    private String baseSelect() {

        return "SELECT d.DiagnosisId, d.PatientId, d.DoctorId, d.DiagnosisDate, "
             + "d.ConditionName, d.Description, d.Notes, "
             + "pp.FirstName AS PatientFirstName, pp.LastName AS PatientLastName, "
             + "dp.FirstName AS DoctorFirstName, dp.LastName AS DoctorLastName "
             + "FROM Diagnosis d "
             + "INNER JOIN Patient pt ON d.PatientId = pt.PatientId "
             + "INNER JOIN Person pp ON pt.PersonId = pp.PersonId "
             + "INNER JOIN Staff s ON d.DoctorId = s.StaffId "
             + "INNER JOIN Person dp ON s.PersonId = dp.PersonId";
    }


    // =========================================================
    // MAP RESULTSET TO DIAGNOSIS
    // =========================================================

    private Diagnosis mapDiagnosis(ResultSet resultSet) throws SQLException {

        Diagnosis diagnosis = new Diagnosis();

        diagnosis.setId(resultSet.getInt("DiagnosisId"));
        diagnosis.setConditionName(resultSet.getString("ConditionName"));
        diagnosis.setDescription(resultSet.getString("Description"));
        diagnosis.setNotes(resultSet.getString("Notes"));

        Date diagnosisDate = resultSet.getDate("DiagnosisDate");
        if (diagnosisDate != null) {
            diagnosis.setDiagnosisDate(diagnosisDate.toLocalDate());
        }

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("PatientFirstName"));
        patient.setLastName(resultSet.getString("PatientLastName"));
        diagnosis.setPatient(patient);

        Doctor doctor = new Doctor();
        doctor.setStaffID(resultSet.getInt("DoctorId"));
        doctor.setFirstName(resultSet.getString("DoctorFirstName"));
        doctor.setLastName(resultSet.getString("DoctorLastName"));
        diagnosis.setDoctor(doctor);

        return diagnosis;
    }
}