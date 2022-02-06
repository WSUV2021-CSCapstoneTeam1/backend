package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.NewSiteflowService;
import edu.wsu.backendapi.service.RdsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("/skuV2")
public class NewSkuController extends Controller {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSkus(@Context HttpHeaders headers) throws NoSuchMethodException, IllegalAccessException {
        NewSiteflowService siteflowService = new NewSiteflowService();
        return makeRequest("getAllSkus", siteflowService, null, 200, headers);
    }

    @POST
    @Path("/siteflow/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postSku(@Context HttpHeaders headers, String body) throws NoSuchMethodException, IllegalAccessException {
        RdsService rdsService = new RdsService();
        HashMap<String,Object> input = new HashMap<>();
        input.put("body", input);
        return makeRequest("postSku", rdsService, input, 201, headers);
    }
}
