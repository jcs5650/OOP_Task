package main.menu;

public class MenuItem {
    String name;
    Integer price;

    public MenuItem(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
