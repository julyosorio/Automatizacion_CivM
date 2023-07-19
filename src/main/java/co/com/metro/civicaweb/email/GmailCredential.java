package co.com.metro.civicaweb.email;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import  co.com.metro.civicaweb.email.*;

import java.io.*;

public class GmailCredential {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_FILE_PATH = "src/main/resources/gmailToken.properties";

    public static TokenResponse refreshAccessToken() throws IOException{

        final String REFRESH_TOKEN = getRefreshToken();
        final String CLIENT_ID = getClientId();
        final String CLIENT_SECRET = getClientSecret();

        return new GoogleRefreshTokenRequest(
                new NetHttpTransport(),
                JSON_FACTORY,
                REFRESH_TOKEN,
                CLIENT_ID,
                CLIENT_SECRET
        ).execute();

    }

    private static String getRefreshToken(){
        return new ConfigFileReader(TOKENS_FILE_PATH).getPropertyByKey("refreshToken");
    }

    private static String getClientId(){
        return new ConfigFileReader(TOKENS_FILE_PATH).getPropertyByKey("clientId");
    }

    private static String getClientSecret(){
        return new ConfigFileReader(TOKENS_FILE_PATH).getPropertyByKey("clientSecret");
    }

}

