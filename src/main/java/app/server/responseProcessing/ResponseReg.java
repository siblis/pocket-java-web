package app.server.responseProcessing;

public class ResponseReg {
    public static String resp(String respFromServer) {
        int respCode = Integer.parseInt(respFromServer.split(" ", 2)[0]);
        String respMSG = respFromServer.split(" ", 2)[1];
        if (respCode == 201) return "OK";
        else if (respCode == 409 && respMSG.equals("Conflict")) {
            return "Данный e-mail уже зарегистрирован";
        } else if (respCode == 400 && respMSG.equals("Bad JSON")) {
            return "Неверный запрос";
        } else if (respCode == 400 && respMSG.equals("Bad JSON, need email")) {
            return "Необходимо ввести e-mail";
        }
        return null;
    }
}
