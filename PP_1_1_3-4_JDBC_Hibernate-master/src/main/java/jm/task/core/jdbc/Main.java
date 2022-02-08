package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main  {
    // реализуйте алгоритм здесь

    public static void main(String[] args)  {
        Util.setConnection();
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.saveUser("andrei", "petrov",(byte)22);
        userDaoJDBC.saveUser("vasya", "smirnov",(byte)25);
        userDaoJDBC.saveUser("leha", "bobrov",(byte)27);

    }

}

