package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Department;
import mainhospital.models.Pharmacist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacistDAO {

    // =========================================================
    // CREATE PHARMACIST
    // =========================================================

    public boolean addPharmacist(Pharmacist pharmacist) {

        String personSql = """
                INSERT INTO Person
                (
                    FirstName,
                    LastName,
                    Gender,
                    DateOfBirth,
                    Phone,
                    Email,
                    Street,
                    City,
                    Country
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        String staffSql = """
                INSERT INTO Staff
                (
                    EmploymentDate,
                    Salary,
                    DepartmentId,
                    PersonId
                )
                VALUES (?, ?, ?, ?)
                """;

        String pharmacistSql = """
                INSERT INTO Pharmacist
                (
                    StaffId,
                    Qualification,
                    LicenseNumber
                )
                VALUES (?, ?, ?)
                """;

        Connection connection = null;

        try {

            connection = DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            // =================================================
            // STEP 1: INSERT PERSON
            // =================================================

            int personId;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    personSql,
                                    Statement.RETURN_GENERATED_KEYS
                            )
            ) {

                statement.setString(1, pharmacist.getFirstName());
                statement.setString(2, pharmacist.getLastName());
                statement.setString(3, String.valueOf(pharmacist.getGender()));
                statement.setDate(4, Date.valueOf(pharmacist.getDateOfBirth()));
                statement.setString(5, pharmacist.getPhone());
                statement.setString(6, pharmacist.getEmail());
                statement.setString(7, pharmacist.getStreet());
                statement.setString(8, pharmacist.getCity());
                statement.setString(9, pharmacist.getCountry());

                statement.executeUpdate();

                try (ResultSet keys = statement.getGeneratedKeys()) {

                    if (!keys.next()) {
                        throw new SQLException("PersonId was not generated.");
                    }

                    personId = keys.getInt(1);
                }
            }

            // =================================================
            // STEP 2: INSERT STAFF
            // =================================================

            int staffId;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    staffSql,
                                    Statement.RETURN_GENERATED_KEYS
                            )
            ) {

                statement.setDate(1, Date.valueOf(pharmacist.getEmploymentDate()));
                statement.setDouble(2, pharmacist.getSalary());
                statement.setInt(3, pharmacist.getDepartment().getId());
                statement.setInt(4, personId);

                statement.executeUpdate();

                try (ResultSet keys = statement.getGeneratedKeys()) {

                    if (!keys.next()) {
                        throw new SQLException("StaffId was not generated.");
                    }

                    staffId = keys.getInt(1);
                }
            }

            // =================================================
            // STEP 3: INSERT PHARMACIST
            // =================================================

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(pharmacistSql)
            ) {

                statement.setInt(1, staffId);
                statement.setString(2, pharmacist.getQualification());
                statement.setString(3, pharmacist.getLicenseNumber());

                statement.executeUpdate();
            }

            // =================================================
            // STEP 4: COMMIT
            // =================================================

            connection.commit();

            pharmacist.setStaffID(staffId);

            System.out.println("Pharmacist inserted successfully.");
            System.out.println("Person ID: " + personId);
            System.out.println("Staff ID: " + staffId);

            return true;

        } catch (SQLException e) {

            if (connection != null) {

                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }

            System.err.println("Error inserting pharmacist: " + e.getMessage());
            e.printStackTrace();

            return false;

        } finally {

            if (connection != null) {

                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // =========================================================
    // READ ALL PHARMACISTS
    // =========================================================

    public List<Pharmacist> findAllPharmacists() {

        List<Pharmacist> pharmacists = new ArrayList<>();

        String sql = """
                SELECT
                    s.StaffId,
                    s.PersonId,
                    s.EmploymentDate,
                    s.Salary,
                    s.DepartmentId,

                    ph.Qualification,
                    ph.LicenseNumber,

                    p.FirstName,
                    p.LastName,
                    p.Gender,
                    p.DateOfBirth,
                    p.Phone,
                    p.Email,
                    p.Street,
                    p.City,
                    p.Country,

                    dep.Name AS DepartmentName

                FROM Pharmacist ph

                INNER JOIN Staff s
                    ON ph.StaffId = s.StaffId

                INNER JOIN Person p
                    ON s.PersonId = p.PersonId

                LEFT JOIN Department dep
                    ON s.DepartmentId = dep.DepartmentId

                ORDER BY s.StaffId
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {
                pharmacists.add(mapPharmacist(resultSet));
            }

        } catch (SQLException e) {

            System.err.println("Error retrieving pharmacists: " + e.getMessage());
            e.printStackTrace();
        }

        return pharmacists;
    }


    // =========================================================
    // READ PHARMACIST BY STAFF ID
    // =========================================================

    public Pharmacist findPharmacistById(int staffId) {

        String sql = """
                SELECT
                    s.StaffId,
                    s.PersonId,
                    s.EmploymentDate,
                    s.Salary,
                    s.DepartmentId,

                    ph.Qualification,
                    ph.LicenseNumber,

                    p.FirstName,
                    p.LastName,
                    p.Gender,
                    p.DateOfBirth,
                    p.Phone,
                    p.Email,
                    p.Street,
                    p.City,
                    p.Country,

                    dep.Name AS DepartmentName

                FROM Pharmacist ph

                INNER JOIN Staff s
                    ON ph.StaffId = s.StaffId

                INNER JOIN Person p
                    ON s.PersonId = p.PersonId

                LEFT JOIN Department dep
                    ON s.DepartmentId = dep.DepartmentId

                WHERE s.StaffId = ?
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, staffId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return mapPharmacist(resultSet);
                }
            }

        } catch (SQLException e) {

            System.err.println("Error finding pharmacist: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // UPDATE PHARMACIST
    // =========================================================

    public boolean update(Pharmacist pharmacist) {

        String personSql = """
                UPDATE Person

                SET
                    FirstName = ?,
                    LastName = ?,
                    Gender = ?,
                    DateOfBirth = ?,
                    Phone = ?,
                    Email = ?,
                    Street = ?,
                    City = ?,
                    Country = ?

                WHERE PersonId = ?
                """;

        String staffSql = """
                UPDATE Staff

                SET
                    EmploymentDate = ?,
                    Salary = ?,
                    DepartmentId = ?

                WHERE StaffId = ?
                """;

        String pharmacistSql = """
                UPDATE Pharmacist

                SET
                    Qualification = ?,
                    LicenseNumber = ?

                WHERE StaffId = ?
                """;

        Connection connection = null;

        try {

            connection = DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            int personId = getPersonId(connection, pharmacist.getStaffID());

            if (personId == -1) {

                connection.rollback();

                System.out.println("Pharmacist not found.");

                return false;
            }

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(personSql)
            ) {

                statement.setString(1, pharmacist.getFirstName());
                statement.setString(2, pharmacist.getLastName());
                statement.setString(3, String.valueOf(pharmacist.getGender()));
                statement.setDate(4, Date.valueOf(pharmacist.getDateOfBirth()));
                statement.setString(5, pharmacist.getPhone());
                statement.setString(6, pharmacist.getEmail());
                statement.setString(7, pharmacist.getStreet());
                statement.setString(8, pharmacist.getCity());
                statement.setString(9, pharmacist.getCountry());
                statement.setInt(10, personId);

                statement.executeUpdate();
            }

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(staffSql)
            ) {

                statement.setDate(1, Date.valueOf(pharmacist.getEmploymentDate()));
                statement.setDouble(2, pharmacist.getSalary());
                statement.setInt(3, pharmacist.getDepartment().getId());
                statement.setInt(4, pharmacist.getStaffID());

                statement.executeUpdate();
            }

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(pharmacistSql)
            ) {

                statement.setString(1, pharmacist.getQualification());
                statement.setString(2, pharmacist.getLicenseNumber());
                statement.setInt(3, pharmacist.getStaffID());

                statement.executeUpdate();
            }

            connection.commit();

            System.out.println("Pharmacist updated successfully.");

            return true;

        } catch (SQLException e) {

            if (connection != null) {

                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }

            System.err.println("Error updating pharmacist: " + e.getMessage());
            e.printStackTrace();

            return false;

        } finally {

            if (connection != null) {

                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // =========================================================
    // DELETE PHARMACIST
    // =========================================================

    public boolean delete(int staffId) {

        Connection connection = null;

        try {

            connection = DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            int personId = getPersonId(connection, staffId);

            if (personId == -1) {

                connection.rollback();

                return false;
            }

            String pharmacistSql = """
                    DELETE FROM Pharmacist
                    WHERE StaffId = ?
                    """;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(pharmacistSql)
            ) {

                statement.setInt(1, staffId);
                statement.executeUpdate();
            }

            String staffSql = """
                    DELETE FROM Staff
                    WHERE StaffId = ?
                    """;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(staffSql)
            ) {

                statement.setInt(1, staffId);
                statement.executeUpdate();
            }

            String personSql = """
                    DELETE FROM Person
                    WHERE PersonId = ?
                    """;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(personSql)
            ) {

                statement.setInt(1, personId);
                statement.executeUpdate();
            }

            connection.commit();

            System.out.println("Pharmacist deleted successfully.");

            return true;

        } catch (SQLException e) {

            if (connection != null) {

                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }

            System.err.println("Error deleting pharmacist: " + e.getMessage());
            e.printStackTrace();

            return false;

        } finally {

            if (connection != null) {

                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // =========================================================
    // GET PERSON ID
    // =========================================================

    private int getPersonId(Connection connection, int staffId) throws SQLException {

        String sql = """
                SELECT PersonId
                FROM Staff
                WHERE StaffId = ?
                """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, staffId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return resultSet.getInt("PersonId");
                }
            }
        }

        return -1;
    }


    // =========================================================
    // MAP RESULTSET TO PHARMACIST
    // =========================================================

    private Pharmacist mapPharmacist(ResultSet resultSet) throws SQLException {

        Pharmacist pharmacist = new Pharmacist();

        pharmacist.setStaffID(resultSet.getInt("StaffId"));

        pharmacist.setFirstName(resultSet.getString("FirstName"));
        pharmacist.setLastName(resultSet.getString("LastName"));

        String gender = resultSet.getString("Gender");

        if (gender != null && !gender.isEmpty()) {
            pharmacist.setGender(gender.charAt(0));
        }

        Date dateOfBirth = resultSet.getDate("DateOfBirth");

        if (dateOfBirth != null) {
            pharmacist.setDateOfBirth(dateOfBirth.toLocalDate());
        }

        pharmacist.setPhone(resultSet.getString("Phone"));
        pharmacist.setEmail(resultSet.getString("Email"));
        pharmacist.setStreet(resultSet.getString("Street"));
        pharmacist.setCity(resultSet.getString("City"));
        pharmacist.setCountry(resultSet.getString("Country"));

        Date employmentDate = resultSet.getDate("EmploymentDate");

        if (employmentDate != null) {
            pharmacist.setEmploymentDate(employmentDate.toLocalDate());
        }

        pharmacist.setSalary(resultSet.getDouble("Salary"));

        Department department = new Department();

        department.setId(resultSet.getInt("DepartmentId"));
        department.setName(resultSet.getString("DepartmentName"));

        pharmacist.setDepartment(department);

        pharmacist.setQualification(resultSet.getString("Qualification"));
        pharmacist.setLicenseNumber(resultSet.getString("LicenseNumber"));

        return pharmacist;
    }
}