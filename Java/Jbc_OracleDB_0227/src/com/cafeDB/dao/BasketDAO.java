package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.BasketVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasketDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<BasketVO> basketSelect() {
        List<BasketVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM BASKET";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String me_name = rs.getString("MENU_NAME");
                int me_price = rs.getInt("MENU_PRICE");
                String op_name = rs.getString("OPTION_TYPE");
                int op_price = rs.getInt("EXTRA_COST");
                int me_qtt = rs.getInt("MENU_QUANTITY");
                int total = rs.getInt("TOTAL_PRICE");
                BasketVO vo = new BasketVO(me_name, me_price, op_name, op_price, me_qtt, total);
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

    public void basketSelectPrint(List<BasketVO> list) {
        for (BasketVO e : list) {
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuprice());
            System.out.println("메뉴옵션 : " + e.getOptionName());
            System.out.println("옵션가격 : " + e.getOpPrice());
            System.out.println("메뉴수량 : " + e.getMenuCnt());
            System.out.println("총 금액 : " + e.getTotalPrice());
            System.out.println("-----------------------------");
        }
    }
    public void basketMenuContain() {
        System.out.println("[1]담기   [2]EXIT");
        int sel = sc.nextInt();
        if (sel == 1) {
            System.out.println("[장바구니에 담을 메뉴]");
            System.out.print("메뉴 이름 : ");
            String me_name = sc.next();
            sc.nextLine();
            System.out.print("선택할 옵션 [1]샷 추가 [2]선택안함 : ");
            int op_sel = sc.nextInt();
            String op_name = "";
            if(op_sel == 1) op_name = "샷 추가";
            else op_name = "선택안함";
            System.out.print("메뉴 수량 : ");
            int me_cnt = sc.nextInt();
            try {
                conn = CafeCommon.getConnection();
                stmt = conn.createStatement();
                String sql = "INSERT INTO BASKET SELECT M.MENU_ID, M.MENU_NAME, M.PRICE, O.OPTION_TYPE, O.EXTRA_COST, " + me_cnt + ", (M.PRICE+O.EXTRA_COST)*" + me_cnt + " AS TOTAL_PRICE FROM CAFE_MENU M JOIN CAFE_OPTION O ON 1=1 WHERE M.MENU_NAME = '" + me_name + "' AND O.OPTION_TYPE = '" + op_name + "'";
                rs = stmt.executeQuery(sql);
                CafeCommon.close(rs);
                CafeCommon.close(stmt);
                CafeCommon.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void totalDelete() {
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql1 = "DELETE FROM BASKET";
            rs = stmt.executeQuery(sql1);
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}