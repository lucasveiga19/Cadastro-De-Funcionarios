package dao;

import java.sql.*;

public class ConnectionFactory {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=cadastro;user=sa;password=123;integratedSecurity=false;trustServerCertificate=true;"
            );
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
