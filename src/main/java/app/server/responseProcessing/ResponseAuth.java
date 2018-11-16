package app.server.responseProcessing;

import com.fasterxml.jackson.core.*;

import java.io.IOException;

public class ResponseAuth {

    public static String resp(String respFromServer) {
        int respCode = Integer.parseInt(respFromServer.split(" ", 2)[0]);
        String respMSG = respFromServer.split(" ", 2)[1];
        if (respCode != 200)
            if (respCode == 403 && respMSG.equals("Login or password incorrect")) {
                return "Неверное имя пользователя/пароль";
            } else if (respCode == 403 && respMSG.equals("Incorrect password")) {
                return "Неверный пароль";
            }
        return "OK";
    }

    public static String getToken(String response) throws IOException {

        JsonFactory factory = new JsonFactory();
        JsonParser parser  = factory.createParser(response);

        while(!parser.isClosed()){
            JsonToken jsonToken = parser.nextToken();
            if(jsonToken.VALUE_STRING.equals(jsonToken)) {
//                System.out.println("Token: " + parser.getValueAsString());
                return parser.getValueAsString();
            }
        }
        return null;
    }
}
