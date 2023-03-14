package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public int login() {
        System.out.print("아이디 : ");
        String cafeId = sc.next();
        System.out.print("비밀번호 : ");
        String cafePw = sc.next();

        try {
            String sql = "SELECT * FROM CAFE_CUSTOMER WHERE CUSTOM_NAME = '" + cafeId + "'" + "AND CUSTOM_PHONE = '"+cafePw+"'";
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (rs.getInt("CUSTOM_ID") == 1) {
                    System.out.println("사장 로그인 성공");
                    return 1;
                }
                else {
                    System.out.println("손님 로그인 성공");
                    return 2;
                }
            }
            System.out.println("0");
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-2");
        return -2;
    }
}