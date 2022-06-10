package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final UserServiceImpl userService = new UserServiceImpl();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Petrov", (byte) 21));
        users.add(new User("Sergey", "Ivanov", (byte) 34));
        users.add(new User("Petr", "Sidorov", (byte) 45));
        users.add(new User("Victor", "Lavrov", (byte) 56));

        userService.createUsersTable();
        users.forEach(el -> userService.saveUser(el.getName(), el.getLastName(), el.getAge()));
        //User tempUser = users.get(1);
        //userService.saveUser(tempUser.getName(), tempUser.getLastName(), tempUser.getAge());
        List<User> usersFromTable =  userService.getAllUsers();
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
        userService.closeConnection();
    }
}
