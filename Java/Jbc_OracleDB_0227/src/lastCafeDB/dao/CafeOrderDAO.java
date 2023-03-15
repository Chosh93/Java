package lastCafeDB.dao;

import lastCafeDB.util.CafeCommon;
import lastCafeDB.vo.CafeBasketVO;
import lastCafeDB.vo.CafeMenuVO;
import lastCafeDB.vo.CafeOrderVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeOrderDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    CafeBasketDAO cafeBasketdao = new CafeBasketDAO();

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
                else payment = "카드";
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO CAFE_ORDER SELECT ORDER_SEQ.NEXTVAL, SYSDATE, C.CUSTOMER_ID, C.CUSTOMER_NAME, B.MENU_NAME, B.MENU_PRICE," +
                            " B.OPTION_NAME, B.OPTION_PRICE, B.MENU_CNT, B.TOTAL_PRICE, '" + payment + "', C.CUSTOMER_MIL " +
                            "FROM CAFE_BASKET B JOIN CAFE_CUSTOMER C ON 1=1";
                    rs = stmt.executeQuery(sql);
                    CafeCommon.close(rs);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("[주문하기 완료 되었습니다.]");
                break;
            case 2:
                cafeBasketdao.basketmenuDelete();
                System.out.println("해당 메뉴가 장비구니에서 삭제 되었습니다.");
                break;
        }
    }

    public List<CafeOrderVO> cafeOrderList() {
        List<CafeOrderVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
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

                CafeOrderVO vo = new CafeOrderVO(orderId, orderDate, customerId, customerName, orderName, orderPrice, optionName, optionPrice, orderCnt, totalPrice, orderPayment, customerPoint);
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

    public void cafeOrderListPrint(List<CafeOrderVO> list) {
        for (CafeOrderVO e : list) {
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
            System.out.println("결제 방법 : " + e.getOrderPayment());
            System.out.println("마일리지 : " + e.getCustomerPoint());
            System.out.println("-----------------------------");
        }
    }
    public void salesInfo(){
        System.out.print("[1]주문내역 [2]일일매출 [3]월 매출 [4]판매량 [5]취소 : ");
        int sel = sc.nextInt();
        switch (sel) {
            case 1:
                System.out.println("[주문내역]");
                List<CafeOrderVO> list = cafeOrderList();
                cafeOrderListPrint(list);
                break;
            case 2:
                System.out.println("[일일 매출]");
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "SELECT SUBSTR(ORDER_DATE, 1, 10) AS ORDER_DATE, SUM(TOTAL_PRICE) AS TOTAL_PRICE FROM CAFE_ORDER GROUP BY SUBSTR(ORDER_DATE, 1, 10)";
                    rs = stmt.executeQuery(sql);
                    CafeCommon.close(rs);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("[월 매출]");
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "SELECT SUBSTR(ORDER_DATE, 1, 7) AS ORDER_DATE, SUM(TOTAL_PRICE) AS TOTAL_PRICE FROM CAFE_ORDER" +
                            " GROUP BY SUBSTR(ORDER_DATE, 1, 7)";
                    rs = stmt.executeQuery(sql);
                    CafeCommon.close(rs);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.println("[판매량 인기 순위]");
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "SELECT ORDER_NAME, SUM(ORDER_CNT) FROM CAFE_ORDER GROUP BY ORDER_NAME ORDER BY SUM(ORDER_CNT) DESC";
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
}
