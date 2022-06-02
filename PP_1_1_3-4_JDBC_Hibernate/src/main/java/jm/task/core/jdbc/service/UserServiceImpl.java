package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    final UserDaoJDBCImpl daoJDBC = new UserDaoJDBCImpl();
    public void createUsersTable() {
        daoJDBC.createUsersTable();
        System.out.println("Table created - OK");
    }

    public void dropUsersTable() {
        daoJDBC.dropUsersTable();
        System.out.println("Table dropped - OK");
    }

    public void saveUser(String name, String lastName, byte age) {
        daoJDBC.saveUser(name, lastName, age);
        System.out.println("User with name " + name + " was add to database");
    }

    public void removeUserById(long id) {
        daoJDBC.removeUserById(id);
        System.out.println("User removed - OK");
    }

    public List<User> getAllUsers() {
        return daoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        daoJDBC.cleanUsersTable();
        System.out.println("Table cleaned - OK");
    }

    public void closeConnection() {
        daoJDBC.closeConnection();
    }
}
