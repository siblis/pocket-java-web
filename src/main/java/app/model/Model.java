package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance = new Model();

    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model(){
        model = new ArrayList<User>();
    }

    public void add(User user){
        model.add(user);
    }

    public List<String> list(){
        List<Object> list = new ArrayList<>();
        for (User user : model) {
            Object name = User.getName(user);
            list.add(name);
        }
//        List<String> list1 = (List<String>) list;
//        return list1;
        return null;
    }
}
