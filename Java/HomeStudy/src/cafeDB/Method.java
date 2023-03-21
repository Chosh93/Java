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
            int point = 0;
            int t_point = 0;
            int totalPrice = 0;
            System.out.println("[1]메뉴보기 [2]장바구니 [3]주문하기 [4]종료");
            System.out.print(">>> : ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    cate = true;
                    while (cate) {
                        System.out.println("[1]COFFEE [2]ADE [3]DESSERT [4]종료");
                        System.out.print(">>> : ");
                        int catesel = sc.nextInt();
                        switch (catesel) {
                            case 1:
                                List<MenuVO> menuVO1 = menudao.categorySelect("COFFEE");
                                menudao.categorySelectPrint(menuVO1);
                                System.out.print("[1]담기 [2]EXIT : ");
                                int containSel1 = sc.nextInt();
                                if (containSel1 == 1) {
                                    System.out.println("[장바구니에 담을 메뉴]");
                                    System.out.print("메뉴 이름 : ");
                                    String menuContainName = sc.next();
                                    sc.nextLine();
                                    System.out.println("[옵션선택]");
                                    System.out.print("[1]샷 추가 [2]선택안함 : ");
                                    int opsel = sc.nextInt();
                                    String opName = "";
                                    if (opsel == 1) {
                                        opName = "샷 추가";
                                    } else {opName = "선택 안함";}
                                    System.out.print("메뉴 수량 : ");
                                    int menuCnt = sc.nextInt();
                                    menudao.MenuContain(menuCnt, menuContainName, opName);
                                } else break;
                                break;
                            case 2:
                                List<MenuVO> menuVO2 = menudao.categorySelect("ADE");
                                menudao.categorySelectPrint(menuVO2);
                                System.out.print("[1]담기 [2]EXIT : ");
                                int containSel2 = sc.nextInt();
                                if (containSel2 == 1) {
                                    System.out.println("[장바구니에 담을 메뉴]");
                                    System.out.print("메뉴 이름 : ");
                                    String menuContainName = sc.next();
                                    sc.nextLine();
                                    System.out.println("[옵션선택]");
                                    System.out.print("[1]샷 추가 [2]선택안함 : ");
                                    int opsel = sc.nextInt();
                                    String opName = "";
                                    if (opsel == 1) opName = "샷 추가";
                                    else opName = "선택 안함";
                                    System.out.print("메뉴 수량 : ");
                                    int menuCnt = sc.nextInt();
                                    menudao.MenuContain(menuCnt, menuContainName, opName);
                                } else break;
                                break;
                            case 3:
                                List<MenuVO> menuVO3 = menudao.categorySelect("DESSERT");
                                menudao.categorySelectPrint(menuVO3);
                                System.out.print("[1]담기 [2]EXIT : ");
                                int containSel3 = sc.nextInt();
                                if (containSel3 == 1) {
                                    System.out.println("[장바구니에 담을 메뉴]");
                                    System.out.print("메뉴 이름 : ");
                                    String menuContainName = sc.next();
                                    sc.nextLine();
                                    System.out.println("[옵션선택]");
                                    System.out.print("[1]샷 추가 [2]선택안함 : ");
                                    int opsel = sc.nextInt();
                                    String opName = "";
                                    if (opsel == 1) opName = "샷 추가";
                                    else opName = "선택 안함";
                                    System.out.print("메뉴 수량 : ");
                                    int menuCnt = sc.nextInt();
                                    menudao.MenuContain(menuCnt, menuContainName, opName);
                                } else break;
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
                    System.out.println("장바구니를 수정 하시겠습니까?");
                    System.out.println("[1]Yes [2]No");
                    System.out.print(">>> : ");
                    int delSel = sc.nextInt();
                    if (delSel == 2) continue;
                    else if (delSel == 1) {
                        System.out.println("[장바구니에서 수정 할 메뉴]");
                        System.out.print("메뉴 이름 : ");
                        String menuDeleteName = sc.next();
                        sc.nextLine();
                        basketdao.basketmenuDelete(menuDeleteName);
                    }
                    continue;
                case 3:
                    System.out.println("[1]주문하기 [2]메뉴 수정 [3]취소");
                    System.out.print(">> : ");
                    int orderSel = sc.nextInt();
                    if (orderSel == 3) continue;
                    else if (orderSel == 1) {
                        System.out.println("[주문 방법]");
                        System.out.print("[1]현금 [2]카드 : ");
                        int ordersel = sc.nextInt();
                        String payment = "";
                        if (ordersel == 1) payment = "현금";
                        else if (ordersel == 2) payment = "카드";
                        System.out.print("[1]적립 [2]적립안함 : ");
                        int milsel = sc.nextInt();
                        String customerName = "";
                        if (milsel == 1) {
                            System.out.print("고객 이름 : ");
                            customerName = sc.next();
                            orderdao.orderCustomer(payment, customerName);
                            OrderVO vo = null;
                            vo = orderdao.csTpriceSelect(customerName);
                            totalPrice = vo.getTotalPrice();
                            CustomerVO vo2 = null;
                            vo2 = customerdao.customerPointSelect(customerName);
                            point = vo2.getCustomerMil();
                            t_point += point + totalPrice/100;
                            customerdao.csPointSave(customerName, t_point);
                            System.out.println(point +" 마일리지가 적립되어 총 보유 마일리지 : " + t_point +"마일리지");
                        } else {
                            orderdao.orderNonCustomer(payment);
                        }
                        basketdao.basketDelete();
                        System.out.println("[주문하기 완료 되었습니다.]");
                        break;
                    } else if (orderSel == 2) {
                        System.out.println("[장바구니 메뉴 수정]");
                        System.out.print(">> : ");
                        String menuName = sc.next();
                        basketdao.basketmenuDelete(menuName);
                        System.out.println("해당 메뉴가 장비구니에서 삭제 되었습니다.");
                        break;
                    } else if(orderSel == 3) continue;
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
                        if (csSel == 1) {
                            List<CustomerVO> customerVO = customerdao.customerSelect();
                            customerdao.customerSelectPrint(customerVO);
                            break;
                        } else if (csSel == 2) {
                            System.out.print("[1]고객 추가 [2]고객 삭제 [3]취소 : ");
                            int csinsdelSel = sc.nextInt();
                            if (csinsdelSel == 1) {
                                System.out.println("[고객 추가]");
                                System.out.print("고객 이름 : ");
                                String customerName = sc.next();
                                System.out.print("고객 연락처 : ");
                                String customerPhone = sc.next();
                                customerdao.customerInsert(customerName, customerPhone);
                                break;
                            } else if (csinsdelSel == 2) {
                                System.out.println("[고객 삭제]");
                                System.out.print("고객 이름 : ");
                                String customerDeleteName = sc.next();
                                customerdao.customerDelete(customerDeleteName);
                                break;
                            } else if (csinsdelSel == 3) break;
                        } else if (csSel == 3) {
                            System.out.println("[고객 정보 조회]");
                            System.out.print("고객 이름 : ");
                            String customerName = sc.next();
                            System.out.println("-----------------");
                            System.out.println("["+customerName+"님 조회]");
                            System.out.println("-----------------");
                            customerdao.customerInfo(customerName);

                            break;
                        }
                    }
                    break;
                case 2:
                    while (sales) {
                        System.out.print("[1]주문내역 [2]일일매출 [3]월 매출 [4]판매량 [5]취소 : ");
                        int saleSel = sc.nextInt();
                        if (saleSel == 1) {
                            List<OrderVO> list = orderdao.OrderList();
                            orderdao.cafeOrderListPrint(list);
                            break;
                        } else if (saleSel == 2) {
                            System.out.println("[일일 매출]");
                            System.out.println("---------------");
                            orderdao.dailySales();
                            break;
                        } else if (saleSel == 3) {
                            System.out.println("[월 매출]");
                            System.out.println("-----------");
                            orderdao.monthSales();
                            break;
                        } else if (saleSel == 4) {
                            System.out.println("[판매량 인기 순위]");
                            System.out.println("-----------------");
                            orderdao.rankOrder();
                            break;
                        } else if(saleSel == 5) break;
                    }
                    break;
                case 3:
                    while (menuinsdel) {
                        System.out.print("[1]메뉴 추가 [2]메뉴 삭제 [3]나가기 : ");
                        int insertsel = sc.nextInt();
                        switch (insertsel) {
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
