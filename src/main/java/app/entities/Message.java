package app.entities;

import java.util.Date;

public class Message {
    private User sender;
    private User receiver;
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
