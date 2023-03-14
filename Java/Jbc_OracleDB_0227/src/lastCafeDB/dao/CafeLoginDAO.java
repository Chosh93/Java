package lastCafeDB.dao;

import java.util.Scanner;

public class CafeLoginDAO {
    Scanner sc = new Scanner(System.in);
    public int login(){
        System.out.print("아이디 : ");
        String adminId = sc.next();
        System.out.print("비밀번호 : ");
        String adminPw = sc.next();
        if(adminId.equals("admin")){
            if(adminPw.equals("admin")){
                System.out.println("관리자모드 로그인 성공");
                return 1;
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
                return 3;
            }
        } else if(adminId.equals("customer")){
            if(adminPw.equals("customer")){
                System.out.println("고객모드 로그인 성공");
                return 2;
            }
        } else
            System.out.println("아이디가 틀렸습니다.");
            return 4;
    }
}
