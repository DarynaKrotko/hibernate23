import entity.Car;
import entity.DriveLicense;
import entity.Owner;
import entity.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(DriveLicense.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Car car = new Car("audi", Type.LIGHT, 23, 20000, 2022);
        Car car1 = new Car("mazda", Type.LIGHT, 23, 20000, 2022);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        DriveLicense driveLicense = new DriveLicense("asd2234");

        Owner owner = new Owner("vasya", cars, driveLicense);
        session.save(owner);
        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }
}
