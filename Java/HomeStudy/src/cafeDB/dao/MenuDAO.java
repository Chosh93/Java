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

    public List<MenuVO> categorySelect(String category) {
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

    public void MenuContain(int menuCnt, String menuContainName, String opName) {
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO CAFE_BASKET SELECT BASKET_SEQ.NEXTVAL, M.MENU_NAME, M.MENU_PRICE, O.OPTION_NAME, " +
                    "O.OPTION_PRICE, " + menuCnt + ", (M.MENU_PRICE+O.OPTION_PRICE)*" + menuCnt + " " +
                    "FROM CAFE_MENU M JOIN CAFE_OPTION O ON 1=1 " +
                    "WHERE M.MENU_NAME = '" + menuContainName + "' AND O.OPTION_NAME = '" + opName + "'";
            rs = stmt.executeQuery(sql);
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(menuContainName + "(" + opName + ")" + " 메뉴를 담았습니다.");
    }

    public void menuInsert(String menuInsName, int menuPrice, String menuCategory) {
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO CAFE_MENU(MENU_ID, MENU_NAME, MENU_PRICE, MENU_CATEGORY) VALUES((SELECT NVL(MAX(MENU_ID),0)+1 FROM CAFE_MENU), '" + menuInsName + "', " + menuPrice + ", '" + menuCategory + "')";
            rs = stmt.executeQuery(sql);
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("메뉴 " + menuInsName + " 추가 완료 되었습니다.");
    }

    public void menuDelete(String menuDelName) {
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM CAFE_MENU WHERE MENU_NAME = '" + menuDelName + "'";
            rs = stmt.executeQuery(sql);
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("메뉴 " + menuDelName + " 삭제 완료 되었습니다.");
    }
}
