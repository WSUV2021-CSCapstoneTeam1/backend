package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.RdsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/team")
public class TeamController extends Controller {

    @GET
    @Path("rds/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRds() throws NoSuchMethodException, IllegalAccessException {
        RdsService rdsService = new RdsService();
        return makeRequest("getAllTeams", rdsService, null, 200, null);
    }

}
