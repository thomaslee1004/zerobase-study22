package com.example.wifi.controller;

import com.example.wifi.service.WifiService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

@WebServlet(name = "loadWifi", value = "/loadWifi")
public class LoadWifiController extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        WifiService wifiService = new WifiService();
        int totalCount = 0;
        try {
            totalCount = wifiService.add();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/load-wifi.jsp");
        request.setAttribute("totalCount", totalCount);

        rd.forward(request, response);
    }

    public void destroy() {
    }
}
