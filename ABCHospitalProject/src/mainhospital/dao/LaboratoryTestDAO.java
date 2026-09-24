package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.LaboratoryTechnician;
import mainhospital.models.LaboratoryTest;
import mainhospital.models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryTestDAO {

    // =========================================================
    // CREATE LABORATORY TEST
    // =========================================================

    public boolean addLaboratoryTest(LaboratoryTest test) {

        String sql = "INSERT INTO LaboratoryTest "
                   + "(PatientId, LaboratoryTechnicianId, TestName, TestDate, Result, ReferenceRange, Status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, test.getPatient().getPatientID());
            statement.setInt(2, test.getTechnician().getStaffID());
            statement.setString(3, test.getTestName());
            statement.setTimestamp(4, Timestamp.valueOf(test.getTestDate()));
            statement.setString(5, test.getResult());
            statement.setString(6, test.getReferenceRange());
            statement.setString(7, test.getStatus());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    test.setId(keys.getInt(1));
                }
                keys.close();
            }

            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error creating laboratory test: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // FIND ALL LABORATORY TESTS
    // =========================================================

    public List<LaboratoryTest> findAllLaboratoryTests() {

        List<LaboratoryTest> tests = new ArrayList<>();

        String sql = baseSelect() + " ORDER BY lt.LaboratoryTestId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tests.add(mapLaboratoryTest(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving laboratory tests: " + e.getMessage());
        }

        return tests;
    }


    // =========================================================
    // FIND LABORATORY TESTS BY PATIENT
    // =========================================================

    public List<LaboratoryTest> findLaboratoryTestsByPatient(int patientId) {

        List<LaboratoryTest> tests = new ArrayList<>();

        String sql = baseSelect() + " WHERE lt.PatientId = ? ORDER BY lt.LaboratoryTestId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tests.add(mapLaboratoryTest(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving laboratory tests for patient: " + e.getMessage());
        }

        return tests;
    }


    // =========================================================
    // FIND PENDING LABORATORY TESTS
    // =========================================================

    public List<LaboratoryTest> findPendingLaboratoryTests() {

        List<LaboratoryTest> tests = new ArrayList<>();

        String sql = baseSelect() + " WHERE lt.Status = 'Pending' ORDER BY lt.LaboratoryTestId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tests.add(mapLaboratoryTest(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving pending laboratory tests: " + e.getMessage());
        }

        return tests;
    }


    // =========================================================
    // FIND COMPLETED LABORATORY TESTS
    // =========================================================

    public List<LaboratoryTest> findCompletedLaboratoryTests() {

        List<LaboratoryTest> tests = new ArrayList<>();

        String sql = baseSelect() + " WHERE lt.Status = 'Completed' ORDER BY lt.LaboratoryTestId";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tests.add(mapLaboratoryTest(resultSet));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving completed laboratory tests: " + e.getMessage());
        }

        return tests;
    }


    // =========================================================
    // FIND LABORATORY TEST BY ID
    // =========================================================

    public LaboratoryTest findLaboratoryTestById(int id) {

        String sql = baseSelect() + " WHERE lt.LaboratoryTestId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                LaboratoryTest test = mapLaboratoryTest(resultSet);
                connection.close();
                return test;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error finding laboratory test: " + e.getMessage());
        }

        return null;
    }


    // =========================================================
    // UPDATE LABORATORY TEST
    // =========================================================

    public boolean update(LaboratoryTest test) {

        String sql = "UPDATE LaboratoryTest SET TestName = ?, ReferenceRange = ?, Status = ? "
                   + "WHERE LaboratoryTestId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, test.getTestName());
            statement.setString(2, test.getReferenceRange());
            statement.setString(3, test.getStatus());
            statement.setInt(4, test.getId());

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating laboratory test: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // RECORD TEST RESULT
    // =========================================================

    public boolean recordResult(int id, String result, String status) {

        String sql = "UPDATE LaboratoryTest SET Result = ?, Status = ? WHERE LaboratoryTestId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, result);
            statement.setString(2, status);
            statement.setInt(3, id);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error recording test result: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // DELETE LABORATORY TEST
    // =========================================================

    public boolean delete(int id) {

        String sql = "DELETE FROM LaboratoryTest WHERE LaboratoryTestId = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            connection.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting laboratory test: " + e.getMessage());
        }

        return false;
    }


    // =========================================================
    // BASE SELECT
    // =========================================================

    private String baseSelect() {

        return "SELECT lt.LaboratoryTestId, lt.PatientId, lt.LaboratoryTechnicianId, lt.TestName, "
             + "lt.TestDate, lt.Result, lt.ReferenceRange, lt.Status, "
             + "pp.FirstName AS PatientFirstName, pp.LastName AS PatientLastName, "
             + "tp.FirstName AS TechnicianFirstName, tp.LastName AS TechnicianLastName "
             + "FROM LaboratoryTest lt "
             + "INNER JOIN Patient pt ON lt.PatientId = pt.PatientId "
             + "INNER JOIN Person pp ON pt.PersonId = pp.PersonId "
             + "INNER JOIN Staff ts ON lt.LaboratoryTechnicianId = ts.StaffId "
             + "INNER JOIN Person tp ON ts.PersonId = tp.PersonId";
    }


    // =========================================================
    // MAP RESULTSET TO LABORATORY TEST
    // =========================================================

    private LaboratoryTest mapLaboratoryTest(ResultSet resultSet) throws SQLException {

        LaboratoryTest test = new LaboratoryTest();

        test.setId(resultSet.getInt("LaboratoryTestId"));
        test.setTestName(resultSet.getString("TestName"));
        test.setResult(resultSet.getString("Result"));
        test.setReferenceRange(resultSet.getString("ReferenceRange"));
        test.setStatus(resultSet.getString("Status"));

        Timestamp testDate = resultSet.getTimestamp("TestDate");
        if (testDate != null) {
            test.setTestDate(testDate.toLocalDateTime());
        }

        Patient patient = new Patient();
        patient.setPatientID(resultSet.getInt("PatientId"));
        patient.setFirstName(resultSet.getString("PatientFirstName"));
        patient.setLastName(resultSet.getString("PatientLastName"));
        test.setPatient(patient);

        LaboratoryTechnician technician = new LaboratoryTechnician();
        technician.setStaffID(resultSet.getInt("LaboratoryTechnicianId"));
        technician.setFirstName(resultSet.getString("TechnicianFirstName"));
        technician.setLastName(resultSet.getString("TechnicianLastName"));
        test.setTechnician(technician);

        return test;
    }
}