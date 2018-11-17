package app.entities;

import app.model.Room;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="message")
public class Message implements Serializable{
    @Id
    @GeneratedValue
    @GenericGenerator(name = "generator", strategy = "identity")
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="room_id")
    private Room room;

    @Column(name="creation_time")
    private Date creationTime;

    @Column(name="content")
    private String content;

    public Message(){

    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public Room getRoom(){
        return room;
    }

    public void setCreationTime(Date creationTime){
        this.creationTime = creationTime;
    }

    public Date getCreationTime(){
        return creationTime;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
