package cafeDB.dao;

import cafeDB.util.CafeCommon;
import cafeDB.vo.AdeMenuVO;
import cafeDB.vo.CafeCategoryVO;
import cafeDB.vo.CoffeeMenuVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdeMenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);

    public List<AdeMenuVO> adeMenuSelect(){
        List<AdeMenuVO> list = new ArrayList<>();
        try{
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM ADE_MENU";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                int adeMenuId = rset.getInt("MENU_ID");
                String adeMenuName = rset.getString("MENU_NAME");
                int adeMenuPrice = rset.getInt("MENU_PRICE");
                String adeMenuCategory = rset.getString("MENU_CATEGORY");
                AdeMenuVO adevo = new AdeMenuVO(adeMenuId, adeMenuName, adeMenuPrice, adeMenuCategory);
                list.add(adevo);
            }
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void adeMenuSelectPrint(List<AdeMenuVO> list){
        for(AdeMenuVO e : list){
            System.out.println("번호 : " + e.getAdeMenuId());
            System.out.println("이름 : " + e.getAdeMenuName());
            System.out.println("가격 : " + e.getAdeMenuPrice());
            System.out.println("카테고리 : " + e.getAdeMenuCategory());
            System.out.println("--------------------------------------------");
        }
    }
    public void adeMenuInsert() {
        System.out.println("추가할 에이드 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String adeMenuName = sc.next();
        System.out.print("메뉴 가격 : ");
        int adeMenuPrice = sc.nextInt();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO ADE_MENU(MENU_ID, MENU_NAME, MENU_PRICE, MENU_CATEGORY) VALUES((SELECT NVL(MAX(MENU_ID),0)+1 FROM ADE_MENU), '" + adeMenuName + "', " + adeMenuPrice + ", " + "'ADE')";
            rset = stmt.executeQuery(query);
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adeMenuDelete() {
        System.out.println("삭제할 에이드 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String adeMenuName = sc.next();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM ADE_MENU WHERE MENU_NAME = " + "'" + adeMenuName + "'";
            rset = stmt.executeQuery(query);
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void adeMenuUpdate() {
        System.out.println("변경할 내용 : [1]메뉴이름변경, [2]메뉴가격변경");
        int updatesel = sc.nextInt();
        switch(updatesel){
            case 1:
                System.out.print("변경 전 메뉴 이름 : ");
                String adeMenuBeforeName = sc.next();
                System.out.print("변경 후 메뉴 이름 : ");
                String adeMenuAfterName = sc.next();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String query = "UPDATE ADE_MENU SET MENU_NAME = '" + adeMenuAfterName + "'" + " WHERE MENU_NAME = " + "'" + adeMenuBeforeName + "'";
                    rset = stmt.executeQuery(query);
                    CafeCommon.close(rset);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                } break;
            case 2:
                System.out.print("변경할 메뉴 이름 : ");
                String adeMenuName_Price = sc.next();
                System.out.print("변경 후 메뉴 가격 : ");
                int adeMenuAfterPrice = sc.nextInt();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String query = "UPDATE ADE_MENU SET MENU_PRICE = " + "'" + adeMenuAfterPrice + "'" + " WHERE MENU_NAME = " + "'" + adeMenuName_Price + "'";
                    rset = stmt.executeQuery(query);
                    CafeCommon.close(rset);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                } break;

        }
    }
}