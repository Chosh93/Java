package cafeDB.dao;

import cafeDB.Method;
import cafeDB.util.Common;
import cafeDB.vo.OrderVO;

import java.sql.Connection;
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
    public List<OrderVO> OrderList() {
        List<OrderVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_ORDER ORDER BY ORDER_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int orderId = rs.getInt("ORDER_ID");
                String orderDate = rs.getString("ORDER_DATE");
                int customerId = rs.getInt("CUSTOMER_ID");
                String customerName = rs.getString("CUSTOMER_NAME");
                String orderName = rs.getString("ORDER_NAME");
                int orderPrice = rs.getInt("ORDER_PRICE");
                String optionName = rs.getString("OPTION_NAME");
                int optionPrice = rs.getInt("OPTION_PRICE");
                int orderCnt = rs.getInt("ORDER_CNT");
                int totalPrice = rs.getInt("TOTAL_PRICE");
                String orderPayment = rs.getString("ORDER_PAYMENT");
                int customerPoint = rs.getInt("CUSTOMER_POINT");

                OrderVO vo = new OrderVO(orderId, orderDate, customerId, customerName, orderName, orderPrice, optionName, optionPrice, orderCnt, totalPrice, orderPayment, customerPoint);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cafeOrderListPrint(List<OrderVO> list) {
        System.out.println("-----------------------------");
        for (OrderVO e : list) {
            System.out.println("주문 번호 : " + e.getOrderId());
            System.out.println("주문 날짜 : " + e.getOrderDate());
            System.out.println("고객 ID : " + e.getCustomerId());
            System.out.println("고객 이름 : " + e.getCustomerName());
            System.out.println("메뉴 이름 : " + e.getOrderName());
            System.out.println("메뉴 가격 : " + e.getOrderPrice());
            System.out.println("옵션 이름 : " + e.getOptionName());
            System.out.println("옵션 가격 : " + e.getOptionPrice());
            System.out.println("주문 수량 : " + e.getOrderCnt());
            System.out.println("결제 금액 : " + e.getTotalPrice());
            System.out.println("결제 방법 : " + e.getPayment());
            System.out.println("마일리지 : " + e.getCsPoint());
            System.out.println("-----------------------------");
        }
    }
    public void order() {
        System.out.print("[1]주문하기 [2]메뉴 수정 [3]취소");
        int sel = sc.nextInt();
        switch (sel) {
            case 1:
                System.out.println("[주문 방법]");
                System.out.print("[1]현금 [2]카드 : ");
                int ordersel = sc.nextInt();
                String payment = "";
                if (ordersel == 1) payment = "현금";
                else if (ordersel == 2) payment = "카드";
                System.out.print("[1]적립 [2]적립안함 : ");
                int milsel = sc.nextInt();
                String customerName = "";
                if (milsel == 1) {
                    System.out.print("고객 이름 : ");
                    customerName = sc.next();
                    try {
                        conn = Common.getConnection();
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO CAFE_ORDER SELECT ORDER_SEQ.NEXTVAL, SYSDATE, C.CUSTOMER_ID, C.CUSTOMER_NAME, B.MENU_NAME, B.MENU_PRICE," +
                                " B.OPTION_NAME, B.OPTION_PRICE, B.MENU_CNT, B.TOTAL_PRICE, '" + payment + "', B.TOTAL_PRICE/100 " +
                                "FROM CAFE_BASKET B JOIN CAFE_CUSTOMER C ON 1=1 WHERE C.CUSTOMER_NAME = '" + customerName + "'";
                        rs = stmt.executeQuery(sql);
                        mileagePoint(customerName);
                        Common.close(rs);
                        Common.close(stmt);
                        Common.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        conn = Common.getConnection();
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO CAFE_ORDER SELECT ORDER_SEQ.NEXTVAL, SYSDATE, C.CUSTOMER_ID, C.CUSTOMER_NAME, B.MENU_NAME, B.MENU_PRICE," +
                                " B.OPTION_NAME, B.OPTION_PRICE, B.MENU_CNT, B.TOTAL_PRICE, '" + payment + "', C.CUSTOMER_MIL " +
                                "FROM CAFE_BASKET B JOIN CAFE_CUSTOMER C ON 1=1 WHERE C.CUSTOMER_NAME = '비회원'";
                        rs = stmt.executeQuery(sql);
                        Common.close(rs);
                        Common.close(stmt);
                        Common.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("[주문하기 완료 되었습니다.]");
                break;
            case 2:
                basketdao.basketmenuDelete();
                System.out.println("해당 메뉴가 장비구니에서 삭제 되었습니다.");
                break;
            default:
                break;
        }
    }
    public void dailySales(){
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT SUBSTR(ORDER_DATE, 1, 8) AS ORDER_DATE, SUM(TOTAL_PRICE) AS TOTAL_PRICE FROM CAFE_ORDER GROUP BY SUBSTR(ORDER_DATE, 1, 8) ORDER BY SUBSTR(ORDER_DATE, 1, 8)";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("날짜 : " + rs.getString(1) + "\n일일 매출 : " + rs.getInt(2) + "원");
                System.out.println("---------------");
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void monthSales(){
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT SUBSTR(ORDER_DATE, 1, 5) AS ORDER_DATE, SUM(TOTAL_PRICE) AS TOTAL_PRICE FROM CAFE_ORDER" +
                    " GROUP BY SUBSTR(ORDER_DATE, 1, 5)";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("날짜 : " + rs.getString(1) + "\n월 매출 : " + rs.getInt(2) + "원");
                System.out.println("---------------");
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void rankOrder(){
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT ORDER_NAME, SUM(ORDER_CNT) FROM CAFE_ORDER GROUP BY ORDER_NAME ORDER BY SUM(ORDER_CNT) DESC";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("메뉴 이름 : " + rs.getString(1) + "\n판매량 : " + rs.getInt(2));
                System.out.println("---------------");
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mileagePoint(String customerName){
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT TOTAL_PRICE FROM CAFE_BASKET";
            rs = stmt.executeQuery(sql);
            rs.next();
            int totalPrice = rs.getInt(1);
            String sql2 = "SELECT CUSTOMER_NAME, CUSTOMER_MIL FROM CAFE_CUSTOMER";
            rs = stmt.executeQuery(sql2);
            rs.next();
            int totalMil = rs.getInt(2) + totalPrice/100;
            String sql3 = "UPDATE CAFE_CUSTOMER SET CUSTOMER_MIL = "+totalMil + "WHERE CUSTOMER_NAME = '" + customerName +"'";
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
