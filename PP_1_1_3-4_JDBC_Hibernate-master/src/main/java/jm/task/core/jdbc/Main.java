package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main  {
    // реализуйте алгоритм здесь

    public static void main(String[] args) throws SQLException {

        //JDBC
//        UserDao user = new UserDaoJDBCImpl();
//        UserService userService = new UserServiceImpl();
//        user.createUsersTable();
//        user.saveUser("andrei", "petrov",(byte)22);
//        user.saveUser("vasya", "smirnov",(byte)25);
//        user.saveUser("leha", "bobrov",(byte)27);
//        System.out.println(user.getAllUsers());
//        user.dropUsersTable();

        // Hibernate
//        userService.createUsersTable();
//        userService.saveUser("andrei", "petrov",(byte)22);
//        userService.saveUser("vasya", "smirnov",(byte)25);
//        userService.saveUser("leha", "bobrov",(byte)27);
//        userService.dropUsersTable();

        UserDao userHib = new UserDaoHibernateImpl();
//        userHib.createUsersTable();

        userHib.saveUser("andrey", "petrov", (byte)20);
//        userHib.dropUsersTable();
    }

}

