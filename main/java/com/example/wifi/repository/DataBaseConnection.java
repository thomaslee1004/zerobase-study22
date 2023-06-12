package com.example.wifi.repository;

import com.example.wifi.service.SqliteConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection extends SqliteConnection {

    /**
     * 데이터 베이스 Connection 객체 생성
     * @return
     */
    public static Connection init() {
        Connection con = null;

        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            URL resource = com.example.wifi.test.step2.DataBaseConnection.class.getClassLoader().getResource("db/wifi_db.sqlite");
            String dbFile = resource.getFile();
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

        return con;

    }

}
