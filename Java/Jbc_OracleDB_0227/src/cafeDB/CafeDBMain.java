package cafeDB;

import cafeDB.dao.AdeMenuDAO;
import cafeDB.dao.CafeCategoryDAO;
import cafeDB.dao.CoffeeMenuDAO;
import cafeDB.dao.DessertMenuDAO;
import cafeDB.vo.AdeMenuVO;
import cafeDB.vo.CafeCategoryVO;
import cafeDB.vo.CoffeeMenuVO;
import cafeDB.vo.DessertMenuVO;

import java.util.List;
import java.util.Scanner;

public class CafeDBMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMenuDAO coffeemenudao = new CoffeeMenuDAO();
        AdeMenuDAO ademenudao = new AdeMenuDAO();
        DessertMenuDAO dessertmenudao = new DessertMenuDAO();
        CafeCategoryDAO categorydao = new CafeCategoryDAO();
        while (true) {
            System.out.print("로그인 ID : ");
            String cafeId = sc.next();
            System.out.print("로그인 PW : ");
            String cafePw = sc.next();
            if (cafeId.equals("사장님") && cafePw.equals("카페번호")) {
                while (true) {
                    System.out.println("메뉴를 선택 하세요 : ");
                    System.out.print("[1]메뉴 추가, [2]메뉴 삭제, [3]메뉴 변경, [4]매출 정보, [5]EXIT : ");
                    int ownersel = sc.nextInt();
                    switch (ownersel) {
                        case 1:
                            System.out.println("추가할 카테고리 선택");
                            System.out.print("[1]COFFEE [2]ADE [3]DESSERT [4]EXIT : ");
                            int insertsel = sc.nextInt();
                            if (insertsel == 4) break;
                            else if (insertsel == 1) coffeemenudao.coffeeMenuInsert();
                            else if (insertsel == 2) ademenudao.adeMenuInsert();
                            else if (insertsel == 3) dessertmenudao.dessertMenuInsert();
                            else break;
                        case 2:
                            System.out.println("삭제할 카테고리 선택");
                            System.out.print("[1]COFFEE [2]ADE [3]DESSERT [4]EXIT : ");
                            int deletesel = sc.nextInt();
                            if (deletesel == 4) break;
                            else if (deletesel == 1) coffeemenudao.coffeMenuDelete();
                            else if (deletesel == 2) ademenudao.adeMenuDelete();
                            else if (deletesel == 3) dessertmenudao.dessertMenuDelete();
                            else break;
                        case 3:
                            System.out.println("변경할 카테고리 선택");
                            System.out.print("[1]COFFEE [2]ADE [3]DESSERT [4]EXIT : ");
                            int updatesel = sc.nextInt();
                            if(updatesel == 4) break;
                            else if(updatesel == 1) coffeemenudao.coffeeMenuUpdate();
                            else if(updatesel == 2) ademenudao.adeMenuUpdate();
                            else if(updatesel == 3) dessertmenudao.dessertMenuUpdate();
                        case 4:
                        case 5: break;
                    }
                    break;
                }
            } else if (cafeId.equals("손님1") && cafePw.equals("010-1234-5678")) {
                while (true) {
                    System.out.println("메뉴를 선택 하세요 : ");
                    System.out.print("[1]메뉴보기, [2]주문하기, [3]마일리지, [4]EXIT : ");
                    int sel = sc.nextInt();
                    switch (sel) {
                        case 1:
                            while (true) {
                                System.out.println("카테고리를 선택하세요 : ");
                                System.out.print("[1]커피 [2]에이드 [3]디저트 [4]EXIT : ");
                                int categorysel = sc.nextInt();
                                if (categorysel == 4) break;
                                else if (categorysel == 1) {
                                    List<CoffeeMenuVO> coffeeMenuVO = coffeemenudao.coffeeMenuSelect();
                                    coffeemenudao.coffeeMenuSelectPrint(coffeeMenuVO);
                                } else if (categorysel == 2) {
                                    List<AdeMenuVO> adeMenuVO = ademenudao.adeMenuSelect();
                                    ademenudao.adeMenuSelectPrint(adeMenuVO);
                                } else if (categorysel == 3) {
                                    List<DessertMenuVO> dessertMenuVo = dessertmenudao.dessertMenuSelect();
                                    dessertmenudao.dessertMenuSelectPrint(dessertMenuVo);
                                }
                            }
                        case 2:

                            break;
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