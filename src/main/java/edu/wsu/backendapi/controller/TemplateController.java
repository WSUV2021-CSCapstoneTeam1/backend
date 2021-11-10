package edu.wsu.backendapi.controller;

// © Copyright 2016 HP Development Company, L.P.
// SPDX-License-Identifier: MIT

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import edu.wsu.backendapi.siteflow.SiteFlow;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/template")
public class TemplateController {

    @GET
    @Path("/get/all")
    @Produces("text/plain")
    public String templateGetAll() {
        return "Hello, World!";
    }
}
