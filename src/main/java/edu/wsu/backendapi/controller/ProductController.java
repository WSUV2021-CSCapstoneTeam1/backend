package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.SiteflowService;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        HttpResponse output;
        try {
            output = tempServ.getAllProducts();
//            return Response.ok(printInfo(output,true)).build();

            if (output.getStatusLine().getStatusCode() == 200) {
                return returnBody(output);
            }
            return returnMessage(output.getStatusLine().getStatusCode(), output.getStatusLine().getReasonPhrase());
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
//            return Response.status(400,"Error").build();
            return returnMessage(400, "Unknown Error");
        }
    }

    private Object returnMessage(int statusCode, String statusPhrase) {
        return Response.status(statusCode, statusPhrase).build();
    }

    private Object returnBody(HttpResponse output) throws IOException {
        return Response.ok(printInfo(output,true)).build();
    }
}
