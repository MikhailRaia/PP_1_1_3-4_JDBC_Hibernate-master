package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {

    User user = new User();

    public UserDaoHibernateImpl() {
        Util.getSessionFactory();
    }

    @Override
    @Deprecated
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(
                    " CREATE TABLE  users_hiber2 ( " +
                    "id BIGINT(5) NOT NULL AUTO_INCREMENT , " +
                    "name  VARCHAR(255) , " +
                    "lastname VARCHAR(255) , " +
                    "age tinyint (5) NOT NULL ,  " +
                    "PRIMARY KEY( id )) ");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Создание таблицы прошло успешно");
        } catch (Exception e) {
            System.out.println("Не удалось создать таблицу");
            e.printStackTrace();
        }

    }

    @Override
    @Deprecated
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("DROP TABLE users_hiber2 ");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Удаление таблицы прошло успешно");
        } catch (Exception e) {
            System.out.println("Не удалось удалить таблицу");
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            transaction.commit();
            System.out.println("Пользователь с именем " + name + " добавлен в БД");
        } catch (Exception e) {
            System.out.println("Не получилось добавить пользователя");
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }

//    public void saveUserHib (User user) {
//        try (Session session = Util.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.save(user);
//            transaction.commit();
//            System.out.println("Пользователь с именем " + user.getName() + " добавлен в БД");
//        } catch (Exception e) {
//            System.out.println("Не получилось добавить пользователя");
//            e.printStackTrace();
//        }
//    }

}
