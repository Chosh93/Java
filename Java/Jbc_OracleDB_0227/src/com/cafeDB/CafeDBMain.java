package com.cafeDB;

import com.cafeDB.dao.*;
import com.cafeDB.vo.BasketMenuVO;
import com.cafeDB.vo.MenuVO;

import java.util.List;
import java.util.Scanner;

public class CafeDBMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuDAO menudao = new MenuDAO();
        BasketMenuDAO basketdao = new BasketMenuDAO();
        while (true) {
            System.out.print("로그인 ID : ");
            String cafeId = sc.next();
            System.out.print("로그인 PW : ");
            String cafePw = sc.next();
            if (cafeId.equals("사장님") && cafePw.equals("카페번호")) {
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
                            continue;
                        case 4:
                            break;
                    }
                    break;
                }
            } else if (cafeId.equals("손님") && cafePw.equals("1")) {
                while (true) {
                    System.out.println("메뉴를 선택 하세요 : ");
                    System.out.print("[1]메뉴보기, [2]장바구니, [3]주문하기, [4]마일리지, [5]EXIT : ");
                    int sel = sc.nextInt();
                    switch (sel) {
                        case 1:

                        case 2:
                            List<BasketMenuVO> basketMenuVO = basketdao.basketMenuSelect();
                            basketdao.basketMenuSelectPrint(basketMenuVO);
                            basketdao.basketMenuDelete();
                            continue;
                        case 3:

                        case 4:
                            System.out.println("종료");
                            break;
                    }
                    break;
                }
            }
        }
    }
}