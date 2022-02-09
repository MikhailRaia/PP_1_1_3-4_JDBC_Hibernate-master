package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД

    // Для JDBC
    public static Statement statement;
    public static Connection connection;

    // Для Hibernate
    private static SessionFactory sessionFactory;


    // Создание подключения JDBC
    public static void setConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", "root", "Pupsiksu6ami!");
            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println("Не удалось запустить класс драйвер");
        }
    }

    // Создание подключения Hibernate
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
                properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mysqljava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow");
                properties.setProperty("hibernate.connection.username", "root");
                properties.setProperty("hibernate.connection.password", "Pupsiksu6ami!");
                properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                properties.setProperty("hibernate.show_sql", "true");
                properties.setProperty("hibernate.hbm2ddl.auto", "update");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Соединение с БД создано Hibernate");
            } catch (Exception e) {
                System.out.println("Проблема с созданием подключения");
                e.printStackTrace();
            }
        }
        return  sessionFactory;
    }
}

