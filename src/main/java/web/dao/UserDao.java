package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getall();
    public void addUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);
    public void updateUser(User user);


}
