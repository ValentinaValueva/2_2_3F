package web.dao;


import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static int USERS_COUNT;
    private List<User> users;

    {
        users = new ArrayList<User>();
        users.add(new User(++USERS_COUNT, "Ivan", "Ivanov", "ivan@gmail.com"));
        users.add(new User(++USERS_COUNT, "Petr", "Petrov", "petr@gmail.com"));
        users.add(new User(++USERS_COUNT, "Sam", "Samov", "sam@gmail.com"));
        users.add(new User(++USERS_COUNT, "Alexandr", "Alexandrov", "alexandr@gmail.com"));
        users.add(new User(++USERS_COUNT, "Poman", "Pomanov", "pomanov@gmail.com"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {


        User userEx = users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
        return userEx;
    }

} //implements UserDao {

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public  UserDaoImp(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
//
//    @Override
//    @Transactional
//    @SuppressWarnings("unchecked")
//    public List<User> listUsers() {
//        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }
//
//
//}
