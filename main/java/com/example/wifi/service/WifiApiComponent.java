package com.example.wifi.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WifiApiComponent {

    /**
     * OpenAPI를 통해서 와이파이 정보의 JSON문자열을 리턴함
     */
    public JsonObject getWipiInfoList(int startPageIndex, int endPageIndex) {

        String request = "";

        try {
            String url = String.format("http://openapi.seoul.go.kr:8088/7073676c4a7361743131375672575259/json/TbPublicWifiInfo/%s/%s/",
                    startPageIndex,
                    endPageIndex
            );

            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
            BufferedReader rd;

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            request = sb.toString();

        } catch (Exception e) {
            System.out.println("openApi error" + e.getMessage());
        }

        JsonObject json = (JsonObject) JsonParser.parseString(request.toString());

        return json;
    }

}
