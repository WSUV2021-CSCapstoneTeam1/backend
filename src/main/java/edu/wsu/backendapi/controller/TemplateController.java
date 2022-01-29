package edu.wsu.backendapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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

import org.apache.http.HttpResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/template")
public class TemplateController {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response templateGetAll() {
        SiteflowService tempServ = new SiteflowService();
        try {
            HttpResponse output = tempServ.getAllTemplates();
            return Response.ok(printInfo(output,true)).build();
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return Response.status(400,"Error").build();
        }
    }

    @GET
    @Path("/rds/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response templateGetAllRds() {
        TemplateDao tempGetRds = new TemplateDao();
        try {
            return Response.ok(tempGetRds.getTemplateAllRds().toString()).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(400,"SQL Error").build();
        }
    }

    @GET
    @Path("/rds/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response templateGetById(@QueryParam("id") int id) {
        TemplateDao tempGetRds = new TemplateDao();

        try {
            if (tempGetRds.checkExist(id)) {
                try {
                    return Response.ok(tempGetRds.getTemplateByIdRds(id).toString()).build();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return Response.status(400, "SQL Error").build();
                }
            } else {
                return Response.status(400, "Does Not Exist").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(400, "SQL Error").build();
        }
    }

    @DELETE
    @Path("/rds/delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response templateDeleteById(@QueryParam("id") int id) {
        TemplateDao tempDeleteRds = new TemplateDao();
        try {
            if (tempDeleteRds.checkExist(id)) {
                tempDeleteRds.deleteTemplateByIdRds(id);
                return Response.status(200, "Template Deleted Successfully").build();
            } else {
                return Response.status(400, "Template Not Deleted, No Content").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(400,"SQL Error").build();
        }
    }

    @POST
    @Path("/rds/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response templatePostDb(String jsonIn) {
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Template templateRdsUpdate;
        try {
            templateRdsUpdate = objectMapper.readValue(jsonIn, Template.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(400,"JSON Mapping Error").build();
        }

        PreProcess preprocessInput = new PreProcess();
        if (preprocessInput.PreProcessTemplate(templateRdsUpdate)) {
            TemplateDao addTempDao = new TemplateDao();
            try {
                return Response.ok(addTempDao.addTemplate(templateRdsUpdate).toString()).build();
            }catch (SQLException e) {
                e.printStackTrace();
                return Response.status(400,"SQL Error").build();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Response.status(400,"JSON Processing Error").build();
            }
        } else {
            return Response.status(400,"Preprocessing Error").build();
        }
    }

    @PUT
    @Path("/rds/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response templateUpdateDb(String jsonIn, @QueryParam("id") int idIn) {
        int retVal = 0;
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Template templateRdsUpdate;
        try {
            templateRdsUpdate = objectMapper.readValue(jsonIn, Template.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(400,"JSON Mapping Error").build();
        }

        PreProcess preprocessInput = new PreProcess();
        if (preprocessInput.PreProcessTemplate(templateRdsUpdate)) {
            TemplateDao updateTempDao = new TemplateDao();
            try {
                if (updateTempDao.checkExist(idIn)) {
                    updateTempDao.updateTemplate(templateRdsUpdate, idIn);
                    return Response.status(200, "Template Updated Successfully").build();
                } else {
                    return Response.status(400, "Template Update Unsuccessful, No Content Item").build();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return Response.status(400,"SQL Error").build();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Response.status(400,"JSON Processing Error").build();
            }

        } else {
            return Response.status(400,"Preprocessing Error").build();
        }
    }
}
