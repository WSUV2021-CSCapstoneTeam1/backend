package edu.wsu.backendapi.siteflow;

public class GetCredentials {
    //Access Credentials
    private static String key = System.getenv("SITEFLOW_KEY");
    private static String secret = System.getenv("SITEFLOW_SECRET");
    private static String algorithm = "HmacSHA1";

    public GetCredentials() {
    }

    public String[] getSiteFlowCredentials() {
        String[] creds = {key,secret,algorithm};
        return creds;
    }
}
