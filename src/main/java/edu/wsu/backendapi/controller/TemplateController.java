package edu.wsu.backendapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.dao.TemplateDao;
import edu.wsu.backendapi.model.Template;
import edu.wsu.backendapi.security.PreProcess;
import edu.wsu.backendapi.service.SiteflowService;
import static edu.wsu.backendapi.service.SiteflowService.printInfo;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.json.JSONObject;
import org.apache.http.HttpResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/template")
public class TemplateController {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object templateGetAll() {
        SiteflowService tempServ = new SiteflowService();
        try {
            HttpResponse output = tempServ.getAllTemplates();
            return printInfo(output,true);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }


        JSONObject obj = new JSONObject();
        obj.put("status", 400);
        return obj.toString(4);
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

        JSONObject obj = new JSONObject();
        obj.put("status", 400);
        return obj.toString(4);
    }

    @GET
    @Path("/rds/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Object templateGetById(@QueryParam("id") int id) {
        TemplateDao tempGetRds = new TemplateDao();
        try {
            return tempGetRds.getTemplateByIdRds(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject();
        obj.put("id",id);
        obj.put("Error Message","Not Found");
        return obj.toString(4);
    }

    @DELETE
    @Path("/rds/delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response templateDeleteById(@QueryParam("id") int id) {
        int retVal = 0;
        TemplateDao tempDeleteRds = new TemplateDao();
        try {
            retVal = tempDeleteRds.deleteTemplateByIdRds(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (retVal == 1) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @POST
    @Path("/rds/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String templatePostDb(String jsonIn) {
        JSONObject jsonRet = new JSONObject(jsonIn);
        System.out.println(jsonRet.toString(4));
        TemplateDao addTempDao = new TemplateDao();
        try {
            addTempDao.addTemplate(jsonRet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "received";
    }

    @POST
    @Path("/rds/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String templateUpdateDb(String jsonIn, @QueryParam("id") int idIn) {
        JSONObject jsonRet = new JSONObject(jsonIn);
        System.out.println(jsonRet.toString(4));

        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Template templateRdsUpdate = new Template();
        try {
            templateRdsUpdate = objectMapper.readValue(jsonIn, Template.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        PreProcess preprocessInput = new PreProcess();
        int isGood = preprocessInput.PreProcessTemplate(templateRdsUpdate);
        System.out.println("isGood: " + isGood);


        /*
        TemplateDao addTempDao = new TemplateDao();
        try {
            addTempDao.updateTemplate(jsonRet, idIn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
        return "received";
    }
}
