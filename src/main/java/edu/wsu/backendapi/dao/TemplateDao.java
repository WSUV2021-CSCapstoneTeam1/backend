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

    public String getTemplateAllRds() throws SQLException {
        DBConn conn = new DBConn();
        Statement stmt = conn.makeConnection().createStatement();
        String sqlStr = "SELECT * FROM template;";
        ResultSet resultSet = stmt.executeQuery(sqlStr);
        String retString = "{ \'size\':" + resultSet.getFetchSize() + ", \'data\': [";
//        System.out.println(resultSet);
        while (resultSet.next()) {
            retString += "{";
            retString += "\'id\':" + resultSet.getInt("id") + ",";
            retString += "\'accountId\':\'" + resultSet.getString("accountId") + "\',";
            retString += "\'active\':" + resultSet.getBoolean("active") + ",";
            retString += "\'name\':\'" + resultSet.getString("name") + "\',";
            retString += "\'type\':\'" + resultSet.getString("type") + "\'";
            retString += "}";
//            System.out.println("accountId: " + resultSet.getString("accountId"));
//            System.out.println("active: " + resultSet.getBoolean("active"));
//            System.out.println("name: " + resultSet.getString("name"));
//            System.out.println("type: " + resultSet.getString("type"));
        }
        retString += "]}";
        System.out.println(retString);
//        JSONArray jsonArray = new JSONArray();
//        while (resultSet.next()) {
//            JSONObject obj = new JSONObject();
//            obj.put("accountId", resultSet.getString("accountId"));
//            obj.put("active", resultSet.getBoolean("active"));
//            obj.put("name", resultSet.getString("name"));
//            obj.put("type", resultSet.getString("type"));
//
//            jsonArray.put(obj);
//        }
//        //String returnSet = rset.toString();
//        //JSONObject returnSet = new JSONObject(rset);
//        System.out.println(jsonArray);
        JSONObject retStrObj = new JSONObject(retString);

        return retStrObj.toString();
    }
}
