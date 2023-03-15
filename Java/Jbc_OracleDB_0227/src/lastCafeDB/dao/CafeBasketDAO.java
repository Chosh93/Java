package lastCafeDB.dao;

import lastCafeDB.util.CafeCommon;
import lastCafeDB.vo.CafeBasketVO;
import lastCafeDB.vo.CafeMenuVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeBasketDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    public List<CafeBasketVO> basketSelect() {
        List<CafeBasketVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_BASKET ORDER BY BASKET_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int basketId = rs.getInt("BASKET_ID");
                String menuName = rs.getString("MENU_NAME");
                int menuPrice = rs.getInt("MENU_PRICE");
                String optionName = rs.getString("OPTION_NAME");
                int optionPrice = rs.getInt("OPTION_PRICE");
                int cnt = rs.getInt("MENU_CNT");
                int totalPrice = rs.getInt("TOTAL_PRICE");

                CafeBasketVO vo = new CafeBasketVO(basketId, menuName, menuPrice, optionName, optionPrice, cnt, totalPrice);
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

    public void basketSelectPrint(List<CafeBasketVO> list) {
        System.out.println("-----------------------------");
        for (CafeBasketVO e : list) {
            System.out.println("장바구니 번호 : " + e.getBasketId());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("옵션 : " + e.getOptionName());
            System.out.println("옵션 가격 : " + e.getOptionPrice());
            System.out.println("수량 : " + e.getMenuCnt());
            System.out.println("총 금액 : " + e.getTotalPrice());
            System.out.println("-----------------------------");
        }
    }
    public void basketMenuContain(){
        System.out.print("[1]담기 [2]EXIT : ");
        int sel = sc.nextInt();
        switch(sel){
            case 1:
                System.out.println("[장바구니에 담을 메뉴]");
                System.out.print("메뉴 이름 : ");
                String menuContainName = sc.next();
                sc.nextLine();
                System.out.println("[옵션선택]");
                System.out.print("[1]샷 추가 [2]선택안함 : ");
                int opsel = sc.nextInt();
                String opName = "";
                if(opsel == 1) opName = "샷 추가";
                else opName = "선택 안함";
                System.out.print("메뉴 수량 : ");
                int menuCnt = sc.nextInt();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO CAFE_BASKET SELECT BASKET_SEQ.NEXTVAL, M.MENU_NAME, M.MENU_PRICE, O.OPTION_NAME, " +
                            "O.OPTION_PRICE, "+ menuCnt + ", (M.MENU_PRICE+O.OPTION_PRICE)*"+menuCnt+" " +
                            "FROM CAFE_MENU M JOIN CAFE_OPTION O ON 1=1 " +
                            "WHERE M.MENU_NAME = '"+menuContainName+"' AND O.OPTION_NAME = '"+opName+"'";
                    rs = stmt.executeQuery(sql);
                    CafeCommon.close(rs);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(menuContainName + "("+opName+")"+" 메뉴를 담았습니다.");
                break;
            case 2:
                break;
            default:
                break;
        }
    }
    public void basketmenuDelete(){
        System.out.println("[장바구니에서 수정 할 메뉴]");
        System.out.print("메뉴 이름 : ");
        String menuDeleteName = sc.next();
        sc.nextLine();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM CAFE_BASKET WHERE MENU_NAME = '" + menuDeleteName + "'";
            rs = stmt.executeQuery(sql);
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void basketDelete(){
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM CAFE_BASKET";
            rs = stmt.executeQuery(sql);
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
