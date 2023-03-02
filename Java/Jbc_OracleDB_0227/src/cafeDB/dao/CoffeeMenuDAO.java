/*
관리자                                 고객
'메뉴 전체 보기'                      '메뉴 전체 보기'
'메뉴 추가 하기'                      '카테고리 별 메뉴 확인 하기'
'메뉴 삭제 하기'                      '주문 바구니에 담기'
'매출 확인 하기'                      '주문 시 결제 방법 선택하기'
                                    '마일리지 적립할 전화 번호 입력'
                                    '결제 후 적립 마일리지 확인하기'
 */
package cafeDB.dao;
import cafeDB.util.CafeCommon;
import cafeDB.vo.CoffeeMenuVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CoffeeMenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);
    public List<CoffeeMenuVO> coffeeMenuSelect() {
        List<CoffeeMenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM COFFEE_MENU";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                int coffeeMenuId = rset.getInt("MENU_ID");
                String coffeeMenuName = rset.getString("MENU_NAME");
                int coffeeMenuPrice = rset.getInt("MENU_PRICE");
                String coffeeMenuCategory = rset.getString("MENU_CATEGORY");
                CoffeeMenuVO vo = new CoffeeMenuVO(coffeeMenuId, coffeeMenuName, coffeeMenuPrice, coffeeMenuCategory);
                list.add(vo);
            }
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void coffeeMenuSelectPrint(List<CoffeeMenuVO> list){
        for(CoffeeMenuVO e : list){
            System.out.println("번호 : " + e.getCoffeeMenuId());
            System.out.println("이름 : " + e.getCoffeeMenuName());
            System.out.println("가격 : " + e.getCoffeeMenuPrice());
            System.out.println("카테고리 : " + e.getCoffeeMenuCategory());
            System.out.println("--------------------------------------------");
        }
    }
    public void coffeeMenuInsert() {
        System.out.println("추가할 카페 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String coffeeMenuName = sc.next();
        System.out.print("메뉴 가격 : ");
        int coffeeMenuPrice = sc.nextInt();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO COFFEE_MENU(MENU_ID, MENU_NAME, MENU_PRICE, MENU_CATEGORY) VALUES((SELECT NVL(MAX(MENU_ID),0)+1 FROM COFFEE_MENU), '" +coffeeMenuName + "', " + coffeeMenuPrice + ", " + "'COFFEE')";
            rset = stmt.executeQuery(query);
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void coffeMenuDelete() {
        System.out.println("삭제할 카페 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String coffeeMenuName = sc.next();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM COFFEE_MENU WHERE MENU_NAME = " + "'" + coffeeMenuName + "'";
            rset = stmt.executeQuery(query);
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void coffeeMenuUpdate() {
        System.out.println("변경할 내용 : [1]메뉴이름변경, [2]메뉴가격변경");
        int updatesel = sc.nextInt();
        switch(updatesel){
            case 1:
                System.out.print("변경 전 메뉴 이름 : ");
                String coffeeMenuBeforeName = sc.next();
                System.out.print("변경 후 메뉴 이름 : ");
                String coffeeMenuAfterName = sc.next();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String query = "UPDATE COFFEE_MENU SET MENU_NAME = '" + coffeeMenuAfterName + "'" + " WHERE MENU_NAME = " + "'" + coffeeMenuBeforeName + "'";
                    rset = stmt.executeQuery(query);
                    CafeCommon.close(rset);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                } break;
            case 2:
                System.out.print("변경할 메뉴 이름 : ");
                String coffeeMenuName_Price = sc.next();
                System.out.print("변경 후 메뉴 가격 : ");
                int coffeeMenuAfterPrice = sc.nextInt();
                try {
                    conn = CafeCommon.getConnection();
                    stmt = conn.createStatement();
                    String query = "UPDATE COFFEE_MENU SET MENU_PRICE = " + "'" + coffeeMenuAfterPrice + "'" + " WHERE MENU_NAME = " + "'" + coffeeMenuName_Price + "'";
                    rset = stmt.executeQuery(query);
                    CafeCommon.close(rset);
                    CafeCommon.close(stmt);
                    CafeCommon.close(conn);
                } catch (Exception e) {
                    e.printStackTrace();
                } break;

        }
    }
}