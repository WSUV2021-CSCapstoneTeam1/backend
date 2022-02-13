package edu.wsu.backendapi.controller;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Controller implements ControllerInterface {

    @Override
    public Response makeRequest(String methodName, Object service, HashMap<String, Object> input, int successfulStatusCode, HttpHeaders headers) throws NoSuchMethodException, IllegalAccessException {
        Method method;

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
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }

    private Response returnResponse(String output, int status) {
        return Response.status(status).entity(output).type(MediaType.APPLICATION_JSON).build();
    }
}
