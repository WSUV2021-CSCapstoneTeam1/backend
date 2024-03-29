package edu.wsu.backendapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wsu.backendapi.exceptions.BadRequestException;
import edu.wsu.backendapi.model.Sku;
import edu.wsu.backendapi.siteflow.GetSFCredentials;
import edu.wsu.backendapi.siteflow.SiteFlow;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class SiteflowService {

    public SiteflowService() {}

    public String getAllTemplates(HttpHeaders headers) throws Exception {
        SiteFlow siteFlow = getSiteFlow(getOrganization(headers));
        HttpResponse info = siteFlow.GetAllTemplates();
        if (info.getStatusLine().getStatusCode() != 200) {
            throw new BadRequestException(printInfo(info, true), info.getStatusLine().getStatusCode());
        }
        return printInfo(info,true);
    }

    public String getAllSkus(HttpHeaders headers) throws Exception {
        SiteFlow siteFlow = getSiteFlow(getOrganization(headers));
        HttpResponse info = siteFlow.GetSkus();
        if (info.getStatusLine().getStatusCode() != 200) {
            throw new BadRequestException(printInfo(info, true), info.getStatusLine().getStatusCode());
        }
        return printInfo(info,true);
    }

    public String postSku(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String sku = objectMapper.writeValueAsString(input.get("body"));
        SiteFlow siteFlow = getSiteFlow(getOrganization(headers));
        HttpResponse info = siteFlow.PostSku(sku);
        if (info.getStatusLine().getStatusCode() != 200) {
            throw new BadRequestException(printInfo(info, true), info.getStatusLine().getStatusCode());
        }
        return printInfo(info,true);
    }

    public String getAllProducts(HttpHeaders headers) throws Exception {
        SiteFlow siteFlow = getSiteFlow(getOrganization(headers));
        HttpResponse info = siteFlow.GetProducts();
        if (info.getStatusLine().getStatusCode() != 200) {
            throw new BadRequestException(printInfo(info, true), info.getStatusLine().getStatusCode());
        }
        return printInfo(info,true);
    }

    public String getAllOrders(HttpHeaders headers) throws Exception {
        SiteFlow siteFlow = getSiteFlow(getOrganization(headers));
        HttpResponse info = siteFlow.GetAllOrders();
        if (info.getStatusLine().getStatusCode() != 200) {
            throw new BadRequestException(printInfo(info, true), info.getStatusLine().getStatusCode());
        }
        return printInfo(info,true);
    }

    public String getOrder(HashMap<String, Object> input, HttpHeaders headers) throws Exception {
        SiteFlow siteFlow = getSiteFlow(getOrganization(headers));
        HttpResponse info = siteFlow.GetOrder(String.valueOf(input.get("id")));
        if (info.getStatusLine().getStatusCode() != 200) {
            throw new BadRequestException(printInfo(info, true), info.getStatusLine().getStatusCode());
        }
        return printInfo(info,true);
    }

    public String postOrder(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String order = objectMapper.writeValueAsString(input.get("body"));
        SiteFlow siteFlow = getSiteFlow(getOrganization(headers));
        HttpResponse info = siteFlow.PostOrder(order);
        if (info.getStatusLine().getStatusCode() != 201) {
            throw new BadRequestException(printInfo(info, true), info.getStatusLine().getStatusCode());
        }
        return printInfo(info,true);
    }

    private SiteFlow getSiteFlow(String organization) throws Exception {
        GetSFCredentials sfCreds = new GetSFCredentials();
        String[] cred = sfCreds.getSiteFlowCredentials(organization);
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

    private String getOrganization(HttpHeaders headers) throws IndexOutOfBoundsException {
        return headers.getRequestHeader("siteflow-organization").get(0);
    }
}