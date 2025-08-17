package net.simcra.simple_database_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

import net.simcra.simple_database_app.query.Query;

public class Main {
    private static final String CREATE_EMPLOYEES_SQL = """
            CREATE TABLE IF NOT EXISTS employees (
                id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                contact_name VARCHAR NOT NULL,
                contact_number VARCHAR NOT NULL,
                address VARCHAR NOT NULL,
                city VARCHAR NOT NULL,
                post_code INTEGER NOT NULL,
                hire_date DATE NOT NULL,
                department VARCHAR NOT NULL
            );""";

    private static final String CLEAR_EMPLOYEES_SQL = """
            DELETE FROM employees;
            DELETE FROM SQLITE_SEQUENCE WHERE name='employees';""";

    private static final String INSERT_EMPLOYEES_SQL = """
            INSERT INTO employees (contact_name, contact_number, address, city, post_code, hire_date, department)
            VALUES ('Colton Garnet Dennell', '(02) 9264 4755', '201 Sussex St', 'Sydney', 2000, '2024-10-11', 'Finance'),
            ('Nikkole Theodora Batts', '(02) 9365 9000', '1 Notts Ave', 'Sydney', 2026, '2024-11-07', 'Finance'),
            ('Selby Elroy Rake', '(02) 9265 6888', '500 George St', 'Sydney', 2000, '2024-11-26', 'Finance'),
            ('Michelle Kristi Henson', '(03) 9840 2200', '888 Doncaster Rd', 'Melbourne', 3108, '2025-01-09', 'Human Resources'),
            ('Ruby Daphne Robbins', '(03) 9642 1136', '115 Hardware St', 'Melbourne', 3000, '2025-02-24', 'Human Resources'),
            ('Callan Raine Fitzroy', '(02) 9587 3749', '648A Forest Rd', 'Sydney', 2207, '2025-04-18', 'Service'),
            ('Brigham Lily-Rose Raine', '(03) 5945 2888', '4 Olympic Way', 'Melbourne', 3810, '2024-09-23', 'Service'),
            ('Troy Moses Hardwick', '(07) 3219 4118', '2/1420 Logan Rd', 'Brisbane', 4122, '2025-01-14', 'Service'),
            ('Patricia Kassie Trask', '(07) 3857 1787', '2/256 Junction Rd', 'Brisbane', 4011, '2024-05-21', 'Service'),
            ('Jerrold Sukie Ibbott', '0421 230 933', '1/55 Chelmsford Rd', 'Sydney', 2145, '2025-08-17', 'Service'),
            ('Rufus Josh Chandler', '(02) 9251 4044', '19 Kent St', 'Sydney', 2000, '2025-05-12', 'Service'),
            ('Linwood Merrilyn Sandford', '(02) 9557 3888', '1/12-14 Enmore Rd', 'Sydney', 2042, '2025-01-23', 'Service'),
            ('Aspen Marilla Willis', '(03) 9696 4025', '252 Clarendon St', 'Melbourne', 3205, '2024-02-14', 'Service'),
            ('Stormy Samson Kimberley', '(07) 4632 5125', '515 Ruthven St', 'Toowoomba', 4350, '2023-02-15', 'Customer Support'),
            ('Dena Nigella Royle', '(02) 9267 1614', '127 York St', 'Sydney', 2000, '2024-05-30', 'Customer Support');""";

    private static final String SELECT_EMPLOYEES_SQL = """
            SELECT * FROM employees;""";

    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(1);
            statement.executeUpdate(CREATE_EMPLOYEES_SQL);
            statement.executeUpdate(CLEAR_EMPLOYEES_SQL);
            statement.executeUpdate(INSERT_EMPLOYEES_SQL);

            Query query = new Query(connection, SELECT_EMPLOYEES_SQL, Collections.emptyList());
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                System.out.println(String.format(
                        "id=%s, contact_name=%s, contact_number=%s, address=%s, city=%s, post_code=%s, hire_date=%s, department=%s",
                        resultSet.getInt("id"),
                        resultSet.getString("contact_name"),
                        resultSet.getString("contact_number"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getInt("post_code"),
                        resultSet.getString("hire_date"),
                        resultSet.getString("department")));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
