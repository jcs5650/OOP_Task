package main.menu;

import main.restaurant.Restaurant;

public interface MenuRepository {
    void save(Menu menu);
    Menu findMenu(String restaurantName, Selling selling);
}
