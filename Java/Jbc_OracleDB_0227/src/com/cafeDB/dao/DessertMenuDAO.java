package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.DessertMenuVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DessertMenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);

    public List<DessertMenuVO> dessertMenuSelect(){
        List<DessertMenuVO> list = new ArrayList<>();
        try{
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM DESSERT_MENU";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                int dessertMenuId = rset.getInt("MENU_ID");
                String dessertMenuName = rset.getString("MENU_NAME");
                int dessertMenuPrice = rset.getInt("MENU_PRICE");
                String dessertMenuCategory = rset.getString("MENU_CATEGORY");
                DessertMenuVO dessertvo = new DessertMenuVO(dessertMenuId, dessertMenuName, dessertMenuPrice, dessertMenuCategory);
                list.add(dessertvo);
            }
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void dessertMenuSelectPrint(List<DessertMenuVO> list){
        for(DessertMenuVO e : list){
            System.out.println("번호 : " + e.getDessertMenuID());
            System.out.println("이름 : " + e.getDessertMenuName());
            System.out.println("가격 : " + e.getDessertMenuPrice());
            System.out.println("카테고리 : " + e.getDessertMenuCategory());
            System.out.println("--------------------------------------------");
        }
    }
    public void dessertMenuInsert() {
        System.out.println("추가할 디저트 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String dessertMenuName = sc.next();
        System.out.print("메뉴 가격 : ");
        int dessertMenuPrice = sc.nextInt();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO DESSERT_MENU(MENU_ID, MENU_NAME, MENU_PRICE, MENU_CATEGORY) VALUES((SELECT NVL(MAX(MENU_ID),0)+1 FROM DESSERT_MENU), '" + dessertMenuName + "', " + dessertMenuPrice + ", " + "'DESSERT')";
            rset = stmt.executeQuery(query);
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void dessertMenuDelete() {
        System.out.println("삭제할 디저트 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String dessertMenuName = sc.next();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM DESSERT_MENU WHERE MENU_NAME = " + "'" + dessertMenuName + "'";
            rset = stmt.executeQuery(query);
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void dessertMenuUpdate() {
        System.out.println("변경할 내용 : [1]메뉴이름변경, [2]메뉴가격변경");
        int updatesel = sc.nextInt();
        switch(updatesel){
            case 1:
                System.out.print("변경 전 메뉴 이름 : ");
                String dessertMenuBeforeName = sc.next();
                System.out.print("변경 후 메뉴 이름 : ");
                String dessertMenuAfterName = sc.next();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String query = "UPDATE DESSERT_MENU SET MENU_NAME = '" + dessertMenuAfterName + "'" + " WHERE MENU_NAME = " + "'" + dessertMenuBeforeName + "'";
                    rset = stmt.executeQuery(query);
                    CafeCommon.close(rset);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                } break;
            case 2:
                System.out.print("변경할 메뉴 이름 : ");
                String dessertMenuName_Price = sc.next();
                System.out.print("변경 후 메뉴 가격 : ");
                int dessertMenuAfterPrice = sc.nextInt();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String query = "UPDATE DESSERT_MENU SET MENU_PRICE = " + "'" + dessertMenuAfterPrice + "'" + " WHERE MENU_NAME = " + "'" + dessertMenuName_Price + "'";
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