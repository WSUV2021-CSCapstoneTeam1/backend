package edu.wsu.backendapi.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.model.Template;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class TemplateDao {

    public TemplateDao() {}

    public Object addTemplate(Template tempAdd) throws SQLException, JsonProcessingException {
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("INSERT INTO template (" +
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

        ObjectMapper mapper = new ObjectMapper();
        String retObj = mapper.writeValueAsString(tempAdd);
        return retObj;
    }

    public int updateTemplate(Template tempAdd, int idIn) throws SQLException, JsonProcessingException {
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("UPDATE template SET " +
                "accountID = ?, active = ?, globalRead = ?, globalResourceName = ?, name = ?," +
                "lookup = ?, type = ?, text = ?, extension = ?, contentType = ? WHERE id = ?");

        stmt.setString(1, tempAdd.getAccountId());
        stmt.setBoolean(2, tempAdd.getActive());
        stmt.setBoolean(3, tempAdd.getGlobalRead());
        stmt.setString(4, tempAdd.getGlobalResourceName());
        stmt.setString(5, tempAdd.getName());
        stmt.setString(6, tempAdd.getLookup());
        stmt.setString(7, tempAdd.getType());
        stmt.setString(8, tempAdd.getText());
        stmt.setString(9, tempAdd.getExtension());
        stmt.setString(10, tempAdd.getContentType());
        stmt.setInt(11, idIn);
        stmt.executeUpdate();

        conn.close();
        return 1;
    }

    public int deleteTemplateByIdRds(int idIn) throws SQLException {
        DBConn conn = new DBConn();

        PreparedStatement stmt2 = conn.makeConnection().prepareStatement( "DELETE FROM template WHERE id = ?");
        stmt2.setInt(1,idIn);
        stmt2.executeUpdate();

        conn.close();
        return 1;
    }

    public Object getTemplateAllRds() throws SQLException {
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("SELECT * FROM template");
        ResultSet resultSet = stmt.executeQuery();

        JSONObject retObj = new JSONObject();
        Collection<JSONObject> templateItems = new ArrayList<JSONObject>();
        retObj.put("pages", -1);
        int count = 0;

        while (resultSet.next()) {
            JSONObject itemObj = new JSONObject();
            itemObj.put("id", resultSet.getInt("id"));
            itemObj.put("accountId", resultSet.getString("accountId"));
            itemObj.put("active", resultSet.getBoolean("active"));
            itemObj.put("globalRead", resultSet.getBoolean("globalRead"));
            itemObj.put("globalResourceName", resultSet.getString("globalResourceName"));
            itemObj.put("name", resultSet.getString("name"));
            itemObj.put("lookup", resultSet.getString("lookup"));
            itemObj.put("type", resultSet.getString("type"));
            itemObj.put("text", resultSet.getString("text"));
            itemObj.put("extension", resultSet.getString("extension"));
            itemObj.put("contentType", resultSet.getString("contentType"));

            templateItems.add(itemObj);
            count += 1;

            //System.out.println(itemObj.toString());
        }

        conn.close();
        retObj.put("data", templateItems);
        retObj.put("count", count);

        return retObj.toString(4);
    }

    public Object getTemplateByIdRds(int idIn) throws SQLException {
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("SELECT * FROM template " +
                "WHERE id = ?");
        stmt.setInt(1, idIn);

        ResultSet resultSet = stmt.executeQuery();

        JSONObject retObj = new JSONObject();
        Collection<JSONObject> templateItems = new ArrayList<JSONObject>();
        retObj.put("pages", -1);
        int count = 0;

        while (resultSet.next()) {
            JSONObject itemObj = new JSONObject();
            itemObj.put("id", resultSet.getInt("id"));
            itemObj.put("accountId", resultSet.getString("accountId"));
            itemObj.put("active", resultSet.getBoolean("active"));
            itemObj.put("globalRead", resultSet.getBoolean("globalRead"));
            itemObj.put("globalResourceName", resultSet.getString("globalResourceName"));
            itemObj.put("name", resultSet.getString("name"));
            itemObj.put("lookup", resultSet.getString("lookup"));
            itemObj.put("type", resultSet.getString("type"));
            itemObj.put("text", resultSet.getString("text"));
            itemObj.put("extension", resultSet.getString("extension"));
            itemObj.put("contentType", resultSet.getString("contentType"));

            templateItems.add(itemObj);
            count += 1;

            //System.out.println(itemObj.toString());
        }

        conn.close();
        retObj.put("data", templateItems);
        retObj.put("count", count);

        return retObj.toString(4);
    }

    public Boolean checkExist(int idIn) throws SQLException {
        DBConn conn = new DBConn();

        PreparedStatement stmt1 = conn.makeConnection().prepareStatement("SELECT * FROM template WHERE id = ?");
        stmt1.setInt(1,idIn);
        ResultSet resultSet1 = stmt1.executeQuery();

        if (resultSet1.next()) {
            conn.close();
            return true;
        } else {
            conn.close();
            return false;
        }
    }

}
