package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.MenuVO;
import com.cafeDB.vo.UserVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    public List<UserVO> userSelect() {
        List<UserVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_CUSTOMER ORDER BY CUSTOMER_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int cs_id = rs.getInt("CUSTOMER_ID");
                String cs_name = rs.getString("CUSTOMER_NAME");
                String cs_phone = rs.getString("CUSTOMER_PHONE");
                int cs_mil = rs.getInt("CUSTOMER_MIL");
                UserVO vo = new UserVO(cs_id, cs_name, cs_phone, cs_mil);
                list.add(vo);
            }
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void menuSelectPrint(List<MenuVO> list) {
        for (MenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuId());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
}
