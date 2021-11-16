package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.TemplateService;
import static edu.wsu.backendapi.service.TemplateService.printInfo;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONObject;
import org.apache.http.HttpResponse;

import javax.ws.rs.*;

@Path("/template")
public class TemplateController {

    @GET
    @Path("/get/all")
    @Produces("application/json")
    public Object templateGetAll() {
        TemplateService tempServ = new TemplateService();
        try {
            HttpResponse output = tempServ.conn();
            return printInfo(output,true);
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        return "failed to return";
    }

    @POST
    @Path("post/db")
    @Consumes("text/plain")
    @Produces("text/plain")
    public String templatePostDb(String tempJson) {
        JSONObject tempJsonRet = new JSONObject(tempJson);
        System.out.println(tempJsonRet);
        return "received";
    }
}
