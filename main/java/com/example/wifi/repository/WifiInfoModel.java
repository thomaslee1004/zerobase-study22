package com.example.wifi.repository;


import com.example.wifi.dto.WifiInfoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WifiInfoModel {


    public WifiInfoModel() {

    }


    public static void save(WifiInfoDto wifiInfoDto) throws SQLException {

        Connection con = new DataBaseConnection().init();

        String sql = "INSERT INTO WIFI_INFO (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM) " +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, wifiInfoDto.getX_SWIFI_MGR_NO());
            pstmt.setString(2, wifiInfoDto.getX_SWIFI_WRDOFC());
            pstmt.setString(3, wifiInfoDto.getX_SWIFI_MAIN_NM());
            pstmt.setString(4, wifiInfoDto.getX_SWIFI_ADRES1());
            pstmt.setString(5, wifiInfoDto.getX_SWIFI_ADRES2());
            pstmt.setString(6, wifiInfoDto.getX_SWIFI_INSTL_FLOOR());
            pstmt.setString(7, wifiInfoDto.getX_SWIFI_INSTL_TY());
            pstmt.setString(8, wifiInfoDto.getX_SWIFI_INSTL_MBY());
            pstmt.setString(9, wifiInfoDto.getX_SWIFI_SVC_SE());
            pstmt.setString(10, wifiInfoDto.getX_SWIFI_CMCWR());
            pstmt.setString(11, wifiInfoDto.getX_SWIFI_CNSTC_YEAR());
            pstmt.setString(12, wifiInfoDto.getX_SWIFI_INOUT_DOOR());
            pstmt.setString(13, wifiInfoDto.getX_SWIFI_REMARS3());
            pstmt.setFloat(14, wifiInfoDto.getLAT());
            pstmt.setFloat(15, wifiInfoDto.getLNT());
            pstmt.setString(16, wifiInfoDto.getWORK_DTTM());
            pstmt.executeUpdate();
        } catch (SQLException e) {

        }

        return;
    }

}


