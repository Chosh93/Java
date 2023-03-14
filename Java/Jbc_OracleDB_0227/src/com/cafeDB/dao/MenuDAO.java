package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.MenuVO;
import com.cafeDB.vo.OrderVO;
import com.cafeDB.vo.SalesInfoVO;
import com.cafeDB.vo.FavoriteMenuVO;

import java.sql.Connection;
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
    com.cafeDB.dao.FavoriteMenuDAO favoriteMenuDAO = new com.cafeDB.dao.FavoriteMenuDAO();
    com.cafeDB.dao.SalesInfoDAO salesInfoDAO = new com.cafeDB.dao.SalesInfoDAO();
    OrderDAO orderdao = new OrderDAO();
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
    public List<MenuVO> coffeeSelect(){
        List<MenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU WHERE CATEGORY_NAME = 'COFFEE' ORDER BY MENU_ID";
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
    public void coffeeSelectPrint(List<MenuVO> list) {
        for (MenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuId());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
    public List<MenuVO> adeSelect(){
        List<MenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU WHERE CATEGORY_NAME = 'ADE' ORDER BY MENU_ID";
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
    public void adeSelectPrint(List<MenuVO> list) {
        for (MenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuId());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
    public List<MenuVO> dessertSelect(){
        List<MenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU WHERE CATEGORY_NAME = 'DESSERT' ORDER BY MENU_ID";
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
    public void dessertSelectPrint(List<MenuVO> list) {
        for (MenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuId());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }

    public void menuBasket(){
        System.out.print(" 메뉴 선택 : ");
        String me_name = sc.next();
        System.out.print("[1]메뉴 담기 [2]취소");

    }
    public void menuInsertDelete() {
        System.out.println("[1]메뉴 추가    [2]메뉴 삭제    [3]EXIT");
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
                String sql = "INSERT INTO CAFE_MENU(MENU_ID, MENU_NAME, PRICE, CATEGORY_NAME) VALUES((SELECT NVL(MAX(MENU_ID),0)+1 FROM CAFE_MENU), '" + me_name + "', " + me_price + ", '" + ca_name + "')";
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
                String sql = "DELETE FROM CAFE_MENU WHERE MENU_NAME = " + "'" + me_name + "'";
                rs = stmt.executeQuery(sql);
                CafeCommon.close(rs);
                CafeCommon.close(stmt);
                CafeCommon.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (sel == 3) return;
    }
    public void menuSalesInfo() {
        System.out.println("[1]일일 매출, [2]월별 매출, [3]메뉴별 판매순위, [4]주문내역");
        int sel = sc.nextInt();
        if (sel == 1) {
            System.out.println("[[일일 매출 조회]]");
            List<SalesInfoVO> salesInfoVO = salesInfoDAO.dailySalesSelect();
            salesInfoDAO.dailySalesSelectPrint(salesInfoVO);
        } else if (sel == 2) {
            System.out.println("[[월별 매출 조회]]");
            List<SalesInfoVO> salesInfoVO = salesInfoDAO.monthSalesSelect();
            salesInfoDAO.monthSalesSelectPrint(salesInfoVO);
        } else if (sel == 3) {
            try {
                conn = CafeCommon.getConnection();
                stmt = conn.createStatement();
                String sql1 = "DELETE FROM FAVORITE_MENU";
                rs = stmt.executeQuery(sql1);
                String sql2 = "INSERT INTO FAVORITE_MENU(MENU_NAME, MENU_COUNT) SELECT DISTINCT MENU_NAME, SUM(ORDER_QUANTITY) AS TOTAL_COUNT FROM CAFE_ORDER GROUP BY MENU_NAME ORDER BY SUM(ORDER_QUANTITY) DESC";
                rs = stmt.executeQuery(sql2);
                CafeCommon.close(rs);
                CafeCommon.close(stmt);
                CafeCommon.close(conn);
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("판매량 순위");
            List<FavoriteMenuVO> favoriteMenuVO = favoriteMenuDAO.favoriteMenuSelect();
            favoriteMenuDAO.favoriteMenuSelectPrint(favoriteMenuVO);
        } else if (sel == 4){
            System.out.println("[[주문 내역 확인]]");
            List<OrderVO> orderVO = orderdao.orderSelect();
            orderdao.orderSelectPrint(orderVO);
        }
    }
}