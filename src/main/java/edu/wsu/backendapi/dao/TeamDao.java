package edu.wsu.backendapi.dao;

import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class TeamDao {

    public String getAll() throws Exception {
        DBConn conn = new DBConn();

        PreparedStatement stmt = conn.makeConnection().prepareStatement("SELECT * FROM team");
        ResultSet resultSet = stmt.executeQuery();

        JSONObject retObj = new JSONObject();
        Collection<JSONObject> teamItems = new ArrayList<JSONObject>();
        retObj.put("pages", -1);
        int count = 0;

        while (resultSet.next()) {
            JSONObject itemObj = new JSONObject();
            itemObj.put("id", resultSet.getInt("team_rds_id"));
            itemObj.put("name", resultSet.getString("team_name"));

            teamItems.add(itemObj);
            count += 1;

            //System.out.println(itemObj.toString());
        }

        conn.close();
        retObj.put("data", teamItems);
        retObj.put("count", count);

        return retObj.toString(4);
    }
}
