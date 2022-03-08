package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.exceptions.BadRequestException;
import org.json.JSONObject;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Controller implements ControllerInterface {

    @Override
    public Response makeRequest(String methodName, Object service, HashMap<String, Object> input, int successfulStatusCode, HttpHeaders headers) throws NoSuchMethodException {
        Method method;
        Response response;

        if (input != null) {
            method = service.getClass().getMethod(methodName, input.getClass(), HttpHeaders.class);
        } else {
            method = service.getClass().getMethod(methodName, HttpHeaders.class);
        }
        try {
            String output;
            if (input == null) {
                output = (String) method.invoke(service, headers);
            } else {
                output = (String) method.invoke(service, input, headers);
            }
            return returnResponse(output, successfulStatusCode);
        } catch (InvocationTargetException e) {
            Throwable throwable = e.getCause();
            e.printStackTrace();
            if (throwable instanceof BadRequestException) {
                BadRequestException bre = (BadRequestException) throwable;
                response = returnResponse(bre.getMessage(), bre.getStatusCode());
            } else {
                response = Response.status(400).build();
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response = Response.status(400).build();
            return response;
        }
    }

    private Response returnResponse(String output, int status) {
        return Response.status(status).entity(output).type(MediaType.APPLICATION_JSON).build();
    }
}
