package homework1;

import homework1.entity.Car;
import homework1.entity.Owner;
import homework1.entity.Type;
import homework1.entity.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Word.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)

                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

//        Word word1 = new Word("bag");
//        Word word2 = new Word("bad");
//        Word word3 = new Word("bed");
//
//        session.save(word1);
//        session.save(word2);
//        session.save(word3);

//        Car car = new Car("mazda", Type.LIGHT, 23, 200000, 2022);
//        Owner owner = new Owner("Petya", car);
////
//        session.save(owner);

        session.getTransaction().commit();

//        List<String> words = session.createQuery("select w.value from Word w").getResultList();
//        System.out.println(words);
        session.close();
        sessionFactory.close();
    }

}
