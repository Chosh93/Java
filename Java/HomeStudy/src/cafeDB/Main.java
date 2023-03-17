package cafeDB;

import cafeDB.dao.MenuDAO;
import cafeDB.vo.MenuVO;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Method method = new Method();
        while(true){
            System.out.println("======================== Cafe ========================");
            System.out.println("[1]고객모드 [2]관리자모드 [3]종료");
            System.out.print(">>> : ");
            int sel = sc.nextInt();
            switch(sel){
                case 1:
                    method.customerMode();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.printf("키오스크를 종료합니다.");
                    System.exit(0);
                    break;
            }
        }
    }
}

