package cafeDB;
import cafeDB.dao.CafeCategoryDAO;
import cafeDB.dao.CafeMenuDAO;
import cafeDB.vo.CafeCategoryVO;
import cafeDB.vo.CafeMenuVO;
import java.util.List;
import java.util.Scanner;
public class cafeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CafeMenuDAO menudao = new CafeMenuDAO();
        CafeCategoryDAO categorydao = new CafeCategoryDAO();
        while (true) {
            System.out.println("메뉴를 선택 하세요 : ");
            System.out.print("[1]메뉴 보기, [2]메뉴 추가, [3]메뉴 삭제, [4]매출 보기, [5]고객 전용, [6]EXIT : ");
            int sel = sc.nextInt();
            switch (sel){
                case 1:
                    List<CafeMenuVO> list = menudao.cafeMenuSelect();
                    menudao.cafeMenuSelectPrint(list);
                    break;
                case 2:
                    menudao.cafeMenuInsert();
                    break;
                case 3:
                    menudao.cafeMenuDelete();
                    break;
                case 4:
                case 5:
                case 6:
                    System.out.println("메뉴를 종료");
                    return;
            }
        }
    }
}