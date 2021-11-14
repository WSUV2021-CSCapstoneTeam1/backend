package edu.wsu.backendapi.dao;

import edu.wsu.backendapi.awssecret.AwssecretCredential;
import org.json.JSONObject;

public class GetDBCredentials {
    AwssecretCredential awsCred = new AwssecretCredential();

    public GetDBCredentials() {
    }

    public String[] getRDSCredentials() {
        //Get SiteFlow Key from AWS Secrets
        String awsRDSHostName = awsCred.getSecret("RDSHostName");
        JSONObject secretRDSHostNameObj = new JSONObject(awsRDSHostName);
        String hostName = secretRDSHostNameObj.getString("RDS_HOSTNAME");

        //Get SiteFlow Secret from AWS Secrets
        String awsRDSPassword = awsCred.getSecret("RDSPassword");
        JSONObject secretsRDSPasswordObj = new JSONObject(awsRDSPassword);
        String password = secretsRDSPasswordObj.getString("RDS_PASSWORD");

        String[] creds = {password,hostName};
        return creds;
    }
}
