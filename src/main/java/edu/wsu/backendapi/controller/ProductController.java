package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.SiteflowService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("product")
public class ProductController extends Controller {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts(@Context HttpHeaders headers) throws NoSuchMethodException, IllegalAccessException {
        SiteflowService siteflowService = new SiteflowService();
        return makeRequest("getAllProducts", siteflowService, null, 200, headers);
    }
}
