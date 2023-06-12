package com.example.wifi.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "main", value = "")
public class MainController extends HttpServlet {
    public void init() {

        // TODO: 날짜 비교 로직 필요

//        WifiService wifiService = new WifiService();
//        try {
//            wifiService.add();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

        rd.forward(request, response);
    }

    public void destroy() {
    }
}
