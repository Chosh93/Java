package lastCafeDB.dao;

import lastCafeDB.util.CafeCommon;
import lastCafeDB.vo.CafeMenuVO;
import lastCafeDB.vo.CafeOrderVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeMenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<CafeMenuVO> menuSelect() {
        List<CafeMenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU ORDER BY MENU_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int menuID = rs.getInt("MENU_ID");
                String menuName = rs.getString("MENU_NAME");
                int menuPrice = rs.getInt("MENU_PRICE");
                String menuCategory = rs.getString("MENU_CATEGORY");
                CafeMenuVO vo = new CafeMenuVO(menuID, menuName, menuPrice, menuCategory);
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

    public void menuSelectPrint(List<CafeMenuVO> list) {
        for (CafeMenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuID());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
    public List<CafeMenuVO> coffeemenuSelect() {
        List<lastCafeDB.vo.CafeMenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU WHERE MENU_CATEGORY = 'COFFEE' ORDER BY MENU_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int menuID = rs.getInt("MENU_ID");
                String menuName = rs.getString("MENU_NAME");
                int menuPrice = rs.getInt("MENU_PRICE");
                String menuCategory = rs.getString("MENU_CATEGORY");
                lastCafeDB.vo.CafeMenuVO vo = new lastCafeDB.vo.CafeMenuVO(menuID, menuName, menuPrice, menuCategory);
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

    public void coffeemenuSelectPrint(List<CafeMenuVO> list) {
        for (CafeMenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuID());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
    public List<CafeMenuVO> ademenuSelect() {
        List<lastCafeDB.vo.CafeMenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU WHERE MENU_CATEGORY = 'ADE' ORDER BY MENU_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int menuID = rs.getInt("MENU_ID");
                String menuName = rs.getString("MENU_NAME");
                int menuPrice = rs.getInt("MENU_PRICE");
                String menuCategory = rs.getString("MENU_CATEGORY");
                lastCafeDB.vo.CafeMenuVO vo = new lastCafeDB.vo.CafeMenuVO(menuID, menuName, menuPrice, menuCategory);
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

    public void ademenuSelectPrint(List<CafeMenuVO> list) {
        for (CafeMenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuID());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
    public List<CafeMenuVO> dessertmenuSelect() {
        List<lastCafeDB.vo.CafeMenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_MENU WHERE MENU_CATEGORY = 'DESSERT' ORDER BY MENU_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int menuID = rs.getInt("MENU_ID");
                String menuName = rs.getString("MENU_NAME");
                int menuPrice = rs.getInt("MENU_PRICE");
                String menuCategory = rs.getString("MENU_CATEGORY");
                lastCafeDB.vo.CafeMenuVO vo = new lastCafeDB.vo.CafeMenuVO(menuID, menuName, menuPrice, menuCategory);
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

    public void dessertmenuSelectPrint(List<CafeMenuVO> list) {
        for (CafeMenuVO e : list) {
            System.out.println("메뉴번호 : " + e.getMenuID());
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("메뉴가격 : " + e.getMenuPrice());
            System.out.println("메뉴분류 : " + e.getMenuCategory());
            System.out.println("-----------------------------");
        }
    }
    public void menuInsertDelete(){
        System.out.print("[1]메뉴 추가 [2]메뉴 삭제 [3]나가기 : ");
        int sel = sc.nextInt();
        switch(sel) {
            case 1:
                System.out.println("추가 할 메뉴의 정보를 입력 하세요.");
                System.out.print("메뉴 이름 : ");
                String menuInsName = sc.next();
                System.out.print("메뉴 가격 : ");
                int menuPrice = sc.nextInt();
                System.out.print("메뉴 분류 : ");
                String menuCategory = sc.next();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO CAFE_MENU(MENU_ID, MENU_NAME, MENU_PRICE, MENU_CATEGORY) VALUES((SELECT NVL(MAX(MENU_ID),0)+1 FROM CAFE_MENU), '" + menuInsName + "', " + menuPrice + ", '" + menuCategory + "')";
                    rs = stmt.executeQuery(sql);
                    CafeCommon.close(rs);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("메뉴 " + menuInsName + " 추가 완료 되었습니다.");
                break;
            case 2:
                System.out.println("삭제 할 메뉴의 정보를 입력 하세요.");
                System.out.print("메뉴 이름 : ");
                String menuDelName = sc.next();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String sql = "DELETE FROM CAFE_MENU WHERE MENU_NAME = '" + menuDelName + "'";
                    rs = stmt.executeQuery(sql);
                    CafeCommon.close(rs);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("메뉴 " + menuDelName + " 삭제 완료 되었습니다.");
                break;
        }
    }
}