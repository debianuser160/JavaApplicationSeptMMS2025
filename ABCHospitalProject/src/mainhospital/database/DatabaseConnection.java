
package mainhospital.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = 
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=ABCHospitalProjectDatabase;"
            + "encrypt=false;"
            + "trustServerCertificate=true";
            
    
    private static final String USERNAME = "projecthospital";
    private static final String PASSWORD = "13579";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                URL,
                USERNAME,
                PASSWORD
        );
    }
            
}
