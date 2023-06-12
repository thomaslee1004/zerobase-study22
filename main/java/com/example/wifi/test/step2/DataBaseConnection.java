package com.example.wifi.test.step2;
import com.example.wifi.service.SqliteConnection;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection extends SqliteConnection {

    /**
     * 데이터 베이스 연결 테스트
     * sqlite에서 현재 시간을 가져오는 쿼리를 실행해 본다.
     * select date(), time();
     */
    public static void test() {
        Connection con = null;

        try {
            // SQLite JDBC 체크
            Class.forName("org.sqlite.JDBC");

            // SQLite 데이터베이스 파일에 연결
            URL resource = DataBaseConnection.class.getClassLoader().getResource("db/wifi_db.sqlite");
            String dbFile = resource.getFile();
            con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            // SQL 수행
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT date() as date, time() as time");
            while(rs.next()) {
                String date = rs.getString("date");
                String time = rs.getString("time");
                System.out.println(date + "	" + time);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(con != null) {
                try {con.close();}catch(Exception e) {}
            }
        }

    }

}
