package lk.ijse.scaleShop.util;

import lk.ijse.scaleShop.to.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration factoryConfiguration;

    private final SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build().getSessionFactoryBuilder().build();
    }

    public static SessionFactoryConfiguration getInstance(){
        return (null == factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfiguration()
                :factoryConfiguration;

    }

    public Session getSession(){
        //Creating the Service Strategy



        Session session = sessionFactory.openSession();
        return session;
    }
}
