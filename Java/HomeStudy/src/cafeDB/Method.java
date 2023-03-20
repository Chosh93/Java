package cafeDB;

import cafeDB.dao.BasketDAO;
import cafeDB.dao.CustomerDAO;
import cafeDB.dao.MenuDAO;
import cafeDB.dao.OrderDAO;
import cafeDB.vo.BasketVO;
import cafeDB.vo.CustomerVO;
import cafeDB.vo.MenuVO;
import cafeDB.vo.OrderVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Method {
    Scanner sc = new Scanner(System.in);
    MenuDAO menudao = new MenuDAO();
    BasketDAO basketdao = new BasketDAO();
    OrderDAO orderdao = new OrderDAO();
    CustomerDAO customerdao = new CustomerDAO();
    boolean menu = true;
    boolean cate = true;
    String cName = "";
    public void customerMode() {
        while (menu) {
            System.out.println("[1]메뉴보기 [2]장바구니 [3]주문하기 [4]종료");
            System.out.print(">>> : ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    while (cate) {
                        System.out.println("[1]COFFEE [2]ADE [3]DESSERT [4]종료");
                        System.out.print(">>> : ");
                        int catesel = sc.nextInt();
                        switch (catesel) {
                            case 1:
                                List<MenuVO> menuVO1 = menudao.categorySelect("COFFEE");
                                menudao.categorySelectPrint(menuVO1);
                                menudao.MenuContain();
                                break;
                            case 2:
                                List<MenuVO> menuVO2 = menudao.categorySelect("ADE");
                                menudao.categorySelectPrint(menuVO2);
                                menudao.MenuContain();
                                continue;
                            case 3:
                                List<MenuVO> menuVO3 = menudao.categorySelect("DESSERT");
                                menudao.categorySelectPrint(menuVO3);
                                menudao.MenuContain();
                                break;
                            case 4:
                                cate = false;
                                break;
                        }
                    }
                    continue;
                case 2:
                    List<BasketVO> basketVO = basketdao.basketSelect();
                    basketdao.basketSelectPrint(basketVO);
                    basketdao.basketmenuDelete();
                    break;
                case 3:
                    orderdao.order();
                    basketdao.basketDelete();
                    break;
                case 4:
                    menu = false;
                    break;

            }
            break;
        }
    }

    public void adminMode() {
        boolean adme = true;
        boolean cs = true;
        boolean sales = true;
        boolean menuinsdel = true;
        while (adme) {
            System.out.println("[1]회원정보 [2]매출정보 [3]메뉴수정 [4]종료");
            System.out.print(">>> : ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    while (cs) {
                        System.out.println("[1]회원조회 [2]회원수정 [3]회원상세조회 [4]종료");
                        System.out.print(">>> : ");
                        int csSel = sc.nextInt();
                        switch (csSel) {
                            case 1:
                                List<CustomerVO> customerVO = customerdao.customerSelect();
                                customerdao.customerSelectPrint(customerVO);
                                break;
                            case 2:
                                System.out.print("[1]고객 추가 [2]고객 삭제 [3]취소 : ");
                                int csinsdelSel = sc.nextInt();
                                if(csinsdelSel == 1){
                                    System.out.println("[고객 추가]");
                                    System.out.print("고객 이름 : ");
                                    String customerName = sc.next();
                                    System.out.print("고객 연락처 : ");
                                    String customerPhone = sc.next();
                                    customerdao.customerInsert(customerName, customerPhone);
                                } else if(csinsdelSel == 2){
                                    System.out.println("[고객 삭제]");
                                    System.out.print("고객 이름 : ");
                                    String customerDeleteName = sc.next();
                                    customerdao.customerDelete(customerDeleteName);
                                } else if(csinsdelSel == 3) break;
                            case 3:
                                System.out.println("[고객 정보 조회]");
                                System.out.print("고객 이름 : ");
                                String customerName = sc.next();
                                System.out.println("-----------------");
                                customerdao.customerInfo(customerName);
                                break;
                            default:
                                cs = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    while(sales){
                        System.out.print("[1]주문내역 [2]일일매출 [3]월 매출 [4]판매량 [5]취소 : ");
                        int saleSel = sc.nextInt();
                        switch (saleSel) {
                            case 1:
                                List<OrderVO> list = orderdao.OrderList();
                                orderdao.cafeOrderListPrint(list);
                                break;
                            case 2:
                                System.out.println("[일일 매출]");
                                System.out.println("---------------");
                                orderdao.dailySales();
                                break;
                            case 3:
                                System.out.println("[월 매출]");
                                System.out.println("-----------");
                                orderdao.monthSales();
                                break;
                            case 4:
                                System.out.println("[판매량 인기 순위]");
                                System.out.println("-----------------");
                                orderdao.rankOrder();
                                break;
                            default:
                                sales = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    while(menuinsdel){
                        System.out.print("[1]메뉴 추가 [2]메뉴 삭제 [3]나가기 : ");
                        int insertsel = sc.nextInt();
                        switch(insertsel){
                            case 1:
                                System.out.println("추가 할 메뉴의 정보를 입력 하세요.");
                                System.out.print("메뉴 이름 : ");
                                String menuInsName = sc.next();
                                System.out.print("메뉴 가격 : ");
                                int menuPrice = sc.nextInt();
                                System.out.print("메뉴 분류 : ");
                                String menuCategory = sc.next();
                                menudao.menuInsert(menuInsName, menuPrice, menuCategory);
                                break;
                            case 2:
                                System.out.println("삭제 할 메뉴의 정보를 입력 하세요.");
                                System.out.print("메뉴 이름 : ");
                                String menuDelName = sc.next();
                                menudao.menuDelete(menuDelName);
                                break;
                            default:
                                menuinsdel = false;
                                break;
                        }
                    }
                    break;
                default:
                    adme = false;
                    break;
            }
        }
    }
}
