package cafeDB.dao;

import cafeDB.util.Common;
import cafeDB.vo.MenuVO;

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

    public List<MenuVO> categorySelect(String category){
        List<MenuVO> list2 = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU WHERE MENU_CATEGORY = '" + category + "' ORDER BY MENU_ID ASC";
            rs = stmt.executeQuery(sql);
            System.out.println("=============================");
            System.out.println(category);
            System.out.println("-----------------------------");
            while (rs.next()) {
                int menuID = rs.getInt("MENU_ID");
                String menuName = rs.getString("MENU_NAME");
                int menuPrice = rs.getInt("MENU_PRICE");
                String menuCategory = rs.getString("MENU_CATEGORY");
                String menuSel = rs.getString("MENU_SEL");
                MenuVO vo = new MenuVO(menuID, menuName, menuPrice, menuCategory, menuSel);
                list2.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list2;
    }
    public void categorySelectPrint(List<MenuVO> list2) {
        for (MenuVO e : list2) {
            System.out.println("메뉴번호 : " + e.getMenuId());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
    public void MenuContain(){
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
                    conn = Common.getConnection();
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO CAFE_BASKET SELECT BASKET_SEQ.NEXTVAL, M.MENU_NAME, M.MENU_PRICE, O.OPTION_NAME, " +
                            "O.OPTION_PRICE, "+ menuCnt + ", (M.MENU_PRICE+O.OPTION_PRICE)*"+menuCnt+" " +
                            "FROM CAFE_MENU M JOIN CAFE_OPTION O ON 1=1 " +
                            "WHERE M.MENU_NAME = '"+menuContainName+"' AND O.OPTION_NAME = '"+opName+"'";
                    rs = stmt.executeQuery(sql);
                    Common.close(rs);
                    Common.close(stmt);
                    Common.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(menuContainName + "("+opName+")"+" 메뉴를 담았습니다.");
                break;
            default:
                break;
        }
    }
}
