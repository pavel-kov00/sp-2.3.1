package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
//
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getall() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User us, long id) {
        User user = getUser(id);
        user.setName(us.getName());
        user.setLastname(us.getLastname());
        user.setAge(us.getAge());
        user.setEmail(us.getEmail());
        user.setRole(us.getRole());
        user.setGender(us.getGender());
        entityManager.persist(user);
//        entityManager.persist(us);
//        если только вызываю merge(без создания пользователя ) entityManager.merge(us) - то не обновляет,
//        добавляет новую запись
//        бьюсь уже с эти битую неделю
//        пишет
//        Hibernate: select next_val as id_val from hibernate_sequence for update
//        Hibernate: update hibernate_sequence set next_val= ? where next_val=?
    }
}
