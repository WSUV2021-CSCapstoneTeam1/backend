package edu.wsu.backendapi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private Connection con;

    public DBConn() {
    }
    public Connection makeConnection() {
        GetDBCredentials rdsCreds = new GetDBCredentials();
        String[] creds = rdsCreds.getRDSCredentials();
        String jdbcUrl = "jdbc:mysql://" + creds[1] + ":3306/backend?user=admin&password=" + creds[0];

        //Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl);
            System.out.println("Remote connection successful.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return con;
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
