package edu.wsu.backendapi.servlet;
// © Copyright 2016 HP Development Company, L.P.
// SPDX-License-Identifier: MIT

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import edu.wsu.backendapi.dao.TemplateDao;
import edu.wsu.backendapi.siteflow.GetSFCredentials;
import edu.wsu.backendapi.siteflow.SiteFlow;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "getTemplateAll", value = "/getTemplateAll")
public class TemplateServlet extends HttpServlet {

    //Access Credentials
//    private static String key = System.getenv("SITEFLOW_KEY");
//    private static String secret = System.getenv("SITEFLOW_SECRET");
//    private static String algorithm = "HmacSHA1";
//    private static SiteFlow siteFlow;

    public HttpResponse conn() throws IOException, InvalidKeyException, NoSuchAlgorithmException {

        GetSFCredentials sfCreds = new GetSFCredentials();
        String[] cred = sfCreds.getSiteFlowCredentials();
        String key = cred[0];
        String secret = cred[1];
        String algorithm = cred[2];

        SiteFlow siteFlow = new SiteFlow(key, secret, algorithm);
        //printInfo(siteFlow.GetAllTemplates(), true);
        HttpResponse info = siteFlow.GetAllTemplates();
        return info;
    }

    /**
     * Prints the body of a HttpResponse in a "pretty" format. Information printed is determined
     * on whether the body is expected to be JSON or regular format.
     *
     * @param response     - Response with information to output
     * @param JsonResponse - Determines if response entity is expected to have JSON output
     * @throws ParseException
     * @throws IOException
     */
    public static String printInfo(HttpResponse response, boolean JsonResponse) throws ParseException, IOException {
        System.out.println(response.getStatusLine().getStatusCode() + " : " + response.getStatusLine().getReasonPhrase());
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity, "UTF-8");
        if (JsonResponse) {
            JSONObject formatted = new JSONObject(body);
            System.out.print("RESPONSE: ");
            System.out.println(formatted.toString(4));
            return formatted.toString(4);
        } else {
            System.out.println(body);
            return body;
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        TemplateServlet tempCon = new TemplateServlet();
        try {
            HttpResponse output = tempCon.conn();
            PrintWriter out = response.getWriter();
            out.println(printInfo(output, true));
            TemplateDao doConn = new TemplateDao();
            System.out.println(doConn.addTemplate("I added this"));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
