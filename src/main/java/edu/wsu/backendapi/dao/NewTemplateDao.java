package edu.wsu.backendapi.dao;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.model.Template;
import edu.wsu.backendapi.security.PreProcess;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NewTemplateDao {

    public NewTemplateDao() {}

    public String post(HashMap<String,Object> input) throws Exception {
        Template template;
        ObjectMapper objectMapper = new ObjectMapper();
        template = objectMapper.readValue((String) input.get("body"), Template.class);
        PreProcess.PreProcessTemplate(template);
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("INSERT INTO template (" +
                    "accountID, active, globalRead, globalResourceName, name, lookup, type, text, " +
                    "extension, contentType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        stmt.setString(1,template.getAccountId());
        stmt.setBoolean(2,template.getActive());
        stmt.setBoolean(3,template.getGlobalRead());
        stmt.setString(4,template.getGlobalResourceName());
        stmt.setString(5,template.getName());
        stmt.setString(6,template.getLookup());
        stmt.setString(7,template.getType());
        stmt.setString(8,template.getText());
        stmt.setString(9,template.getExtension());
        stmt.setString(10,template.getContentType());
        stmt.executeUpdate();

        conn.close();

        ObjectMapper mapper = new ObjectMapper();
        String retObj = mapper.writeValueAsString(template);
        return retObj;
    }

    public String update(HashMap<String,Object> input) throws Exception {
        Template template;
        Integer id = (Integer) input.get("id");
        ObjectMapper objectMapper = new ObjectMapper();
        template = objectMapper.readValue((String) input.get("body"), Template.class);
        PreProcess.PreProcessTemplate(template);
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("UPDATE template SET " +
                "accountID = ?, active = ?, globalRead = ?, globalResourceName = ?, name = ?," +
                "lookup = ?, type = ?, text = ?, extension = ?, contentType = ? WHERE id = ?");

        stmt.setString(1, template.getAccountId());
        stmt.setBoolean(2, template.getActive());
        stmt.setBoolean(3, template.getGlobalRead());
        stmt.setString(4, template.getGlobalResourceName());
        stmt.setString(5, template.getName());
        stmt.setString(6, template.getLookup());
        stmt.setString(7, template.getType());
        stmt.setString(8, template.getText());
        stmt.setString(9, template.getExtension());
        stmt.setString(10, template.getContentType());
        stmt.setInt(11, id);
        stmt.executeUpdate();

        conn.close();
        return "success";
    }

    public String delete(HashMap<String,Object> input) throws Exception {
        Integer id = (Integer) input.get("id");
        DBConn conn = new DBConn();
        PreparedStatement stmt2 = conn.makeConnection().prepareStatement( "DELETE FROM template WHERE id = ?");
        stmt2.setInt(1,id);
        stmt2.executeUpdate();

        conn.close();
        return "success";
    }

    public String getAll() throws Exception {
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

    public String getById(HashMap<String,Object> input) throws Exception {
        Integer id = (Integer) input.get("id");
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("SELECT * FROM template " +
                "WHERE id = ?");
        stmt.setInt(1, id);

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

    public Boolean checkExist(int idIn) throws Exception {
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
