package edu.wsu.backendapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.model.Sku;
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

@Path("/sku")
public class SkuController extends Controller {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSkus(@Context HttpHeaders headers) throws NoSuchMethodException, IllegalAccessException {
        SiteflowService siteflowService = new SiteflowService();
        return makeRequest("getAllSkus", siteflowService, null, 200, headers);
    }

    @POST
    @Path("/siteflow/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postSku(@Context HttpHeaders headers, String body) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Sku sku = objectMapper.readValue(body, Sku.class);
        PreProcess.PreProcessSku(sku);
        SiteflowService siteflowService = new SiteflowService();
        HashMap<String,Object> input = new HashMap<>();
        input.put("body", sku);
        return makeRequest("postSku", siteflowService, input, 201, headers);
    }
}
