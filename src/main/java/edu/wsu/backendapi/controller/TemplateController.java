package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.dao.TemplateDao;
import edu.wsu.backendapi.service.TemplateService;
import static edu.wsu.backendapi.service.TemplateService.printInfo;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/template")
public class TemplateController {

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object templateGetAll() {
        TemplateService tempServ = new TemplateService();
        try {
            HttpResponse output = tempServ.conn();
            return printInfo(output,true);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        return "failed to return";
    }

    @GET
    @Path("/rds/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object templateGetAllRds() {
        TemplateDao tempGetRds = new TemplateDao();
        try {
            return tempGetRds.getTemplateAllRds();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        //JSONObject nope = new JSONObject();
        return "{status:400}";
    }

    @POST
    @Path("post/db")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String templatePostDb(String tempJson) {
        JSONObject tempJsonRet = new JSONObject(tempJson);
        System.out.println(tempJsonRet);
        return "received";
    }
}
