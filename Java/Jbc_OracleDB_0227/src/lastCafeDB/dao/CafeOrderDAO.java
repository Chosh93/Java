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
    public void order(){
        System.out.print("[1]주문하기 [2]메뉴 수정 [3]취소");
        int sel = sc.nextInt();
        switch(sel){
            case 1:
                System.out.println("[주문 방법]");
                System.out.print("[1]현금 [2]카드 : ");
                int ordersel = sc.nextInt();
                String payment = "";
                if(ordersel == 1) payment = "현금";
                else payment = "카드";
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "SELECT ORDER_SEQ.NEXTVAL, SYSDATE, C.CUSTOMER_ID, C.CUSTOMER_NAME, B.MENU_NAME, B.MENU_PRICE," +
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
            case 2:
                cafeBasketdao.basketmenuDelete();
                System.out.println("해당 메뉴가 장비구니에서 삭제 되었습니다.");
        }
    }
}
