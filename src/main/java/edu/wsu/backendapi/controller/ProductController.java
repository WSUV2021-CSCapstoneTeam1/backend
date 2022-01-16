package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.SiteflowService;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static edu.wsu.backendapi.service.SiteflowService.printInfo;

@Path("/product")
public class ProductController {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object productSiteFlowGetAll() {
        SiteflowService tempServ = new SiteflowService();
        try {
            HttpResponse output = tempServ.getAllProducts();
            return printInfo(output,true);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject();
        obj.put("status", 400);
        return obj.toString(4);
    }
}
