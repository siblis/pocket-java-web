//written by Grigory
package app.server;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connect {
    private static String serverURL = "https://pocketmsg.ru:8888";

    public static void authorization(String JsonNamePassword) throws Exception {
        URL url = new URL(serverURL + "/v1/auth/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
        stream.writeBytes(JsonNamePassword);
        stream.flush();
        stream.close();

        int responseCode = connection.getResponseCode();
        System.out.println("Отправлено " + connection.getRequestMethod() + "URL " + connection.getURL());
        System.out.println("Response code " + responseCode);
        System.out.println(connection.getResponseMessage());
    }

    public Connect(String jsonNamePassword) {

        try {
            authorization(jsonNamePassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  {
//    "account_name": username,
//      "email": email,
//      "password": password
//  }


}
