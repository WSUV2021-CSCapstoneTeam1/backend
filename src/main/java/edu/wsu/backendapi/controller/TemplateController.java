package edu.wsu.backendapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.model.Template;
import edu.wsu.backendapi.security.PreProcess;
import edu.wsu.backendapi.service.SiteflowService;
import edu.wsu.backendapi.service.RdsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("/template")
public class TemplateController extends Controller {

    @GET
    @Path("siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSiteflow(@Context HttpHeaders headers) throws NoSuchMethodException, IllegalAccessException {
        SiteflowService siteflowService = new SiteflowService();
        return makeRequest("getAllTemplates", siteflowService, null, 200, headers);
    }

    @POST
    @Path("rds/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postRds(String body) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("User Input:" + body);
        Template template = objectMapper.readValue(body, Template.class);
        PreProcess.PreProcessTemplate(template);
        HashMap<String,Object> input = new HashMap<>();
        input.put("body",template);
        RdsService rdsService = new RdsService();
        return makeRequest("postTemplate", rdsService, input, 201, null);
    }

    @GET
    @Path("rds/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRds() throws NoSuchMethodException, IllegalAccessException {
        RdsService rdsService = new RdsService();
        return makeRequest("getAllTemplates", rdsService, null, 200, null);
    }

    @GET
    @Path("rds/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@QueryParam("id") Integer id) throws NoSuchMethodException, IllegalAccessException {
        RdsService rdsService = new RdsService();
        HashMap<String,Object> input = new HashMap<>();
        input.put("id", id);
        return makeRequest("getTemplateById", rdsService, input, 200, null);
    }

    @DELETE
    @Path("rds/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("id") Integer id) throws NoSuchMethodException, IllegalAccessException {
        RdsService rdsService = new RdsService();
        HashMap<String,Object> input = new HashMap<>();
        input.put("id", id);
        return makeRequest("deleteTemplate", rdsService, input, 200, null);
    }

    @PUT
    @Path("rds/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("id") Integer id, String body) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Template template = objectMapper.readValue(body, Template.class);
        PreProcess.PreProcessTemplate(template);
        RdsService rdsService = new RdsService();
        HashMap<String,Object> input = new HashMap<>();
        input.put("id", id);
        input.put("body", template);
        return makeRequest("updateTemplateById", rdsService, input, 200,null);
    }
}