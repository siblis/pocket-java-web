package app.entities;

import app.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.GenericGenerator;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
public class User implements Serializable{
    public static User me;
    public Model contacts;
    @Id
    @GeneratedValue
    @GenericGenerator(name = "generator", strategy = "identity")
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="nickname")
    private String nickname;

    @Column(name="last_request")
    private Date lastRequest;

    @Column(name="last_message_id")
    private int lastReadMessage;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Room> rooms;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_link_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Role> roles;

    public User(){
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.lastRequest = lastRequest;
    }

    public User(String login, String password, String nickname, List<Role> roles){
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.roles = roles;
    }

    public User(String login, String password, String nickname){
        this.login = login;
        this.password = password;
        this.nickname = nickname;
    }

    public User(String name, String password){

    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }


    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getNickname(){
        return nickname;
    }

    public void setLastRequest(Date lastRequest){
        this.lastRequest = lastRequest;
    }

    public int getLastReadMessage(){
        return lastReadMessage;
    }

    public void setLastReadMessage(int lastReadMessage){
        this.lastReadMessage = lastReadMessage;
    }

    public Date getLastRequest(){
        return lastRequest;
    }

    public void setRooms(List<Room> rooms){
        this.rooms = rooms;
    }
    @JsonIgnore
    public List<Room> getRooms(){
        return rooms;
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
    }

    public List<Role> getRoles(){
        return roles;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

    public static <R> R getName(User user) {
        return null;
    }

    public void setName(String name) {
    }

    public String toJSON() {
        return null;
    }

    public String getName() {
        return null;
    }

    private class Room {
    }
}
