package com.cafeDB.vo;


public class FavoriteMenuVO {
    private String menuName;
    private int cnt;

    public FavoriteMenuVO(String menuName, int cnt) {
        this.menuName = menuName;
        this.cnt = cnt;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}