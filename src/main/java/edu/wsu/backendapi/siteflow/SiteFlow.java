package edu.wsu.backendapi.siteflow;
// © Copyright 2016 HP Development Company, L.P.
// SPDX-License-Identifier: MIT

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SiteFlow {
    public SiteFlow() {
        System.out.println("Bad");
    }

    //Access Credentials
    private static String baseUrl = "https://pro-api.oneflowcloud.com";
    //private static String baseUrl = "https://printos.api.hp.com/siteflow"; //use for account on production server
    //private static String baseUrl = "https://stage.printos.api.hp.com/siteflow"; //use for account on staging server

    private static HmacAuth auth;

    public SiteFlow(String key, String secret, String algorithm) {
        auth = new HmacAuth(key, secret, algorithm);
    }

    /**
     * Gets a list of all orders in Site Flow
     *
     * @return HttpResponse of the GET request
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public HttpResponse GetAllOrders() throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String path = "/api/order";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + path);

        addHeaders(request, "GET", path);

        System.out.println("Getting all orders");
        return client.execute(request);
    }

    public HttpResponse GetOrder(String id) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String path = "/api/order/details/";
        path = path + id;
        //System.out.println("path sent to siteflow: " + path);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + path);

        addHeaders(request, "GET", path);

        System.out.println("Getting order");
        return client.execute(request);
    }

    public HttpResponse PostOrder(String order) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String path = "/api/order";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(baseUrl + path);

        addHeaders(request, "POST", path);
        request.setEntity(new StringEntity(order, "UTF-8"));

        System.out.println("Submitting Order");
        return client.execute(request);
    }

    /**
     * Gets a list of all templates in Site Flow
     *
     * @return HttpResponse of the GET request
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public HttpResponse GetAllTemplates() throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String path = "/api/template";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + path);

        addHeaders(request, "GET", path);

        System.out.println("Getting all templates");
        return client.execute(request);
    }


    /**
     * Gets a list of skus in Site Flow.
     *
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public HttpResponse GetSkus() throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String path = "/api/sku";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + path);

        addHeaders(request, "GET", path);

        System.out.println("Getting Skus");
        return client.execute(request);
    }

    /**
     * Gets a list of products in Site Flow.
     *
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public HttpResponse GetProducts() throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String path = "/api/product";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + path);

        addHeaders(request, "GET", path);

        System.out.println("Getting Products");
        return client.execute(request);
    }

    /**
     * Submits an order into Site Flow
     *
     * @param sku - order to submit
     * @return HttpResponse of the POST request
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public HttpResponse PostSku(String sku) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String path = "/api/sku";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(baseUrl + path);

        addHeaders(request, "POST", path);
        request.setEntity(new StringEntity(sku, "UTF-8"));

        System.out.println("Submitting SKU");
        return client.execute(request);
    }

    /**
     * Adds the headers to an HttpRequest
     *
     * @param request - request to add the headers to
     * @param method - type of request (GET, POST, PUT)
     * @param path - the path the request is sent to (doesn't include baseUrl)
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    public void addHeaders(HttpRequest request, String method, String path) throws InvalidKeyException, NoSuchAlgorithmException {
        request.addHeader("Content-Type", "application/json");
        request.addHeader("x-hp-hmac-authentication", auth.getHmacAuthentication(method, path));
        request.addHeader("x-hp-hmac-date", auth.getTimestamp());
    }

}
