package lesson1;

import lesson1.entity.Gender;
import lesson1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
//        User user = new User("vasya");
//        session.save(user);
//        System.out.println(user);

//        User user = session.find(User.class, 1L);
//        session.remove(user);

//        User user = session.find(User.class, 2L);
//        user.setName("kokos");
//        session.update(user);

        List <String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("js");
        skills.add("html");

        User user = new User("max", skills, Gender.MALE);
        session.save(user);
        session.getTransaction().commit();

//        System.out.println(user);

//        Query<User> query = session.createQuery("select u from User u where u.id > 2 ", User.class);
//        List<User> resultList = query.getResultList();
//        List<User> users = session
//                .createQuery("select u from User u where u.id > 2 ", User.class)
//                .getResultList();
//        System.out.println(users);
        session
                .createQuery("select u from User u", User.class)
                .getResultList()
                .forEach(user1-> System.out.println(user1));


        session.close();
        sessionFactory.close();
    }
}
