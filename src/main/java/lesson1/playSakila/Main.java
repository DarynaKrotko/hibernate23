package lesson1.playSakila;

import lesson1.entity.Actor;
import lesson1.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(City.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

//        Actor actor = new Actor("BELLA", "SMITT");
//        session.save(actor);

        City city1 = new City("Kherson", 100);
        session.save(city1);

//        City city = session.find(City.class, 1);
//        System.out.println(city);

        session.getTransaction().commit();
        session.createQuery("select c from City c where c.city = 'Kherson'", City.class)
                .getResultList()
                        .forEach(city -> System.out.println(city));

//        Actor actor1 = session.find(Actor.class, 1);
//        System.out.println(actor1);
//        session
//                .createQuery("select a from Actor a where a.firstName = 'BELA'", Actor.class)
//                        .getResultList()
//                                .forEach(actor -> System.out.println(actor));
//
//        City city = session.find(City.class, 1);
//        System.out.println(city);
        session.close();
        sessionFactory.close();
    }
}
