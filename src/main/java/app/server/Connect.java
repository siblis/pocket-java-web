//written by Grigory, Artem, Ann

package app.server;

import app.responseProcessing.ResponseAuth;
import java.io.*;
import java.net.*;

public class Connect {
    private static final String SERVER_URL = "https://pocketmsg.ru:8888";
    public static final String AUTH_PATH = "/v1/auth/";
    public static final String USERS = "/v1/users/";
    public static final String CONTACTS = "/v1/users/contacts/";
    public static final String WEBSOCKET = "/v1/ws/";

    public static final String PUT = "PUT";
    public static final String POST = "POST";

    public static String connect(String jsonNamePassword, String requestMethod, String path) throws Exception {
        String token = null;
        URL url = new URL(SERVER_URL + path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestMethod);
        connection.setDoOutput(true);
        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
        stream.writeBytes(jsonNamePassword);
        stream.flush();
        stream.close();

        int responseCode = connection.getResponseCode();
        System.out.println("Отправлено " + connection.getRequestMethod() + "URL " + connection.getURL());
        System.out.println("Response code " + responseCode);
        System.out.println(connection.getResponseMessage());

        //аутентификация
        if (responseCode == 200) {
            StringBuilder response = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            token = ResponseAuth.getToken(response.toString());
            System.out.println("Token: " + token);
        }

        //здесь нужно добавить ветку if (responseCode == 201) для регистрации нового пользователя
        return (responseCode + " " + connection.getResponseMessage());
    }
}
