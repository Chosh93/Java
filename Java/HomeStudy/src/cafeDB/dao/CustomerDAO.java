package cafeDB.dao;

import cafeDB.util.Common;
import cafeDB.vo.CustomerVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement  pStmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<CustomerVO> customerSelect(){
        List<CustomerVO> list = new ArrayList<>(); // 반환할 리스트를 위해 리스트 객체 생성
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_CUSTOMER ";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int customerId = rs.getInt("CUSTOMER_ID");
                String customerName = rs.getString("CUSTOMER_NAME");
                String customerPhone = rs.getString("CUSTOMER_PHONE");
                int customerMil = rs.getInt("CUSTOMER_MIL");
                CustomerVO vo = new CustomerVO(customerId, customerName, customerPhone, customerMil); // 하나의 행(레코드)에 대한 정보 저장을 위한 객체 생성
                list.add(vo);
            }
            Common.close(rs); // 연결과 역순으로 해제
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void customerSelectPrint(List<CustomerVO> list) {
        for (CustomerVO e : list) {
            System.out.println("회원 아이디 : " + e.getCustomerId());
            System.out.println("회원 이름 : " + e.getCustomerName());
            System.out.println("회원 전화번호 : " + e.getCustomerPhone());
            System.out.println("누적 포인트 : " + e.getCustomerMil());
            System.out.println("------------------------------------------------------------------------");
        }
    }

    public CustomerVO customerPointSelect(String val){
        CustomerVO vo = null;
        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_NAME = '" + val + "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int customerId = rs.getInt("CUSTOMER_ID");
                String customerName = rs.getString("CUSTOMER_NAME");
                String customerPhone = rs.getString("CUSTOMER_PHONE");
                int customerMil = rs.getInt("CUSTOMER_MIL");
                vo = new CustomerVO(customerId, customerName, customerPhone, customerMil);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);
        return vo;
    }

    public void customerPointSelectPrint(CustomerVO vo) {
        if(vo == null){
            System.out.println("회원 정보가 없습니다.");
            return;
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("회원 아이디 : " + vo.getCustomerId());
        System.out.println("회원 이름 : " + vo.getCustomerName());
        System.out.println("회원 전화번호 : " + vo.getCustomerPhone());
        System.out.println("누적 포인트 : " + vo.getCustomerMil());
        System.out.println("------------------------------------------------------------------------");
    }
    public void customerInsert(String customerName, String customerPhone) {
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO CAFE_CUSTOMER VALUES((SELECT NVL(MAX(CUSTOMER_ID)+1,1) FROM CAFE_CUSTOMER), '" + customerName + "', '" + customerPhone + "', 0)";
            rs = stmt.executeQuery(sql);
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void customerDelete(String customerDeleteName) {
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM CAFE_CUSTOMER WHERE CUSTOMER_NAME = '" + customerDeleteName + "'";
            rs = stmt.executeQuery(sql);
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void customerInfo(String customerName){
        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_CUSTOMER WHERE CUSTOMER_NAME = '" + customerName + "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println("고객 번호 : " + rs.getInt(1) + "\n고객 이름 : " + rs.getString(2) + "\n고객 마일리지 : " + rs.getInt(4));
                System.out.println("-----------------");
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("["+customerName+"님의 주문내역 조회]");
        System.out.println("--------------------------------------");
        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT ORDER_DATE, ORDER_NAME, ORDER_PRICE, OPTION_NAME, OPTION_PRICE, ORDER_CNT, TOTAL_PRICE, ORDER_PAYMENT FROM CAFE_ORDER WHERE CUSTOMER_NAME = '" + customerName + "'";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getInt(3) + "원 | " + rs.getString(4) + " | " + rs.getInt(5) + "원 | " + rs.getInt(6) + "개 | " + rs.getInt(7) + "원 | " + rs.getString(8));
                System.out.println("--------------------------------------");
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}