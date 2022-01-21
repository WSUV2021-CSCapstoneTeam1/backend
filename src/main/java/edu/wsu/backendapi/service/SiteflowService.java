package edu.wsu.backendapi.service;

import edu.wsu.backendapi.siteflow.GetSFCredentials;
import edu.wsu.backendapi.siteflow.SiteFlow;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SiteflowService {

    public SiteflowService() {}

    public HttpResponse getAllTemplates() throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        SiteFlow siteFlow = getSiteFlow();

        //printInfo(siteFlow.GetAllTemplates(), true);
        HttpResponse info = siteFlow.GetAllTemplates();
        return info;
    }

    public HttpResponse getAllSkus() throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        SiteFlow siteFlow = getSiteFlow();

        HttpResponse info = siteFlow.GetSkus();
        return info;
    }

    public HttpResponse postSku(String sku) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        SiteFlow siteFlow = getSiteFlow();

        HttpResponse info = siteFlow.PostSku(sku);
        return info;
    }

    public HttpResponse getAllProducts() throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        SiteFlow siteFlow = getSiteFlow();

        HttpResponse info = siteFlow.GetProducts();
        return info;
    }

    private SiteFlow getSiteFlow() {
        GetSFCredentials sfCreds = new GetSFCredentials();
        String[] cred = sfCreds.getSiteFlowCredentials();
        String key = cred[0];
        String secret = cred[1];
        String algorithm = cred[2];

        return new SiteFlow(key, secret, algorithm);
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
}