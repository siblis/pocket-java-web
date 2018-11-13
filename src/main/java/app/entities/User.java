package app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.*;

public class User {

    private String name;
    private String password;
    private String email;
    private int id;
    public static User me;

    public String toJSON() throws JsonProcessingException {

        UserSerializer serializer = new UserSerializer(User.class);
        ObjectMapper om = new ObjectMapper();
        SimpleModule module = new SimpleModule("UserSerializer", new Version(2, 1, 3, null, null, null));
        module.addSerializer(User.class, serializer);
        om.registerModule(module);
        return om.writeValueAsString(me);

    }

    @JsonIgnore
    public List<User> contacts = new ArrayList<>();

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name){
        this.name = name;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj) return true;
//        if(obj == null || getClass() != obj.getClass()) return false;
//
//        User user = (User) obj;
//
//        if(name != null ? !name.equals(user.name) : user.name != null) return false;
//        return password != null ? password.equals(user.password) : user.password == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null? name.hashCode() : 0;
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        return result;
//    }
}
