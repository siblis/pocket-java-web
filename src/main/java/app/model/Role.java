package app.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="role")
public class Role implements Serializable{
    public static final String GUEST = "ROLE_GUEST";
    public static final String USER = "ROLE_USER";
    public static final String ADMIN = "ROLE_ADMIN";
    @Id
    @GeneratedValue
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="code")
    private String code;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    private List<User> users;

    public Role(int id, String code){
        this.id = id;
        this.code = code;
    }

    public Role(){

    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setCode(String login){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

//    public void setUsers(List<User> users){
//        this.users = users;
//    }
//
//    public List<User> getUsers(){
//        return users;
//    }
}
