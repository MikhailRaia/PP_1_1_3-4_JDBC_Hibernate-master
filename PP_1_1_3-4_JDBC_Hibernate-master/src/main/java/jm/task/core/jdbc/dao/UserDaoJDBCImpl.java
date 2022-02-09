package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public static final String USER_TABLE =
            " CREATE TABLE  Users ( " +
                    "id BIGINT(5) NOT NULL AUTO_INCREMENT , " +
                    "name  VARCHAR(255) , " +
                    "lastname VARCHAR(255) , " +
                    "age tinyint (5) NOT NULL ,  " +
                    "PRIMARY KEY( id )) ";

    public UserDaoJDBCImpl() {
        Util.setConnection();
    }

    public void createUsersTable() {
        try {
            Util.statement.executeUpdate(USER_TABLE);
            Util.statement.close();
            System.out.println("Таблица Users создана");
        } catch (SQLException ignored) {
        }
    }

    public void dropUsersTable() {
        try {
            Util.statement.executeUpdate("DROP TABLE User");
            Util.statement.close();
            System.out.println("Таблица Users удалена");
        } catch (SQLException ignore) {

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement prSt;
        String insert = "INSERT INTO Users ( name , lastname , age ) Values(?,?,?)";
        try {
            prSt = Util.connection.prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, lastName);
            prSt.setByte(3, age);
            prSt.executeUpdate();//мб execute
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        List <User> userList = new ArrayList<>();
        try {
            ResultSet resultSet = Util.statement.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                userList.add(new User(resultSet.getString("name"), resultSet.getString("lastname"),resultSet.getByte("age") ));
            }
        } catch (SQLException ignore){
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            Util.statement.executeUpdate("TRUNCATE Users");
            System.out.println("Таблица Users очищена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
