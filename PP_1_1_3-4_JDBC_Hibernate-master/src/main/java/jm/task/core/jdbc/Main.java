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
//        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("andrei", "petrov",(byte)22);
//        userService.saveUser("vasya", "smirnov",(byte)25);
//        userService.saveUser("leha", "bobrov",(byte)27);
//        System.out.println(userService.getAllUsers());
//        userService.dropUsersTable();

        // Hibernate
        UserDao userHib = new UserDaoHibernateImpl();
//        userHib.createUsersTable();
//        userHib.saveUser("andrei", "petrov",(byte)22);
//        userHib.saveUser("vasya", "smirnov",(byte)25);
//        userHib.saveUser("leha", "bobrov",(byte)27);
//        System.out.println(userHib.getAllUsers());
//        userHib.cleanUsersTable();
//        userHib.dropUsersTable();
        userHib.removeUserById(2);
    }

}

