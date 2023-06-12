package com.example.wifi.service;

import com.example.wifi.test.step2.DataBaseConnection;

import java.net.URL;
import java.sql.*;

public class SqliteConnection {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnect() {

        // SQLite 데이터베이스 파일에 연결
        URL resource = DataBaseConnection.class.getClassLoader().getResource("db/wifi_db.sqlite");

        final String dbPath = resource.getFile();

        // SQLite connection string
        String url = "jdbc:sqlite:" + dbPath;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    protected void close(ResultSet rs, PreparedStatement preparedStatement, Connection connection) {

        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}