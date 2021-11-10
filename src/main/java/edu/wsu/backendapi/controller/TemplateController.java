package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.service.TemplateService;
import static edu.wsu.backendapi.service.TemplateService.printInfo;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.http.HttpResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/template")
public class TemplateController {

    @GET
    @Path("/get/all")
    @Produces("text/plain")
    public String templateGetAll() {
        TemplateService tempServ = new TemplateService();
        try {
            HttpResponse output = tempServ.conn();
            return printInfo(output, true);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "failed to return";
    }
}
