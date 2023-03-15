package lastCafeDB.dao;

import lastCafeDB.util.CafeCommon;
import lastCafeDB.vo.CafeBasketVO;
import lastCafeDB.vo.CafeCustomerVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeCustomerDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    public List<CafeCustomerVO> customerSelect() {
        List<CafeCustomerVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CAFE_CUSTOMER ORDER BY CUSTOMER_ID";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int customerId = rs.getInt("CUSTOMER_ID");
                String customerName = rs.getString("CUSTOMER_NAME");
                String customerPhone = rs.getString("CUSTOMER_PHONE");
                int customerMil = rs.getInt("CUSTOMER_MIL");
                CafeCustomerVO vo = new CafeCustomerVO(customerId, customerName, customerPhone, customerMil);
                list.add(vo);
            }
            CafeCommon.close(rs);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void customerSelectPrint(List<CafeCustomerVO> list) {
        System.out.println("-----------------------------");
        for (CafeCustomerVO e : list) {
            System.out.println("고객 번호 : " + e.getCustomerId());
            System.out.println("고객 이름 : " + e.getCustomerName());
            System.out.println("고객 연락처 : " + e.getCustomerPhone());
            System.out.println("고객 마일리지 : " + e.getCustomerMil());
            System.out.println("-----------------------------");
        }
    }
}
