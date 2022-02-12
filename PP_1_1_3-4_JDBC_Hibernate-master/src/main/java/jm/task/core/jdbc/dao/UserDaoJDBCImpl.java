package jm.task.core.jdbc.dao;

import com.mysql.cj.Query;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
        Util.setConnection();
    }

    public void createUsersTable() {
        try {
            Statement statement;
            statement = Util.connection.createStatement();
            statement.executeUpdate(" CREATE TABLE  Users ( " +
                    "id BIGINT(5) NOT NULL AUTO_INCREMENT , " +
                    "name  VARCHAR(255) , " +
                    "lastname VARCHAR(255) , " +
                    "age tinyint (5) NOT NULL ,  " +
                    "PRIMARY KEY( id )) ");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement;
            statement = Util.connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS Users");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement prSt;
            prSt = Util.connection.prepareStatement("INSERT INTO Users ( name , lastname , age ) Values(?,?,?)");
            prSt.setString(1, name);
            prSt.setString(2, lastName);
            prSt.setByte(3, age);
            prSt.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement;
            statement = Util.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                userList.add(new User(resultSet.getString("name"), resultSet.getString("lastname"), resultSet.getByte("age")));
            }
        } catch (SQLException ignore) {
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            Statement statement;
            statement = Util.connection.createStatement();
            statement.executeUpdate("TRUNCATE Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
