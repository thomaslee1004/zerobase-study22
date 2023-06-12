package com.example.wifi.test.step1;

public class ApiTest {

    /**
     * 1. Open API 테스트
     */
    public static void main(String[] args) {

        String result = OpenApi.get(1, 10);
        System.out.println(result);

    }




}
