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
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    Scanner sc = new Scanner(System.in);

    public List<CafeCategoryVO> cafeCategorySelect(){
        List<CafeCategoryVO> categorylist = new ArrayList<>();
        try{
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM CATEGORY";
            rset = stmt.executeQuery(query);
            while(rset.next()){
                int sequenceNum = rset.getInt("CATEGORY_ID");
                String cafeMenuCategory = rset.getString("CATEGORY_NAME");
                CafeCategoryVO catvo = new CafeCategoryVO(sequenceNum, cafeMenuCategory);
                categorylist.add(catvo);
            }
            CafeCommon.close(rset);
            CafeCommon.close(stmt);
            CafeCommon.close(conn);
        } catch (Exception e){
            e.printStackTrace();
        }
        return categorylist;
    }
    public void cafeCategorySelectPrint(List<CafeCategoryVO> list){
        for(CafeCategoryVO e : list){
            System.out.println(e.getCategoryNo() + ". " + e.getCategoryName());
        }
    }

}