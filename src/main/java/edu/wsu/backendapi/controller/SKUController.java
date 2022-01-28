package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.SiteflowService;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static edu.wsu.backendapi.service.SiteflowService.printInfo;

@Path("/sku")
public class SKUController {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object skuSiteFlowGetAll() {
        SiteflowService tempServ = new SiteflowService();
        try {
            HttpResponse output = tempServ.getAllSkus();
            return printInfo(output,true);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject();
        obj.put("status", 400);
        return obj.toString(4);
    }

    @POST
    @Path("/siteflow/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String skuPostSiteflow(String jsonIn) {
        SiteflowService tempServ = new SiteflowService();
        try {
            HttpResponse output = tempServ.postSku(jsonIn);
            return printInfo(output,true);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject();
        obj.put("status", 400);
        return obj.toString(4);
    }
}
