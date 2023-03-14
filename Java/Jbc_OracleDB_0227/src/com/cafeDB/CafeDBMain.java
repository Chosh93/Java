package com.cafeDB;

import com.cafeDB.dao.*;
import com.cafeDB.vo.*;
import java.util.List;
import java.util.Scanner;

public class CafeDBMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuDAO menudao = new MenuDAO();
        BasketDAO basketdao = new BasketDAO();
        OrderDAO orderdao = new OrderDAO();
        LoginDAO logindao = new LoginDAO();
        while (true) {
            switch (logindao.login()) {
                case 1:
                    while (true) {
                        System.out.println("메뉴를 선택 하세요 : ");
                        System.out.print("[1]메뉴 보기, [2]메뉴 추가/삭제, [3]매출 정보, [4]EXIT : ");
                        int ownersel = sc.nextInt();
                        switch (ownersel) {
                            case 1:
                                List<MenuVO> MenuVO = menudao.menuSelect();
                                menudao.menuSelectPrint(MenuVO);
                                continue;
                            case 2:
                                menudao.menuInsertDelete();
                                continue;
                            case 3:
                                menudao.menuSalesInfo();
                                continue;
                            case 4:
                                //orderdao.orderDelete();
                                break;
                        }
                        break;
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("메뉴를 선택 하세요 : ");
                        System.out.print("[1]메뉴보기, [2]장바구니, [3]주문하기, [4]EXIT : ");
                        int sel = sc.nextInt();
                        switch (sel) {
                            case 1:
                                while (true) {
                                    System.out.print("[1]전체메뉴 [2]커피 [3]에이드 [4]디저트 [5]EXIT : ");
                                    int catesel = sc.nextInt();
                                    if (catesel == 1) {
                                        List<com.cafeDB.vo.MenuVO> MenuVO = menudao.menuSelect();
                                        menudao.menuSelectPrint(MenuVO);
                                        basketdao.basketMenuContain();
                                    } else if (catesel == 2) {
                                        List<com.cafeDB.vo.MenuVO> coffee = menudao.coffeeSelect();
                                        menudao.coffeeSelectPrint(coffee);
                                        basketdao.basketMenuContain();
                                    } else if (catesel == 3) {
                                        List<com.cafeDB.vo.MenuVO> ade = menudao.adeSelect();
                                        menudao.adeSelectPrint(ade);
                                        basketdao.basketMenuContain();
                                    } else if (catesel == 4) {
                                        List<com.cafeDB.vo.MenuVO> dessert = menudao.dessertSelect();
                                        menudao.dessertSelectPrint(dessert);
                                        basketdao.basketMenuContain();
                                    } else if (catesel == 5)
                                        break;
                                }
                            case 2:
                                List<com.cafeDB.vo.BasketVO> BasketVO = basketdao.basketSelect();
                                basketdao.basketSelectPrint(BasketVO);

                                continue;
                            case 3:
                                List<BasketVO> BasketOrderVO = basketdao.basketSelect();
                                basketdao.basketSelectPrint(BasketOrderVO);
                                orderdao.order();
                                continue;
                            case 4:
                                basketdao.totalDelete();
                                System.out.println("종료");
                                break;
                        }
                        break;
                    }
                    break;
            }
        }
    }
}