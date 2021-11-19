package edu.wsu.backendapi.dao;

import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TemplateDao {

    public TemplateDao() {
    }

    public String addTemplate(JSONObject tempAdd) throws SQLException {
        //System.out.println(tempAdd.getString("accountId"));
        //System.out.println(tempAdd.getBoolean("active"));
        DBConn conn = new DBConn();
        Statement stmt = conn.makeConnection().createStatement();
        String sqlStr = "INSERT INTO template (accountId, active, globalRead, globalResourceName, name, lookup, type, text, extension, contentType) " +
                "VALUES (" +
                "\'" + tempAdd.getString("accountId") + "\'," +
                tempAdd.getBoolean("active") + "," +
                tempAdd.getBoolean("globalRead") + "," +
                "\'" + tempAdd.getString("globalResourceName") + "\'," +
                "\'" + tempAdd.getString("name") + "\'," +
                "\'" + tempAdd.getString("lookup") + "\'," +
                "\'" + tempAdd.getString("type") + "\'," +
                "\'" + tempAdd.getString("text") + "\'," +
                "\'" + tempAdd.getString("extension") + "\'," +
                "\'" + tempAdd.getString("contentType") + "\'" +
                ");";
        stmt.executeUpdate(sqlStr);
        return "new template added";
    }

    public String getTemplateAllRds() throws SQLException {
        DBConn conn = new DBConn();
        Statement stmt = conn.makeConnection().createStatement();
        String sqlStr = "SELECT * FROM template;";
        ResultSet resultSet = stmt.executeQuery(sqlStr);
        int pages = -1;
        int count = 0;
        String retString = "{ \'pages\':" + pages + ",\'data\': [";
        while (resultSet.next()) {
            if (count != 0) { retString += ","; }
            retString += "{";
            retString += "\'id\':" + resultSet.getInt("id") + ",";
            retString += "\'accountId\':\'" + resultSet.getString("accountId") + "\',";
            retString += "\'active\':" + resultSet.getBoolean("active") + ",";
            retString += "\'globalRead\':" + resultSet.getBoolean("globalRead") + ",";
            retString += "\'globalResourceName\':\'" + resultSet.getString("globalResourceName") + "\',";
            retString += "\'name\':\'" + resultSet.getString("name") + "\',";
            retString += "\'lookup\':\'" + resultSet.getString("lookup") + "\',";
            retString += "\'type\':\'" + resultSet.getString("type") + "\',";
            retString += "\'extension\':\'" + resultSet.getString("extension") + "\',";
            retString += "\'contentType\':\'" + resultSet.getString("contentType") + "\'";
            retString += "}";
            count += 1;
        }
        retString += "],";
        retString += "\'count\':" + count;
        retString += "}";
        //System.out.println(retString);
        JSONObject retStrObj = new JSONObject(retString);

        return retStrObj.toString(4);
    }

    public String getTemplateByIdRds(int idIn) throws SQLException {
        DBConn conn = new DBConn();
        Statement stmt = conn.makeConnection().createStatement();
        String sqlStr = "SELECT * FROM template WHERE id=" + idIn + ";";
        ResultSet resultSet = stmt.executeQuery(sqlStr);
        int pages = -1;
        int count = 0;
        String retString = "{ \'pages\':" + pages + ",\'data\': [";
        while (resultSet.next()) {
            if (count != 0) { retString += ","; }
            retString += "{";
            retString += "\'id\':" + resultSet.getInt("id") + ",";
            retString += "\'accountId\':\'" + resultSet.getString("accountId") + "\',";
            retString += "\'active\':" + resultSet.getBoolean("active") + ",";
            retString += "\'globalRead\':" + resultSet.getBoolean("globalRead") + ",";
            retString += "\'globalResourceName\':\'" + resultSet.getString("globalResourceName") + "\',";
            retString += "\'name\':\'" + resultSet.getString("name") + "\',";
            retString += "\'lookup\':\'" + resultSet.getString("lookup") + "\',";
            retString += "\'type\':\'" + resultSet.getString("type") + "\',";
            retString += "\'extension\':\'" + resultSet.getString("extension") + "\',";
            retString += "\'contentType\':\'" + resultSet.getString("contentType") + "\'";
            retString += "}";
            count += 1;
        }
        retString += "],";
        retString += "\'count\':" + count;
        retString += "}";
        //System.out.println(retString);
        JSONObject retStrObj = new JSONObject(retString);

        return retStrObj.toString(4);
    }
}
