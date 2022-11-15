package main.menu;

import main.restaurant.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Menu {
    private static Integer itemId = 0;
    private Restaurant restaurant;
    private Selling selling;
    private Map<Integer, MenuItem> items = new HashMap<>();

    public Menu(Restaurant restaurant, Selling selling, MenuItem... menuItems) {
        this.restaurant = restaurant;
        this.selling = selling;
        for (MenuItem menuItem : menuItems) {
            this.itemId++;
            this.items.put(itemId, menuItem);
        }
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Selling getSelling() {
        return selling;
    }

    public Integer fee(List<Integer> orderNum) {
        Integer fee = 0;

        for (Integer num : orderNum) {
            fee = fee + items.get(num).getPrice();
        }
        return fee;
    }

    /***
     * 화면 표시 메서드
     */
    public void showItems() {
        for (Map.Entry<Integer, MenuItem> itemEntry : items.entrySet()) {
            Integer key = itemEntry.getKey();
            MenuItem item = itemEntry.getValue();

            System.out.println( key + " : " + item.getName() + '-' + item.getPrice() + "원");
        }
    }
}
