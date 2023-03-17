package cafeDB;

import cafeDB.dao.BasketDAO;
import cafeDB.dao.MenuDAO;
import cafeDB.vo.BasketVO;
import cafeDB.vo.MenuVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Method {
    Scanner sc = new Scanner(System.in);
    MenuDAO menudao = new MenuDAO();
    BasketDAO basketdao = new BasketDAO();
    boolean menu = true;
    boolean cate = true;
    public void customerMode(){
        while(menu) {
            System.out.println("[1]메뉴보기 [2]장바구니 [3]주문하기 [4]종료");
            System.out.print(">>> : ");
            int sel = sc.nextInt();
            switch(sel){
                case 1:
                    while(cate) {
                        System.out.println("[1]COFFEE [2]ADE [3]DESSERT [4]종료");
                        System.out.print(">>> : ");
                        int catesel = sc.nextInt();
                        switch (catesel){
                            case 1:
                                List<MenuVO> menuVO1 = menudao.categorySelect("COFFEE");
                                menudao.categorySelectPrint(menuVO1);
                                menudao.MenuContain();
                                continue;
                            case 2:
                                List<MenuVO> menuVO2 = menudao.categorySelect("ADE");
                                menudao.categorySelectPrint(menuVO2);
                                menudao.MenuContain();
                                continue;
                            case 3:
                                List<MenuVO> menuVO3 = menudao.categorySelect("DESSERT");
                                menudao.categorySelectPrint(menuVO3);
                                menudao.MenuContain();
                                continue;
                            case 4:
                                cate = false;
                        }
                    }
                    continue;
                case 2:
                    List<BasketVO> basketVO = basketdao.basketSelect();
                    basketdao.basketSelectPrint(basketVO);
                    basketdao.basketmenuDelete();
                    continue;
                case 3:

                case 4:
                    menu = false;

            }
        }
    }
}
