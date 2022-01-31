package edu.wsu.backendapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.model.Sku;
import edu.wsu.backendapi.security.PreProcess;
import edu.wsu.backendapi.service.SiteflowService;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

            if (output.getStatusLine().getStatusCode() == 200) {
                return returnBody(output);
            }

            return returnMessage(output.getStatusLine().getStatusCode(), output.getStatusLine().getReasonPhrase());
//            return Response.ok(printInfo(output,true)).build();
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return Response.status(400,"Error").build();
        }
    }

    @POST
    @Path("/siteflow/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response skuPostSiteflow(String jsonIn) {
        ObjectMapper objectMapper = new ObjectMapper();

        Sku skuSiteFlowPost;
        try {
            skuSiteFlowPost = objectMapper.readValue(jsonIn, Sku.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.status(400,"JSON Mapping Error").build();
        }

        PreProcess preprocessInput = new PreProcess();

        if (preprocessInput.PreProcessSku(skuSiteFlowPost)) {
            SiteflowService tempServ = new SiteflowService();
            try {
                HttpResponse output = tempServ.postSku(jsonIn);

                if (output.getStatusLine().getStatusCode() == 200) {
                    return returnBody(output);
                }

                return returnMessage(output.getStatusLine().getStatusCode(), output.getStatusLine().getReasonPhrase());
//                return Response.ok(printInfo(output, true)).build();
            } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
                e.printStackTrace();
                return Response.status(400, "Error").build();
            }
        } else {
            return Response.status(400,"Preprocessing Error").build();
        }
    }

    private Response returnMessage(int statusCode, String statusPhrase) {
        return Response.status(statusCode, statusPhrase).build();
    }

    private Response returnBody(HttpResponse output) throws IOException {
        return Response.ok(printInfo(output,true)).build();
    }
}
