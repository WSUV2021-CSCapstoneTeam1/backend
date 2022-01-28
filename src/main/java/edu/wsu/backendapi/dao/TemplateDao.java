package edu.wsu.backendapi.dao;

import edu.wsu.backendapi.model.Template;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TemplateDao {

    public TemplateDao() {
    }

    public String addTemplate(Template tempAdd) {
        DBConn conn = new DBConn();

        PreparedStatement stmt = null;
        try {
            stmt = conn.makeConnection().prepareStatement("INSERT INTO template (" +
                    "accountID, active, globalRead, globalResourceName, name, lookup, type, text, " +
                    "extension, contentType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1,tempAdd.getAccountId());
            stmt.setBoolean(2,tempAdd.getActive());
            stmt.setBoolean(3,tempAdd.getGlobalRead());
            stmt.setString(4,tempAdd.getGlobalResourceName());
            stmt.setString(5,tempAdd.getName());
            stmt.setString(6,tempAdd.getLookup());
            stmt.setString(7,tempAdd.getType());
            stmt.setString(8,tempAdd.getText());
            stmt.setString(9,tempAdd.getExtension());
            stmt.setString(10,tempAdd.getContentType());
            stmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "new template added";
    }

    public String updateTemplate(Template tempAdd, int idIn) {
        DBConn conn = new DBConn();

        PreparedStatement stmt = null;
        try {

            stmt = conn.makeConnection().prepareStatement("UPDATE template SET " +
                    "accountID = ?, active = ?, globalRead = ?, globalResourceName = ?, name = ?," +
                    "lookup = ?, type = ?, text = ?, extension = ?, contentType = ? WHERE id = ?");

            stmt.setString(1,tempAdd.getAccountId());
            stmt.setBoolean(2,tempAdd.getActive());
            stmt.setBoolean(3,tempAdd.getGlobalRead());
            stmt.setString(4,tempAdd.getGlobalResourceName());
            stmt.setString(5,tempAdd.getName());
            stmt.setString(6,tempAdd.getLookup());
            stmt.setString(7,tempAdd.getType());
            stmt.setString(8,tempAdd.getText());
            stmt.setString(9,tempAdd.getExtension());
            stmt.setString(10,tempAdd.getContentType());
            stmt.setInt(11,idIn);
            stmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "template updated";
    }

    public int deleteTemplateByIdRds(int idIn) throws SQLException {
        DBConn conn = new DBConn();

        PreparedStatement stmt1 = conn.makeConnection().prepareStatement("SELECT * FROM template WHERE id = ?");
        stmt1.setInt(1,idIn);
        ResultSet resultSet1 = stmt1.executeQuery();

        if (resultSet1.next()) {
            PreparedStatement stmt2 = conn.makeConnection().prepareStatement( "DELETE FROM template WHERE id = ?");
            stmt2.setInt(1,idIn);
            stmt2.executeUpdate();
            conn.close();
            return 1;
        } else {
            conn.close();
            return -1;
        }
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
            retString += "\'text\':\'" + resultSet.getString("text") + "\',";
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

        conn.close();
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
            retString += "\'text\':\'" + resultSet.getString("text") + "\',";
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

        conn.close();
        return retStrObj.toString(4);
    }
}
