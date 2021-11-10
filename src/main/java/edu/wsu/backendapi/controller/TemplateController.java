package edu.wsu.backendapi.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/template")
public class TemplateController {
    @GET
    @Path("/get/all")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}
