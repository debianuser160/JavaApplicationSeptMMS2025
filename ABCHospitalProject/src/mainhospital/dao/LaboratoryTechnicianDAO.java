package mainhospital.dao;

import mainhospital.database.DatabaseConnection;
import mainhospital.models.Department;
import mainhospital.models.LaboratoryTechnician;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryTechnicianDAO {

    // =========================================================
    // CREATE LABORATORY TECHNICIAN
    // =========================================================

    public boolean addLaboratoryTechnician(LaboratoryTechnician technician) {

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

        String technicianSql = """
                INSERT INTO LaboratoryTechnician
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

            // Start transaction
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

                statement.setString(
                        1,
                        technician.getFirstName()
                );

                statement.setString(
                        2,
                        technician.getLastName()
                );

                statement.setString(
                        3,
                        String.valueOf(technician.getGender())
                );

                statement.setDate(
                        4,
                        Date.valueOf(technician.getDateOfBirth())
                );

                statement.setString(
                        5,
                        technician.getPhone()
                );

                statement.setString(
                        6,
                        technician.getEmail()
                );

                statement.setString(
                        7,
                        technician.getStreet()
                );

                statement.setString(
                        8,
                        technician.getCity()
                );

                statement.setString(
                        9,
                        technician.getCountry()
                );

                statement.executeUpdate();

                try (
                        ResultSet keys =
                                statement.getGeneratedKeys()
                ) {

                    if (!keys.next()) {
                        throw new SQLException(
                                "PersonId was not generated."
                        );
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

                statement.setDate(
                        1,
                        Date.valueOf(
                                technician.getEmploymentDate()
                        )
                );

                statement.setDouble(
                        2,
                        technician.getSalary()
                );

                statement.setInt(
                        3,
                        technician.getDepartment()
                                .getId()
                );

                statement.setInt(
                        4,
                        personId
                );

                statement.executeUpdate();

                try (
                        ResultSet keys =
                                statement.getGeneratedKeys()
                ) {

                    if (!keys.next()) {

                        throw new SQLException(
                                "StaffId was not generated."
                        );
                    }

                    staffId = keys.getInt(1);
                }
            }

            // =================================================
            // STEP 3: INSERT LABORATORY TECHNICIAN
            // =================================================

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    technicianSql
                            )
            ) {

                statement.setInt(
                        1,
                        staffId
                );

                statement.setString(
                        2,
                        technician.getQualification()
                );

                statement.setString(
                        3,
                        technician.getLicenseNumber()
                );

                statement.executeUpdate();
            }

            // =================================================
            // STEP 4: COMMIT
            // =================================================

            connection.commit();

            technician.setStaffID(staffId);

            System.out.println(
                    "Laboratory technician inserted successfully."
            );

            System.out.println(
                    "Person ID: " + personId
            );

            System.out.println(
                    "Staff ID: " + staffId
            );

            return true;

        } catch (SQLException e) {

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException rollbackException) {

                    rollbackException.printStackTrace();
                }
            }

            System.err.println(
                    "Error inserting laboratory technician: "
                            + e.getMessage()
            );

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
    // READ ALL LABORATORY TECHNICIANS
    // =========================================================

    public List<LaboratoryTechnician> findAllLaboratoryTechnicians() {

        List<LaboratoryTechnician> technicians =
                new ArrayList<>();

        String sql = """
                SELECT
                    s.StaffId,
                    s.PersonId,
                    s.EmploymentDate,
                    s.Salary,
                    s.DepartmentId,

                    lt.Qualification,
                    lt.LicenseNumber,

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

                FROM LaboratoryTechnician lt

                INNER JOIN Staff s
                    ON lt.StaffId = s.StaffId

                INNER JOIN Person p
                    ON s.PersonId = p.PersonId

                LEFT JOIN Department dep
                    ON s.DepartmentId = dep.DepartmentId

                ORDER BY s.StaffId
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                LaboratoryTechnician technician =
                        mapLaboratoryTechnician(resultSet);

                technicians.add(technician);
            }

        } catch (SQLException e) {

            System.err.println(
                    "Error retrieving laboratory technicians: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }

        return technicians;
    }


    // =========================================================
    // READ LABORATORY TECHNICIAN BY STAFF ID
    // =========================================================

    public LaboratoryTechnician findLaboratoryTechnicianById(int staffId) {

        String sql = """
                SELECT
                    s.StaffId,
                    s.PersonId,
                    s.EmploymentDate,
                    s.Salary,
                    s.DepartmentId,

                    lt.Qualification,
                    lt.LicenseNumber,

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

                FROM LaboratoryTechnician lt

                INNER JOIN Staff s
                    ON lt.StaffId = s.StaffId

                INNER JOIN Person p
                    ON s.PersonId = p.PersonId

                LEFT JOIN Department dep
                    ON s.DepartmentId = dep.DepartmentId

                WHERE s.StaffId = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    staffId
            );

            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                if (resultSet.next()) {

                    return mapLaboratoryTechnician(resultSet);
                }
            }

        } catch (SQLException e) {

            System.err.println(
                    "Error finding laboratory technician: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // UPDATE LABORATORY TECHNICIAN
    // =========================================================

    public boolean update(LaboratoryTechnician technician) {

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

        String technicianSql = """
                UPDATE LaboratoryTechnician

                SET
                    Qualification = ?,
                    LicenseNumber = ?

                WHERE StaffId = ?
                """;

        Connection connection = null;

        try {

            connection =
                    DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            // =================================================
            // FIND PERSON ID
            // =================================================

            int personId =
                    getPersonId(
                            connection,
                            technician.getStaffID()
                    );

            if (personId == -1) {

                connection.rollback();

                System.out.println(
                        "Laboratory technician not found."
                );

                return false;
            }


            // =================================================
            // UPDATE PERSON
            // =================================================

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    personSql
                            )
            ) {

                statement.setString(
                        1,
                        technician.getFirstName()
                );

                statement.setString(
                        2,
                        technician.getLastName()
                );

                statement.setString(
                        3,
                        String.valueOf(
                                technician.getGender()
                        )
                );

                statement.setDate(
                        4,
                        Date.valueOf(
                                technician.getDateOfBirth()
                        )
                );

                statement.setString(
                        5,
                        technician.getPhone()
                );

                statement.setString(
                        6,
                        technician.getEmail()
                );

                statement.setString(
                        7,
                        technician.getStreet()
                );

                statement.setString(
                        8,
                        technician.getCity()
                );

                statement.setString(
                        9,
                        technician.getCountry()
                );

                statement.setInt(
                        10,
                        personId
                );

                statement.executeUpdate();
            }


            // =================================================
            // UPDATE STAFF
            // =================================================

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    staffSql
                            )
            ) {

                statement.setDate(
                        1,
                        Date.valueOf(
                                technician.getEmploymentDate()
                        )
                );

                statement.setDouble(
                        2,
                        technician.getSalary()
                );

                statement.setInt(
                        3,
                        technician.getDepartment()
                                .getId()
                );

                statement.setInt(
                        4,
                        technician.getStaffID()
                );

                statement.executeUpdate();
            }


            // =================================================
            // UPDATE LABORATORY TECHNICIAN
            // =================================================

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    technicianSql
                            )
            ) {

                statement.setString(
                        1,
                        technician.getQualification()
                );

                statement.setString(
                        2,
                        technician.getLicenseNumber()
                );

                statement.setInt(
                        3,
                        technician.getStaffID()
                );

                statement.executeUpdate();
            }


            // =================================================
            // COMMIT
            // =================================================

            connection.commit();

            System.out.println(
                    "Laboratory technician updated successfully."
            );

            return true;

        } catch (SQLException e) {

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException rollbackException) {

                    rollbackException.printStackTrace();
                }
            }

            System.err.println(
                    "Error updating laboratory technician: "
                            + e.getMessage()
            );

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
    // DELETE LABORATORY TECHNICIAN
    // =========================================================

    public boolean delete(int staffId) {

        Connection connection = null;

        try {

            connection =
                    DatabaseConnection.getConnection();

            connection.setAutoCommit(false);

            // =================================================
            // FIND PERSON ID
            // =================================================

            int personId =
                    getPersonId(
                            connection,
                            staffId
                    );

            if (personId == -1) {

                connection.rollback();

                return false;
            }


            // =================================================
            // DELETE LABORATORY TECHNICIAN
            // =================================================

            String technicianSql = """
                    DELETE FROM LaboratoryTechnician
                    WHERE StaffId = ?
                    """;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    technicianSql
                            )
            ) {

                statement.setInt(
                        1,
                        staffId
                );

                statement.executeUpdate();
            }


            // =================================================
            // DELETE STAFF
            // =================================================

            String staffSql = """
                    DELETE FROM Staff
                    WHERE StaffId = ?
                    """;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    staffSql
                            )
            ) {

                statement.setInt(
                        1,
                        staffId
                );

                statement.executeUpdate();
            }


            // =================================================
            // DELETE PERSON
            // =================================================

            String personSql = """
                    DELETE FROM Person
                    WHERE PersonId = ?
                    """;

            try (
                    PreparedStatement statement =
                            connection.prepareStatement(
                                    personSql
                            )
            ) {

                statement.setInt(
                        1,
                        personId
                );

                statement.executeUpdate();
            }


            // =================================================
            // COMMIT
            // =================================================

            connection.commit();

            System.out.println(
                    "Laboratory technician deleted successfully."
            );

            return true;

        } catch (SQLException e) {

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException rollbackException) {

                    rollbackException.printStackTrace();
                }
            }

            System.err.println(
                    "Error deleting laboratory technician: "
                            + e.getMessage()
            );

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

    private int getPersonId(
            Connection connection,
            int staffId
    ) throws SQLException {

        String sql = """
                SELECT PersonId
                FROM Staff
                WHERE StaffId = ?
                """;

        try (
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    staffId
            );

            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                if (resultSet.next()) {

                    return resultSet.getInt(
                            "PersonId"
                    );
                }
            }
        }

        return -1;
    }


    // =========================================================
    // MAP RESULTSET TO LABORATORY TECHNICIAN
    // =========================================================

    private LaboratoryTechnician mapLaboratoryTechnician(
            ResultSet resultSet
    ) throws SQLException {

        LaboratoryTechnician technician =
                new LaboratoryTechnician();

        // =====================================================
        // STAFF ID
        // =====================================================

        technician.setStaffID(
                resultSet.getInt(
                        "StaffId"
                )
        );


        // =====================================================
        // PERSON INFORMATION
        // =====================================================

        technician.setFirstName(
                resultSet.getString(
                        "FirstName"
                )
        );

        technician.setLastName(
                resultSet.getString(
                        "LastName"
                )
        );

        String gender =
                resultSet.getString(
                        "Gender"
                );

        if (gender != null &&
                !gender.isEmpty()) {

            technician.setGender(
                    gender.charAt(0)
            );
        }

        Date dateOfBirth =
                resultSet.getDate(
                        "DateOfBirth"
                );

        if (dateOfBirth != null) {

            technician.setDateOfBirth(
                    dateOfBirth.toLocalDate()
            );
        }

        technician.setPhone(
                resultSet.getString(
                        "Phone"
                )
        );

        technician.setEmail(
                resultSet.getString(
                        "Email"
                )
        );

        technician.setStreet(
                resultSet.getString(
                        "Street"
                )
        );

        technician.setCity(
                resultSet.getString(
                        "City"
                )
        );

        technician.setCountry(
                resultSet.getString(
                        "Country"
                )
        );


        // =====================================================
        // STAFF INFORMATION
        // =====================================================

        Date employmentDate =
                resultSet.getDate(
                        "EmploymentDate"
                );

        if (employmentDate != null) {

            technician.setEmploymentDate(
                    employmentDate.toLocalDate()
            );
        }

        technician.setSalary(
                resultSet.getDouble(
                        "Salary"
                )
        );


        // =====================================================
        // DEPARTMENT
        // =====================================================

        Department department =
                new Department();

        department.setId(
                resultSet.getInt(
                        "DepartmentId"
                )
        );

        department.setName(
                resultSet.getString(
                        "DepartmentName"
                )
        );

        technician.setDepartment(
                department
        );


        // =====================================================
        // LABORATORY TECHNICIAN INFORMATION
        // =====================================================

        technician.setQualification(
                resultSet.getString(
                        "Qualification"
                )
        );

        technician.setLicenseNumber(
                resultSet.getString(
                        "LicenseNumber"
                )
        );

        return technician;
    }
}