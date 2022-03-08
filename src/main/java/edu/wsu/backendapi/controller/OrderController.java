package edu.wsu.backendapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.exceptions.BadRequestException;
import edu.wsu.backendapi.model.Order;
import edu.wsu.backendapi.model.Sku;
import edu.wsu.backendapi.security.PreProcess;
import edu.wsu.backendapi.service.RdsService;
import edu.wsu.backendapi.service.SiteflowService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("order")
public class OrderController extends Controller {

    @GET
    @Path("/siteflow/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(@Context HttpHeaders headers) throws NoSuchMethodException, IllegalAccessException {
        SiteflowService siteflowService = new SiteflowService();
        return makeRequest("getAllOrders", siteflowService, null, 200, headers);
    }


    @GET
    @Path("/siteflow/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@Context HttpHeaders headers, @QueryParam("id") String id) throws NoSuchMethodException, IllegalAccessException {
        HashMap<String,Object> input = new HashMap<>();
        SiteflowService siteflowService = new SiteflowService();
        input.put("id", id);
        System.out.println(id);
        System.out.println(headers.toString());
        return makeRequest("getOrder", siteflowService, input, 200, headers);
    }


    @POST
    @Path("/siteflow/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postOrder(@Context HttpHeaders headers, String body) throws JsonProcessingException, NoSuchMethodException {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(body, Order.class);
        order.setDestinationName(headers.getHeaderString("siteflow-organization"));
        //PreProcess.PreProcessSku(sku);
        SiteflowService siteflowService = new SiteflowService();
        HashMap<String,Object> input = new HashMap<>();
        input.put("body", order);
        return makeRequest("postOrder", siteflowService, input, 201, headers);
    }


}
