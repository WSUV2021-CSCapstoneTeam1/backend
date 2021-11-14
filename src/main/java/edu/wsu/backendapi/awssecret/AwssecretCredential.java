package edu.wsu.backendapi.awssecret;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;

import java.util.Base64;

public class AwssecretCredential {
// https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-samples.html#prerequisites

    public static String getSecret(String passSecret) {

        String input;

        if (passSecret.equals("SFkey")) {
            input = System.getenv("AWS_SECRET_SITEFLOW_KEY_SECRETNAME");
        } else if (passSecret.equals("SFsecret")) {
            input = System.getenv("AWS_SECRET_SITEFLOW_SECRET_SECRETNAME");
        } else if (passSecret.equals("RDSHostName")) {
            input = System.getenv("AWS_SECRET_RDS_HOSTNAME_SECRETNAME");
        } else if (passSecret.equals("RDSPassword")) {
            input = System.getenv("AWS_SECRET_RDS_PASSWORD_SECRETNAME");
        } else {
            input = "FAIL";
            return input;
        }

        String secretName = input;
        String region = System.getenv("AWS_SECRET_SITEFLOW_REGION");

        // Create a Secrets Manager client
        AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
                .withRegion(region)
                .build();

        String secret, decodedBinarySecret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = null;

        try {
            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
        } catch (DecryptionFailureException | InternalServiceErrorException | InvalidParameterException | InvalidRequestException | ResourceNotFoundException e) {
            throw e;
        }

        // Decrypts secret using the associated KMS CMK.
        // Depending on whether the secret is a string or binary, one of these fields will be populated.
        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
            return secret;
        }
        else {
            decodedBinarySecret = new String(Base64.getDecoder().decode(getSecretValueResult.getSecretBinary()).array());
            return decodedBinarySecret;
        }

        // Your code goes here.
    }
}
