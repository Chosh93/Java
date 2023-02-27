package cafeDB;

import cafeDB.dao.CafeMenuDAO;
import cafeDB.vo.CafeCategoryVO;
import cafeDB.vo.CafeMenuVO;

import java.util.List;
import java.util.Scanner;

public class cafeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CafeMenuDAO dao = new CafeMenuDAO();
        while (true) {
            System.out.println("======== [EMP TABLE Command] =======");
            System.out.println("메뉴를 선택 하세요 : ");
            System.out.print("[1]SELECT, [2]INSERT, [3]UPDATE, [4]DELETE, [5]EXIT : ");
            int sel = sc.nextInt();
            int category = sc.nextInt();
            switch (sel){
                case 1:
                    System.out.println("[1]커피, [2]에이드, [3]디저트, [4]취소");
                    switch (category) {
                        case 1:

                        case 2:
                        case 3:
                    }
                    List<CafeMenuVO> list = dao.cafeMenuSelect();
                    dao.cafeMenuSelectPrint(list);
                    break;
                case 2:
                    dao.cafeMenuInsert();
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("메뉴를 종료");
                    return;
            }
        }
    }
}