package interfaces;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryHibernate
{

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();

        } catch (Throwable e)
        {
           throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() throws ExceptionInInitializerError
    {
        return sessionFactory;
    }

}
