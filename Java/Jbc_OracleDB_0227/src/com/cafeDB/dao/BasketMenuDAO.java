package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.BasketMenuVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasketMenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);

    public List<BasketMenuVO> basketMenuSelect(){
        List<BasketMenuVO> list = new ArrayList<>();
        try{
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM CAFE_BASKET ORDER BY BASKET_ID";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                int basketMenuId = rset.getInt("BASKET_ID");
                String basketMenuName = rset.getString("BASKET_NAME");
                String basketOptionName = rset.getString("BASKET_OPTION");
                BasketMenuVO vo = new BasketMenuVO(basketMenuId, basketMenuName, basketOptionName);
                list.add(vo);
            }
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void basketMenuSelectPrint(List<BasketMenuVO> list){
        System.out.println("NO      커피 이름       옵션");
        for(BasketMenuVO e : list){
            System.out.println(e.getBasketId()+ "     "+ e.getBasketName()+ "     "+e.getBasketOption());
        }
    }
    public void basketCoffeeInsertMenu() {
        System.out.println("[1]장바구니에 담을 메뉴와 옵션을 입력 하세요. / [2]EXIT ");
        int sel = sc.nextInt();
        if(sel == 1) {
            System.out.print("메뉴 이름 : ");
            String coffeeMenuName = sc.next();
            System.out.print("추가할 옵션을 선택 하세요 : [1]샷 추가, [2]옵션 없음 : ");
            int coffeeMenuOption = sc.nextInt();
            switch (coffeeMenuOption) {
                case 1:
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String query = "INSERT INTO CAFE_BASKET(BASKET_ID, BASKET_NAME, BASKET_PRICE, BASKET_OPTION, BASKET_OPTION_PRICE) " +
                                "SELECT BASKET_SEQ.NEXTVAL, C.MENU_NAME, C.MENU_PRICE, O.OPTION_NAME, O.OPTION_PRICE " +
                                "FROM COFFEE_MENU C, CAFE_OPTION O WHERE C.MENU_NAME = '" + coffeeMenuName + "' AND O.OPTION_NAME = '샷 추가'";
                        rset = stmt.executeQuery(query);
                        CafeCommon.close(rset);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String query = "INSERT INTO CAFE_BASKET(BASKET_ID, BASKET_NAME, BASKET_PRICE, BASKET_OPTION, BASKET_OPTION_PRICE, BASKET_TOTAL) " +
                                "SELECT BASKET_SEQ.NEXTVAL, C.MENU_NAME, C.MENU_PRICE, O.OPTION_NAME, O.OPTION_PRICE, SUM(C.MENU_PRICE + O.OPTIO_PRICE) " +
                                "FROM COFFEE_MENU C, CAFE_OPTION O WHERE C.MENU_NAME = '" + coffeeMenuName + "' AND O.OPTION_NAME = '선택 안함'";
                        rset = stmt.executeQuery(query);
                        CafeCommon.close(rset);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    public void basketAdeInsertMenu() {
        System.out.println("[1]장바구니에 담을 메뉴와 옵션을 입력 하세요. / [2]EXIT ");
        int sel = sc.nextInt();
        if(sel == 1) {
            System.out.print("메뉴 이름 : ");
            String coffeeMenuName = sc.next();
            System.out.print("추가할 옵션을 선택 하세요 : [1]샷 추가, [2]옵션 없음 : ");
            int coffeeMenuOption = sc.nextInt();
            switch (coffeeMenuOption) {
                case 1:
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String query = "INSERT INTO CAFE_BASKET(BASKET_ID, BASKET_NAME, BASKET_PRICE, BASKET_OPTION, BASKET_OPTION_PRICE) " +
                                "SELECT BASKET_SEQ.NEXTVAL, C.MENU_NAME, C.MENU_PRICE, O.OPTION_NAME, O.OPTION_PRICE " +
                                "FROM COFFEE_MENU C, CAFE_OPTION O WHERE C.MENU_NAME = '" + coffeeMenuName + "' AND O.OPTION_NAME = '샷 추가'";
                        rset = stmt.executeQuery(query);
                        CafeCommon.close(rset);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String query = "INSERT INTO CAFE_BASKET(BASKET_ID, BASKET_NAME, BASKET_PRICE, BASKET_OPTION, BASKET_OPTION_PRICE, BASKET_TOTAL) " +
                                "SELECT BASKET_SEQ.NEXTVAL, C.MENU_NAME, C.MENU_PRICE, O.OPTION_NAME, O.OPTION_PRICE, SUM(C.MENU_PRICE + O.OPTIO_PRICE) " +
                                "FROM COFFEE_MENU C, CAFE_OPTION O WHERE C.MENU_NAME = '" + coffeeMenuName + "' AND O.OPTION_NAME = '선택 안함'";
                        rset = stmt.executeQuery(query);
                        CafeCommon.close(rset);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    public void basketDessertInsertMenu() {
        System.out.println("[1]장바구니에 담을 메뉴와 옵션을 입력 하세요. / [2]EXIT ");
        int sel = sc.nextInt();
        if(sel == 1) {
            System.out.print("메뉴 이름 : ");
            String coffeeMenuName = sc.next();
            System.out.print("추가할 옵션을 선택 하세요 : [1]샷 추가, [2]옵션 없음 : ");
            int coffeeMenuOption = sc.nextInt();
            switch (coffeeMenuOption) {
                case 1:
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String query = "INSERT INTO CAFE_BASKET(BASKET_ID, BASKET_NAME, BASKET_PRICE, BASKET_OPTION, BASKET_OPTION_PRICE) " +
                                "SELECT BASKET_SEQ.NEXTVAL, C.MENU_NAME, C.MENU_PRICE, O.OPTION_NAME, O.OPTION_PRICE " +
                                "FROM COFFEE_MENU C, CAFE_OPTION O WHERE C.MENU_NAME = '" + coffeeMenuName + "' AND O.OPTION_NAME = '샷 추가'";
                        rset = stmt.executeQuery(query);
                        CafeCommon.close(rset);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        conn = CafeCommon.getConnection();
                        stmt = conn.createStatement();
                        String query = "INSERT INTO CAFE_BASKET(BASKET_ID, BASKET_NAME, BASKET_PRICE, BASKET_OPTION, BASKET_OPTION_PRICE, BASKET_TOTAL) " +
                                "SELECT BASKET_SEQ.NEXTVAL, C.MENU_NAME, C.MENU_PRICE, O.OPTION_NAME, O.OPTION_PRICE, SUM(C.MENU_PRICE + O.OPTIO_PRICE) " +
                                "FROM COFFEE_MENU C, CAFE_OPTION O WHERE C.MENU_NAME = '" + coffeeMenuName + "' AND O.OPTION_NAME = '선택 안함'";
                        rset = stmt.executeQuery(query);
                        CafeCommon.close(rset);
                        CafeCommon.close(stmt);
                        CafeCommon.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public void basketMenuDelete() {
        System.out.print("품목 삭제 [1]YES, [2]NO");
        int sel = sc.nextInt();
        if (sel == 1) {
            System.out.print("장바구니에서 삭제 할 NO. : ");
            int deletesel = sc.nextInt();
            try {
                conn = CafeCommon.getConnection();
                stmt = conn.createStatement();
                String query = "DELETE FROM CAFE_BASKET WHERE BASKET_ID = " + deletesel;
                rset = stmt.executeQuery(query);
                CafeCommon.close(rset);
                CafeCommon.close((stmt));
                CafeCommon.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
