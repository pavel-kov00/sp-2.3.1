package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getall();
    public void addUser(User user);
    public User getUser(long id);
    public void deleteUser(long id);
    public void updateUser(User user,long id);


}
