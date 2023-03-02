package cafeDB.vo;

public class CoffeeMenuVO {
    private int coffeeMenuId;
    private String coffeeMenuName;
    private int coffeeMenuPrice;
    private String coffeeMenuCategory;

    public CoffeeMenuVO(int coffeeMenuId, String coffeeMenuName, int coffeeMenuPrice, String coffeeMenuCategory) {
        this.coffeeMenuId = coffeeMenuId;
        this.coffeeMenuName = coffeeMenuName;
        this.coffeeMenuPrice = coffeeMenuPrice;
        this.coffeeMenuCategory = coffeeMenuCategory;
    }

    public int getCoffeeMenuId() {
        return coffeeMenuId;
    }

    public void setCoffeeMenuId(int coffeeMenuId) {
        this.coffeeMenuId = coffeeMenuId;
    }

    public String getCoffeeMenuName() {
        return coffeeMenuName;
    }

    public void setCoffeeMenuName(String coffeeMenuName) {
        this.coffeeMenuName = coffeeMenuName;
    }

    public int getCoffeeMenuPrice() {
        return coffeeMenuPrice;
    }

    public void setCoffeeMenuPrice(int coffeeMenuPrice) {
        this.coffeeMenuPrice = coffeeMenuPrice;
    }

    public String getCoffeeMenuCategory() {
        return coffeeMenuCategory;
    }

    public void setCoffeeMenuCategory(String coffeeMenuCategory) {
        this.coffeeMenuCategory = coffeeMenuCategory;
    }
}