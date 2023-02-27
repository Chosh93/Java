package cafeDB.dao;

import cafeDB.util.CafeCommon;
import cafeDB.vo.CafeCategoryVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeCategoryDAO {
    Connection conn = null; // 자바와 오라클에 대한 연결 설정
    Statement stmt = null; // SQL문을 수행하기 위한 객체
    ResultSet rset = null; // statement 동작에 대한 결과로 전달되는 db의 내용
    Scanner sc = new Scanner(System.in);

    public List<CafeCategoryVO> cafeCategorySelect() {
        List<CafeCategoryVO> list = new ArrayList<>(); // 반환할 리스트를 위해 객체 생성
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM CATEGORY";
            rset = stmt.executeQuery(query); // select 문과 같이 여러개의 레코드(행)로 결과가 반환 될 때 사용

            while (rset.next()) { // 읽을 행이 있으면 참
                int categoryIdNo = rset.getInt("CATEGORY_ID");
                String categoryName = rset.getString("CATEGORY_NAME");
                CafeCategoryVO vo = new CafeCategoryVO(categoryIdNo, categoryName); // 하나의 행
                list.add(vo);
            }
            CafeCommon.close(rset); // 연결과 역순으로 해제
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void empSelectPrint(List<CafeCategoryVO> list) {
        for (CafeCategoryVO e : list) {
            System.out.println("--------------------------------------------");
            System.out.println("카테고리 번호 : " + e.getCategoryNo());
            System.out.println("카테고리 이름 : " + e.getCategoryName());
            System.out.println("--------------------------------------------");
        }
    }

    public void empInsert() {
        System.out.println("카테고리 정보를 입력하세요.");
        System.out.print("카테고리 이름 : ");
        String categoryName = sc.next();

        String query = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY_NAME) VALUES("
                + "CATEGORY_SEQ.NEXTVAL" + ", " + "'" + categoryName + "'" + ")";

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
