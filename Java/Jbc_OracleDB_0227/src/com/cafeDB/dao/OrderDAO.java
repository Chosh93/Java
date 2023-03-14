package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.BasketVO;
import com.cafeDB.vo.MenuVO;
import com.cafeDB.vo.OrderVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    BasketDAO basketdao = new BasketDAO();

    public void order() {
        System.out.print("[1]주문 [2]취소 : ");
        int sel = sc.nextInt();
        if (sel == 1) {
            try {
                conn = CafeCommon.getConnection();
                stmt = conn.createStatement();
                String sql = "INSERT INTO CAFE_ORDER(ORDER_ID, ORDER_DATE, MENU_NAME, MENU_PRICE, OPTION_TYPE, OPTION_PRICE, ORDER_QUANTITY, TOTAL_PRICE) SELECT BASKET_SEQ.NEXTVAL, SYSDATE, B.MENU_NAME, B.MENU_PRICE, B.OPTION_TYPE, B.EXTRA_COST, B.MENU_QUANTITY, (B.MENU_PRICE+B.EXTRA_COST)*B.MENU_QUANTITY FROM BASKET B";
                rs = stmt.executeQuery(sql);
                CafeCommon.close(rs);
                CafeCommon.close(stmt);
                CafeCommon.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
            basketdao.totalDelete();
        } else if (sel == 2) return;
        System.out.println("결제가 완료되었습니다. 감사합니다^^");
    }
    public List<OrderVO> orderSelect() {
        List<OrderVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_ORDER ORDER BY ORDER_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int me_id = rs.getInt("ORDER_ID");
                String or_date = rs.getString("ORDER_DATE");
                String me_name = rs.getString("MENU_NAME");
                int me_price = rs.getInt("MENU_PRICE");
                String op_name = rs.getString("OPTION_TYPE");
                int op_price = rs.getInt("OPTION_PRICE");
                int cnt = rs.getInt("ORDER_QUANTITY");
                int total_price = rs.getInt("TOTAL_PRICE");
                OrderVO vo = new OrderVO(me_id, or_date, me_name, me_price, op_name, op_price, cnt, total_price);
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

    public void orderSelectPrint(List<OrderVO> list) {
        for (OrderVO e : list) {
            System.out.println("주문번호 : " + e.getOrderId());
            System.out.println("주문날짜 : " + e.getOrderDate());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("옵션이름 : " + e.getOpName());
            System.out.println("옵션가격 : " + e.getOpPrice());
            System.out.println("주문수량 : " + e.getOrderQuantity());
            System.out.println("총 금액 : " + e.getTotalPrice());
            System.out.println("-----------------------------");
        }
    }
    public void orderDelete() {
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "DROP SEQUENCE BASKET_SEQ";
            rs = stmt.executeQuery(sql);
            String sql2 = "CREATE SEQUENCE BASKET_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 9999 NOCYCLE NOCACHE";
            rs = stmt.executeQuery(sql2);
            String sql3 = "DELETE FROM CAFE_ORDER";
            rs = stmt.executeQuery(sql3);
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}