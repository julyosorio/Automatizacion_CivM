package co.com.metro.civicaweb.email;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import  co.com.metro.civicaweb.email.*;

import java.io.IOException;

import java.security.GeneralSecurityException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InboxGmailAPI {

    private static final String APPLICATION_NAME = "civicaWebRQ261-2";
    private static final String EMAIL = "yulieth.osorio@sofka.com.co";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String USER = "me";
    private static final Logger LOGGER = Logger.getLogger(InboxGmailAPI.class.getName());

    public static String getLastEmailBody() {

        try {
            Gmail service = getGmailService();
            String lastMessageId = getLastMessageId(service);
            System.out.println(lastMessageId);
            Message message = service.users().messages().get(USER, lastMessageId).execute();
            return new String(message.getPayload().getParts().get(0).getBody().decodeData());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error obteniendo credenciales o id del ultimo correo recibido: ", e);
            return null;
        } catch (GeneralSecurityException e){
            LOGGER.log(Level.SEVERE, "Error obteniendo servicio de Gmail: ", e);
            return null;
        }

    }

    private static Credential getCredential() throws IOException {

        String accessToken = GmailCredential.refreshAccessToken().getAccessToken();

        return new Credential(BearerToken.authorizationHeaderAccessMethod())
                .setAccessToken(accessToken);
    }

    private static Gmail getGmailService() throws IOException, GeneralSecurityException {

            Credential credential = getCredential();

            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

            return new Gmail
                    .Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME).build();
    }

    private static String getLastMessageId(Gmail service) throws IOException {

        Gmail.Users.Messages.List request = service.users().messages().list(USER).setQ("from: " + EMAIL);

        ListMessagesResponse messagesResponse = request.execute();
        request.setPageToken(messagesResponse.getNextPageToken());

        return messagesResponse.getMessages().get(0).getId();

    }

    public static void main(String[] args){
        System.out.println(getLastEmailBody());
    }
}
