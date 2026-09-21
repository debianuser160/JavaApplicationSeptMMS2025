package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.MedicalRecord;
import mainhospital.models.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {

    // =========================================================
    // CREATE MEDICAL RECORD
    // =========================================================

    public boolean addMedicalRecord(MedicalRecord record) {

        String sql = "INSERT INTO MedicalRecord (PatientId, CreatedDate) VALUES (?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, record.getPatient().getPatientID());
            statement.setDate(2, Date.valueOf(record.getCreatedDate()));

            int rows = statement.executeUpdate();

            if (rows > 0) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    record.setId(keys.getInt(1));
                }
                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating medical record: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND MEDICAL RECORD BY PATIENT
    // =========================================================

    public MedicalRecord findByPatientId(int patientId) {

        String sql = "SELECT mr.MedicalRecordId, mr.PatientId, mr.CreatedDate, "
                   + "p.FirstName, p.LastName "
                   + "FROM MedicalRecord mr "
                   + "INNER JOIN Patient pt ON mr.PatientId = pt.PatientId "
                   + "INNER JOIN Person p ON pt.PersonId = p.PersonId "
                   + "WHERE mr.PatientId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                MedicalRecord record = mapMedicalRecord(resultSet);
                connection.close();
                return record;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding medical record: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // MAP RESULTSET TO MEDICAL RECORD (basic info only)
    // =========================================================

    private MedicalRecord mapMedicalRecord(ResultSet resultSet) throws SQLException {

        MedicalRecord record = new MedicalRecord();

        record.setId(resultSet.getInt("MedicalRecordId"));

        Date createdDate = resultSet.getDate("CreatedDate");
        if (createdDate != null) {
            record.setCreatedDate(createdDate.toLocalDate());
        }

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("FirstName"));
        patient.setLastName(resultSet.getString("LastName"));
        record.setPatient(patient);

        return record;
    }
}