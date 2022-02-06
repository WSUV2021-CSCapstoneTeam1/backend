package edu.wsu.backendapi.siteflow;

import edu.wsu.backendapi.awssecret.AwssecretCredential;
import org.json.JSONObject;

public class GetSFCredentials {
    AwssecretCredential awsCred = new AwssecretCredential();

    //Access Credentials
    //private static String key = System.getenv("SITEFLOW_KEY");
    //private static String secret = System.getenv("SITEFLOW_SECRET");
    private static String algorithm = "HmacSHA1";

    public GetSFCredentials() {
    }

    public String[] getSiteFlowCredentials(String organization) throws Exception {
        //Get SiteFlow Key from AWS Secrets
        String awsSFKey = awsCred.getSecret("SFkey", organization);
        JSONObject secretSFKeyObj = new JSONObject(awsSFKey);
        String key = secretSFKeyObj.getString("SF_KEY");

        //Get SiteFlow Secret from AWS Secrets
        String awsSFSecret = awsCred.getSecret("SFsecret", organization);
        JSONObject secretsSFSecretObj = new JSONObject(awsSFSecret);
        String secret = secretsSFSecretObj.getString("SF_SECRET");

        String[] creds = {key,secret,algorithm};
        return creds;
    }
}
