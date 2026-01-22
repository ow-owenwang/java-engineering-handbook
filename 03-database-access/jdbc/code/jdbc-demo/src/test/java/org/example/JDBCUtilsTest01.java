package org.example;

import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtilsTest01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(id + " " + username + " " + password);
        }

        JDBCUtils.release(resultSet, preparedStatement, connection);

    }
}
