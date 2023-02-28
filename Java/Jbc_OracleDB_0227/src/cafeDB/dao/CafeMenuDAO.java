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
import cafeDB.vo.CafeMenuVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CafeMenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);
    public List<CafeMenuVO> cafeMenuSelect() {
        List<CafeMenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT ROWNUM AS ID, C.* FROM(SELECT * FROM CAFE_MENU ORDER BY DECODE(CAFE_MENU_CATEGORY, 'COFFEE', 1, 'ADE', 2, 'DESSERT', 3), CAFE_MENU_PRICE ASC) C";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                String cafeMenuName = rset.getString("CAFE_MENU_NAME");
                int cafeMenuPrice = rset.getInt("CAFE_MENU_PRICE");
                String cafeMenuCategory = rset.getString("CAFE_MENU_CATEGORY");
                CafeMenuVO vo = new CafeMenuVO(cafeMenuName, cafeMenuPrice, cafeMenuCategory);
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

    public void cafeMenuSelectPrint(List<CafeMenuVO> list){
        int i = 1;
        for(CafeMenuVO e : list){
            System.out.println("번호 : " + i);
            System.out.println("이름 : " + e.getCafeMenuName());
            System.out.println("가격 : " + e.getCafeMenuPrice());
            System.out.println("카테고리 : " + e.getCafeMenuCategory());
            System.out.println("--------------------------------------------");
            i++;
        }
    }
    public void cafeCategorySelect(){
        int cateNum = sc.nextInt();
        String query = "SELECT CAFE_MENU_NAME, CAFE_MENU_PRICE";
    }
    public void cafeMenuInsert() {
        System.out.println("추가할 카페 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String cafeMenuName = sc.next();
        System.out.print("메뉴 가격 : ");
        int cafeMenuPrice = sc.nextInt();
        System.out.print("메뉴 카테고리 : ");
        String cafeMenuCategory = sc.next();

        String query = "INSERT INTO CAFE_MENU(CAFE_MENU_NAME, CAFE_MENU_PRICE, CAFE_MENU_CATEGORY) VALUES("
               + "'" + cafeMenuName + "'" + ", " + cafeMenuPrice +
                ", " + "'" + cafeMenuCategory + "'" + ")";
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            int rst = stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CafeCommon.close(stmt);
        CafeCommon.close(conn);
    }
    public void cafeMenuDelete() {
        System.out.println("추가할 카페 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String cafeMenuName = sc.next();
        String query = "DELETE FROM CAFE_MENU WHERE CAFE_MENU_NAME = " + "'" + cafeMenuName + "'";
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            int rst = stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CafeCommon.close(stmt);
        CafeCommon.close(conn);
    }
}
