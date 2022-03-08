package edu.wsu.backendapi.exceptions;

import edu.wsu.backendapi.service.SiteflowService;
import org.apache.http.HttpResponse;

import java.io.IOException;

public class BadRequestException extends Exception {
    private String message;
    private int statusCode;

    public BadRequestException (String message, int statusCode) throws IOException {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() { return message; }
    public int getStatusCode() { return statusCode; }
}
