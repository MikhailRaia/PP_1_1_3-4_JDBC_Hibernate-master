package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();


    @Override
    public void createUsersTable() throws SQLException {
        Util.setConnection();
        userDaoJDBC.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        Util.setConnection();
        userDaoJDBC.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Util.setConnection();
        userDaoJDBC.saveUser( name, lastName,age);
    }

    @Override
    public void removeUserById(long id) {
        Util.setConnection();

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        Util.setConnection();
        return userDaoJDBC.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        Util.setConnection();
        userDaoJDBC.cleanUsersTable();
    }
}
