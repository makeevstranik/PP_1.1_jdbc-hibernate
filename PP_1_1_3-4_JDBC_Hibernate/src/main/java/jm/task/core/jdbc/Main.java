package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceHiberImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Petrov", (byte) 21));
        users.add(new User("Sergey", "Ivanov", (byte) 34));
        users.add(new User("Petr", "Sidorov", (byte) 45));
        users.add(new User("Victor", "Lavrov", (byte) 56));

        final UserServiceHiberImpl userServiceHiber = new UserServiceHiberImpl();
        userServiceHiber.dropUsersTable();
        userServiceHiber.createUsersTable();
        users.forEach(el -> userServiceHiber.saveUser(el.getName(), el.getLastName(), el.getAge()));

        ArrayList<User> users2 = (ArrayList<User>) userServiceHiber.getAllUsers();
        users2.forEach(System.out::println);

        userServiceHiber.removeUserById(1);
        userServiceHiber.cleanUsersTable();
        userServiceHiber.closeFactory();

    }

}
