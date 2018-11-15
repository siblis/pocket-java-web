//written by Grigory
//edited by Artem
package app.server;

import app.responseProcessing.ResponseAuth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connect {
    private static String serverURL = "https://pocketmsg.ru:8888";

    public static String authorization(String JsonNamePassword) throws Exception {
        String token = null;
        URL url = new URL(serverURL + "/v1/auth/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
        stream.writeBytes(JsonNamePassword);
        stream.flush();
        stream.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            DataInputStream inputStream = new DataInputStream(connection.getInputStream());
            token = ResponseAuth.getToken(inputStream.readLine());
        }
        return (responseCode + " " + connection.getResponseMessage());

    }

//    public Connect(String jsonNamePassword) {
//
//        try {
//            authorization(jsonNamePassword);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //  {
//    "account_name": username,
//      "email": email,
//      "password": password
//  }


}
