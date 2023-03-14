package com.cafeDB.dao;

import com.cafeDB.util.CafeCommon;
import com.cafeDB.vo.FavoriteMenuVO;
import com.cafeDB.vo.MenuVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FavoriteMenuDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    public List<FavoriteMenuVO> favoriteMenuSelect() {
        List<FavoriteMenuVO> list = new ArrayList<>();
        try {
            conn = CafeCommon.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM FAVORITE_MENU ORDER BY MENU_COUNT DESC";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String me_name = rs.getString("MENU_NAME");
                int me_cnt = rs.getInt("MENU_COUNT");
                FavoriteMenuVO vo = new FavoriteMenuVO(me_name, me_cnt);
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
    public void favoriteMenuSelectPrint(List<FavoriteMenuVO> list) {
        for (FavoriteMenuVO e : list) {
            System.out.println("메뉴이름 : " + e.getMenuName());
            System.out.println("판매량 : " + e.getCnt());
            System.out.println("-----------------------------");
        }
    }
}