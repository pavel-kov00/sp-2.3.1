package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getall() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User us) {
//        User user = getUser(id);
//        user.setName(us.getName());
//        user.setLastname(us.getLastname());
//        user.setAge(us.getAge());
//        user.setEmail(us.getEmail());
//        user.setRole(us.getRole());
//        user.setGender(us.getGender());
        entityManager.merge(us);
    }
}
