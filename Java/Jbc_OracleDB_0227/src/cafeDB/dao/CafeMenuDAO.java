package cafeDB.dao;

import cafeDB.util.CafeCommon;
import cafeDB.vo.CafeMenuVO;
import com.kh.jdbc.vo.EmpVO;

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
            String query = "SELECT * FROM COFFEE_MENU";
            rset = stmt.executeQuery(query);

            while(rset.next()){
                int cafeMenuNo = rset.getInt("COFFEE_ID");
                String cafeMenuName = rset.getString("COFFEE_NAME");
                int cafeMenuPrice = rset.getInt("COFFEE_PRICE");
                String cafeMenuCategory = rset.getString("COFFEE_CATEGORY");
                CafeMenuVO vo = new CafeMenuVO(cafeMenuNo, cafeMenuName, cafeMenuPrice, cafeMenuCategory);
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
        for(CafeMenuVO e : list){
            System.out.println("번호 : " + e.getCafeMenuNo());
            System.out.println("이름 : " + e.getCafeMenuName());
            System.out.println("가격 : " + e.getCafeMenuPrice());
            System.out.println("카테고리 : " + e.getCafeMenuCategory());
            System.out.println("--------------------------------------------");
        }
    }
    public void cafeCategorySelect(){
        int cateNum = sc.nextInt();
        String query = "SELECT";
    }
    public void cafeMenuInsert() {
        System.out.println("추가할 카페 메뉴를 입력 하세요.");
        System.out.print("메뉴 이름 : ");
        String cafeMenuName = sc.next();
        System.out.print("메뉴 가격 : ");
        int cafeMenuPrice = sc.nextInt();
        System.out.print("메뉴 카테고리 : ");
        String cafeMenuCategory = sc.next();

        String query = "INSERT INTO COFFEE_MENU(COFFEE_ID, COFFEE_NAME, COFFEE_PRICE, COFFEE_CATEGORY) VALUES("
                + "CATEGORY_SEQ.NEXTVAL" + ", " + "'" + cafeMenuName + "'" + ", " + cafeMenuPrice +
                ", " + "'" + cafeMenuCategory + "'" + ")";
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            int rst = stmt.executeUpdate(query);
            System.out.println("Return : " + rst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CafeCommon.close(stmt);
        CafeCommon.close(conn);
    }
}
