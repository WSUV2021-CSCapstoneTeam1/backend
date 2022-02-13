package edu.wsu.backendapi.controller;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.HashMap;

public interface ControllerInterface {
    Response makeRequest(String methodName, Object service, HashMap<String, Object> input, int successfulStatusCode, HttpHeaders headers) throws NoSuchMethodException, IllegalAccessException;
}
