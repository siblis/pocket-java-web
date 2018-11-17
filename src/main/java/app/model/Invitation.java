package app.model;

import app.entities.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="invitation")
public class Invitation implements Serializable{
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

    public Invitation(){

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
}
