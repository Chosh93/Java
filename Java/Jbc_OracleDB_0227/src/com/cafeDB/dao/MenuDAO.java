package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.MenuVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    public List<MenuVO> menuSelect() {
        List<MenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU ORDER BY MENU_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int me_id = rs.getInt("MENU_ID");
                String me_name = rs.getString("MENU_NAME");
                int me_price = rs.getInt("PRICE");
                String ca_name = rs.getString("CATEGORY_NAME");
                MenuVO vo = new MenuVO(me_id, me_name, me_price, ca_name);
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
    public void menuInsertDelete() {
        System.out.println("[1]메뉴 추가    [2]메뉴 삭제");
        int sel = sc.nextInt();
        if (sel == 1) {
            //메뉴 번호는 max+1
            System.out.print("메뉴 이름 :");
            String me_name = sc.next();
            System.out.print("메뉴 가격 :");
            int me_price = sc.nextInt();
            System.out.print("메뉴 분류 :");
            String ca_name = sc.next();
            try {
                conn = CafeCommon.getConnection();
                stmt = conn.createStatement();
                String sql = "INSERT INTO CAFE_MENU(MENU_ID, MENU_NAME, PRICE, CATEGORY_NAME) VALUES((SELECT NVL(MAX(MENU_ID),0)+1 FROM CAFE_MENU), '"+me_name+"', "+me_price+", '"+ca_name+"')";
                rs = stmt.executeQuery(sql);
                CafeCommon.close(rs);
                CafeCommon.close(stmt);
                CafeCommon.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (sel == 2) {
            System.out.print("메뉴 이름 :");
            String me_name = sc.next();
            try {
                conn = CafeCommon.getConnection();
                stmt = conn.createStatement();
                String sql = "DELETE FROM CAFE_MENU WHERE MENU_ID = "+me_name;
                rs = stmt.executeQuery(sql);
                CafeCommon.close(rs);
                CafeCommon.close(stmt);
                CafeCommon.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
