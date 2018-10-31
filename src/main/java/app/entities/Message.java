package app.entities;

import java.util.Date;

public class Message {
    private String fromUserName;
    private String toUserName;
    private String content;
    private Date date;

    public Message(){

    }

    public Message(String content){
        this.content = content;

    }

    public String getContent() {
        return content;
    }
}
