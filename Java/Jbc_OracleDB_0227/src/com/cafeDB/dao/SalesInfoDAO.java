package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.SalesInfoVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesInfoDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    public List<SalesInfoVO> dailySalesSelect() {
        List<SalesInfoVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql0 = "DELETE FROM DAILY_SALES";
            rs = stmt.executeQuery(sql0);
            String sql1 = "INSERT INTO DAILY_SALES SELECT DISTINCT ORDER_DATE, SUM(ORDER_QUANTITY) AS TOTAL_COUNT, SUM(TOTAL_PRICE) AS SALES FROM CAFE_ORDER GROUP BY ORDER_DATE";
            rs = stmt.executeQuery(sql1);
            String sql2 = "SELECT * FROM DAILY_SALES ORDER BY ORDER_DATE";
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                String or_date = rs.getString("ORDER_DATE");
                int to_cnt = rs.getInt("TOTAL_COUNT");
                int sales = rs.getInt("SALES");
                SalesInfoVO vo = new SalesInfoVO(or_date, to_cnt, sales);
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
    public void dailySalesSelectPrint(List<SalesInfoVO> list) {
        for (SalesInfoVO e : list) {
            System.out.println("날짜 : " + e.getOrderDate());
            System.out.println("판매 수량 : " + e.getTotoalCount());
            System.out.println("판매 총액 : " + e.getSales());
            System.out.println("-----------------------------");
        }
    }
    public List<SalesInfoVO> monthSalesSelect() {
        List<SalesInfoVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT TO_CHAR(SYSDATE, 'YYYY/MM') AS MONTH, SUM(ORDER_QUANTITY) AS TOTAL_COUNT, SUM(TOTAL_PRICE) AS SALES FROM CAFE_ORDER";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String or_date = rs.getString("MONTH");
                int to_cnt = rs.getInt("TOTAL_COUNT");
                int sales = rs.getInt("SALES");
                SalesInfoVO vo = new SalesInfoVO(or_date, to_cnt, sales);
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
    public void monthSalesSelectPrint(List<SalesInfoVO> list) {
        for (SalesInfoVO e : list) {
            System.out.println("날짜 : " + e.getOrderDate());
            System.out.println("판매 수량 : " + e.getTotoalCount());
            System.out.println("판매 총액 : " + e.getSales());
            System.out.println("-----------------------------");
        }
    }
}