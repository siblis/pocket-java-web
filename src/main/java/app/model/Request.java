package app.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="request")
public class Request implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="room_id")
    private int roomId;

    public Request(){}

    public Request(int userId, int roomId){
        this.userId = userId;
        this.roomId = roomId;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getUserId(){
        return userId;
    }

    public void setRoomId(int roomId){
        this.roomId = roomId;
    }

    public int getRoomId(){
        return roomId;
    }
}
