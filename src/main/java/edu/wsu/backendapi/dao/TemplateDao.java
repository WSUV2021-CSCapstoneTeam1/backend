package edu.wsu.backendapi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TemplateDao {

    public TemplateDao() {
    }

    public String addTemplate(String newTemplate) throws SQLException {
        DBConn conn = new DBConn();
        Statement stmt = conn.makeConnection().createStatement();
        String sqlStr = "INSERT INTO test1 VALUES (\'" + newTemplate + "\');";
        stmt.executeUpdate(sqlStr);
        //System.out.println(rset);
        String build = newTemplate + " was added";
        return build;
    }
}
