package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    final private static String dbURL = "jdbc:mysql://localhost/db_pp_1_1?useSSL=false";
    final private static String dbURLJdbc = "jdbc:mysql://localhost/db_pp_1_1";
    final private static String driver = "com.mysql.cj.jdbc.Driver";
    final private static String user = "root";
    final private static String password = "**";  // password deleted 5****75*..

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws HibernateException {
        if (sessionFactory == null) {
            Configuration configuration = setConfiguration();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            sessionFactory = setConfiguration()
                    .buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
    private static Configuration setConfiguration() {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, driver);
        settings.put(Environment.URL, dbURL);
        settings.put(Environment.USER, user);
        settings.put(Environment.PASS, password);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);
        return  configuration;
    }

    public static Connection getJDBCConnection() throws SQLException {
        return DriverManager.getConnection(dbURLJdbc, user, password);
    }

}
