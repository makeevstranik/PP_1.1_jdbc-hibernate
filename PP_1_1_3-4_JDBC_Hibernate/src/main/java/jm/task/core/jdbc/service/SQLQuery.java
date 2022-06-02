package jm.task.core.jdbc.service;

public enum SQLQuery {
    CREATE_TABLE("""
            CREATE TABLE IF NOT EXISTS users (
            id BIGINT UNSIGNED AUTO_INCREMENT,
            name VARCHAR(20),
            last_name VARCHAR(20),
            age BIT(8),
            PRIMARY KEY(id),
            UNIQUE(id))
            """),
    DROP_TABLE("DROP TABLE IF EXISTS users"),
    CREATE_USER("INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)"),
    DELETE_USER("DELETE FROM users WHERE id = (?)"),
    GET_ALL_USERS("SELECT * FROM users"),
    CLEAN_TABLE("TRUNCATE TABLE users");
    private final String query;

    SQLQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
