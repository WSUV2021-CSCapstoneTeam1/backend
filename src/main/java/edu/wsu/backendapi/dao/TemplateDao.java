package edu.wsu.backendapi.dao;

import org.json.JSONArray;
import org.json.JSONObject;

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

    public JSONArray getTemplateAllRds() throws SQLException {
        DBConn conn = new DBConn();
        Statement stmt = conn.makeConnection().createStatement();
        String sqlStr = "SELECT * FROM template;";
        ResultSet resultSet = stmt.executeQuery(sqlStr);
//        System.out.println(resultSet);
//        while (resultSet.next()) {
//            System.out.println("accountId: " + resultSet.getString("accountId"));
//            System.out.println("active: " + resultSet.getBoolean("active"));
//            System.out.println("name: " + resultSet.getString("name"));
//            System.out.println("type: " + resultSet.getString("type"));
//
//        }
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject obj = new JSONObject();
            obj.put("accountId", resultSet.getString("accountId"));
            obj.put("active", resultSet.getBoolean("active"));
            obj.put("name", resultSet.getString("name"));
            obj.put("type", resultSet.getString("type"));

            jsonArray.put(obj);
        }
        //String returnSet = rset.toString();
        //JSONObject returnSet = new JSONObject(rset);
        System.out.println(jsonArray);
        return jsonArray;
    }
}
