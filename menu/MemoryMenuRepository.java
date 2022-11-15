package main.menu;

import main.AppConfig;
import main.restaurant.Restaurant;
import main.time.TimePolicy;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MemoryMenuRepository implements MenuRepository {

    private static MemoryMenuRepository memoryMenuRepository = new MemoryMenuRepository();

    private final TimePolicy timePolicy = AppConfig.getInstance().getTimePolicy();

    private MemoryMenuRepository() {}

    private static final List<Menu> store = new ArrayList<>();

    public static MemoryMenuRepository getInstance() {
        return memoryMenuRepository;
    }

    @Override
    public void save(Menu menu) {
        store.add(menu);
    }

    @Override
    public Menu findMenu(String restaurantName, Selling selling) {
        return store.stream().filter(s -> s.getRestaurant().getName().equals(restaurantName)
                        && s.getSelling().equals(selling))
                        .findFirst().orElseThrow(() -> new IllegalStateException("존재하지 않습니다."));
    }
}
