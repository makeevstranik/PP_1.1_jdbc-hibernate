package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    final private Connection connection;

    public Util() throws SQLException {
        String dbURL = "jdbc:mysql://localhost/db_pp_1_1";
        String user = "root";
        // PASSWORD WAS DELETED
        String password = "***";
        this.connection = DriverManager.getConnection(dbURL, user, password);
        System.out.println("Connection OK");
    }

    public Connection getConnection() {
        return connection;
    }
}
