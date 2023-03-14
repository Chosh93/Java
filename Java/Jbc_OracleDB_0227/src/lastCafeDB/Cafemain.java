package lastCafeDB;

import com.cafeDB.dao.BasketDAO;
import com.cafeDB.dao.LoginDAO;
import com.cafeDB.dao.MenuDAO;
import com.cafeDB.dao.OrderDAO;
import com.cafeDB.vo.BasketVO;
import com.cafeDB.vo.MenuVO;
import lastCafeDB.dao.CafeBasketDAO;
import lastCafeDB.dao.CafeLoginDAO;
import lastCafeDB.dao.CafeMenuDAO;
import lastCafeDB.dao.CafeOrderDAO;
import lastCafeDB.vo.CafeBasketVO;
import lastCafeDB.vo.CafeMenuVO;

import java.util.List;
import java.util.Scanner;

public class Cafemain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CafeMenuDAO cafeMenudao = new CafeMenuDAO();
        CafeOrderDAO cafeOrderdao = new CafeOrderDAO();
        CafeBasketDAO cafeBasketdao = new CafeBasketDAO();
        CafeLoginDAO cafeLogindao = new CafeLoginDAO();
        while (true) {
            switch (cafeLogindao.login()) {
                case 1:
                    while (true) {
                        System.out.println("메뉴를 선택 하세요 : ");
                        System.out.print("[1]메뉴 보기, [2]메뉴 추가/삭제, [3]매출 정보, [4]EXIT : ");
                        int adminsel = sc.nextInt();
                        switch (adminsel) {
                            case 1:
                                List<CafeMenuVO> cafeMenuVO = cafeMenudao.menuSelect();
                                cafeMenudao.menuSelectPrint(cafeMenuVO);
                                continue;
                            case 2:
                                cafeMenudao.menuInsertDelete();
                                continue;
                            case 3:
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
                                        List<CafeMenuVO> cafeMenuVO = cafeMenudao.menuSelect();
                                        cafeMenudao.menuSelectPrint(cafeMenuVO);
                                        cafeBasketdao.basketMenuContain();
                                    } else if (catesel == 2) {
                                        List<CafeMenuVO> coffee = cafeMenudao.coffeemenuSelect();
                                        cafeMenudao.coffeemenuSelectPrint(coffee);
                                        cafeBasketdao.basketMenuContain();
                                    } else if (catesel == 3) {
                                        List<CafeMenuVO> ade = cafeMenudao.ademenuSelect();
                                        cafeMenudao.ademenuSelectPrint(ade);
                                        cafeBasketdao.basketMenuContain();
                                    } else if (catesel == 4) {
                                        List<CafeMenuVO> dessert = cafeMenudao.dessertmenuSelect();
                                        cafeMenudao.dessertmenuSelectPrint(dessert);
                                        cafeBasketdao.basketMenuContain();
                                    } else if (catesel == 5)
                                        break;
                                }
                            case 2:
                                List<CafeBasketVO> basketVO = cafeBasketdao.basketSelect();
                                cafeBasketdao.basketSelectPrint(basketVO);
                                continue;
                            case 3:
                                cafeOrderdao.order();
                                continue;
                            case 4:
                                System.out.println("종료");
                                break;
                        }
                        break;
                    }
                    break;
                default :
                    break;
            }
        }
    }
}