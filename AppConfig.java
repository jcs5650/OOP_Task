package main;

import main.account.AccountRepository;
import main.account.MemoryAccountRepository;
import main.menu.MemoryMenuRepository;
import main.menu.MenuRepository;
import main.restaurant.MemoryRestaurantRepository;
import main.restaurant.RestaurantRepository;
import main.service.MainService;
import main.time.TimePolicy;
import main.time.TimePolicyBasic;

public class AppConfig {
    private static AppConfig appConfig = new AppConfig();

    private AppConfig() {}

    public static AppConfig getInstance() {
        return appConfig;
    }

    public MainService mainService() {
        return MainService.getInstance();
    }

    public TimePolicy getTimePolicy() {
        return TimePolicyBasic.getInstance();
    }

    public AccountRepository getAccountRepository() {
        return MemoryAccountRepository.getInstance();
    }

    public MenuRepository getMenuRepository() {
        return MemoryMenuRepository.getInstance();
    }

    public RestaurantRepository getRestaurantRepository() {
        return MemoryRestaurantRepository.getInstance();
    }


}
