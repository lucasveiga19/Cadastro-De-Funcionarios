package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=cadastro;user=sa;password=123;integratedSecurity=false;trustServerCertificate=true;"
            );
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
