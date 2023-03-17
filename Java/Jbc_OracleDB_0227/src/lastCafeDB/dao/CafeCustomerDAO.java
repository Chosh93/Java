package lastCafeDB.dao;

import lastCafeDB.util.CafeCommon;
import lastCafeDB.vo.CafeBasketVO;
import lastCafeDB.vo.CafeCustomerVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeCustomerDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    public List<CafeCustomerVO> customerSelect() {
        List<CafeCustomerVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_CUSTOMER ORDER BY CUSTOMER_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int customerId = rs.getInt("CUSTOMER_ID");
                String customerName = rs.getString("CUSTOMER_NAME");
                String customerPhone = rs.getString("CUSTOMER_PHONE");
                int customerMil = rs.getInt("CUSTOMER_MIL");
                CafeCustomerVO vo = new CafeCustomerVO(customerId, customerName, customerPhone, customerMil);
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

    public void customerSelectPrint(List<CafeCustomerVO> list) {
        System.out.println("-----------------------------");
        System.out.println("[전체 고객 조회]");
        for (CafeCustomerVO e : list) {
            System.out.println("고객 번호 : " + e.getCustomerId());
            System.out.println("고객 이름 : " + e.getCustomerName());
            System.out.println("고객 연락처 : " + e.getCustomerPhone());
            System.out.println("고객 마일리지 : " + e.getCustomerMil());
            System.out.println("-----------------------------");
        }
    }

    public void customerMil(){
        System.out.println("[고객 정보 조회]");
        System.out.print("고객 이름 : ");
        String customerName = sc.next();
        System.out.println("-----------------");
        try{
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_CUSTOMER WHERE CUSTOMER_NAME = '" + customerName + "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println("고객 번호 : " + rs.getInt(1) + "\n고객 이름 : " + rs.getString(2) + "\n고객 마일리지 : " + rs.getInt(4));
                System.out.println("-----------------");
            }
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("["+customerName+"님의 주문내역 조회]");
        System.out.println("--------------------------------------");
        try{
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT ORDER_DATE, ORDER_NAME, ORDER_PRICE, OPTION_NAME, OPTION_PRICE, ORDER_CNT, TOTAL_PRICE, ORDER_PAYMENT FROM CAFE_ORDER WHERE CUSTOMER_NAME = '" + customerName + "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getInt(3) + "원 | " + rs.getString(4) + " | " + rs.getInt(5) + "원 | " + rs.getInt(6) + "개 | " + rs.getInt(7) + "원 | " + rs.getString(8));
                System.out.println("--------------------------------------");
            }
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void customerInsertDelete(){
        System.out.print("[1]고객 추가 [2]고객 삭제 [3]취소 : ");
        int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    System.out.println("[고객 추가]");
                    System.out.print("고객 이름 : ");
                    String customerName = sc.next();
                    System.out.print("고객 연락처 : ");
                    String customerPhone = sc.next();
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO CAFE_CUSTOMER VALUES((SELECT NVL(MAX(CUSTOMER_ID)+1,1) FROM CAFE_CUSTOMER), '" + customerName + "', '" + customerPhone + "', 0)";
                        rs = stmt.executeQuery(sql);
                        CafeCommon.close(rs);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("[고객 삭제]");
                    System.out.print("고객 이름 : ");
                    String customerDeleteName = sc.next();
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String sql = "DELETE FROM CAFE_CUSTOMER WHERE CUSTOMER_NAME = '" + customerDeleteName + "'";
                        rs = stmt.executeQuery(sql);
                        CafeCommon.close(rs);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
        }
    }
    public void customerOrderInfo(){
        System.out.println("[고객 주문 내역]");
    }
    public void customerInfo(){
        boolean run = true;
        while(run) {
        System.out.print("[1]전체 고객 조회 [2]고객 조회 [3]고객 수정 [4]취소 : ");
        int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    List<CafeCustomerVO> cafeCustomerVO = customerSelect();
                    customerSelectPrint(cafeCustomerVO);
                    continue;
                case 2:
                    customerMil();
                    continue;
                case 3:
                    customerInsertDelete();
                    continue;
                case 4:
                    run = false;
                    break;
            }
        }
    }
}
