package main.restaurant;

import java.util.ArrayList;
import java.util.List;

public class MemoryRestaurantRepository implements RestaurantRepository{
    private static MemoryRestaurantRepository memoryRestaurantRepository = new MemoryRestaurantRepository();

    private MemoryRestaurantRepository() {
    }

    public static MemoryRestaurantRepository getInstance() {
        return memoryRestaurantRepository;
    }

    private static List<Restaurant> store = new ArrayList<>();

    @Override
    public void save(Restaurant restaurant) {
        store.add(restaurant);
    }

    /***
     * 화면 표시 메서드
     */
    @Override
    public void findAllRestaurant() {
        for (Restaurant restaurant : store) {
            System.out.println("식당 리스트 : " + restaurant.getName());
        }
    }


}
