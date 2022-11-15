package main;

import main.account.Account;
import main.account.AccountRepository;
import main.menu.Menu;
import main.menu.MenuItem;
import main.menu.MenuRepository;
import main.menu.Selling;
import main.restaurant.Restaurant;
import main.restaurant.RestaurantRepository;
import main.service.MainService;
import main.time.TimePolicy;

import java.time.LocalTime;
import java.util.List;

public class OrderFacade {
    private final AppConfig appConfig = AppConfig.getInstance();
    private final AccountRepository accountRepository = appConfig.getAccountRepository();
    private final MenuRepository menuRepository = appConfig.getMenuRepository();
    private final RestaurantRepository restaurantRepository = appConfig.getRestaurantRepository();
    private final TimePolicy timePolicy = appConfig.getTimePolicy();

    public void startOrder() {

        MainService mainService = MainService.getInstance();

        AppConfig appConfig = AppConfig.getInstance();
        AccountRepository accountRepository = appConfig.getAccountRepository();
        MenuRepository menuRepository = appConfig.getMenuRepository();
        RestaurantRepository restaurantRepository = appConfig.getRestaurantRepository();

        // 유저 저장
        Account account = mainService.setAccount();
        accountRepository.save(account);

        // 식당 표시
        System.out.println("식당 리스트를 출력합니다.");
        restaurantRepository.findAllRestaurant();

        // 식당 선택
        System.out.print("식당을 선택해주세요 : ");
        String restaurantName = mainService.setRestaurantName();

        System.out.println("선택한 식당에 현재 시각에 판매 중인 메뉴를 출력합니다.");
        Menu menu = menuRepository.findMenu(restaurantName, timePolicy.calculateSellingTime(LocalTime.now()));
        menu.showItems();

        System.out.print("메뉴를 숫자로 선택하세요 ex) 1,2 : ");
        List<Integer> orderNumber = mainService.getMenuList();

        Integer totalPrice = menu.fee(orderNumber);
        System.out.println(totalPrice + "원 결제되었습니다.");

        mainService.closeScanner();
    }

    public void setData() {
        Account accountA = new Account("Manx");
        Account accountB = new Account("MingMing");
        accountRepository.save(accountA);
        accountRepository.save(accountB);

        Restaurant restaurantA = new Restaurant("A");
        Restaurant restaurantB = new Restaurant("B");
        Restaurant restaurantC = new Restaurant("C");
        restaurantRepository.save(restaurantA);
        restaurantRepository.save(restaurantB);
        restaurantRepository.save(restaurantC);

        MenuItem menuItem1 = new MenuItem("밥",1000);
        MenuItem menuItem2 = new MenuItem("된장국", 5000);
        MenuItem menuItem3 = new MenuItem("삼겹살", 10000);
        MenuItem menuItem4 = new MenuItem("돈까스", 8000);
        MenuItem menuItem5 = new MenuItem("김",1000);
        MenuItem menuItem6 = new MenuItem("우동", 8000);
        MenuItem menuItem7 = new MenuItem("치즈라면", 6500);
        MenuItem menuItem8 = new MenuItem("라면", 6000);
        MenuItem menuItem9 = new MenuItem("소고기", 15000);
        MenuItem menuItem10 = new MenuItem("육회", 12000);
        MenuItem menuItem11 = new MenuItem("오리", 8000);

        Menu AMenu1 = new Menu(restaurantA, Selling.MORNING, menuItem1);
        Menu AMenu2 = new Menu(restaurantA, Selling.LUNCH, menuItem2, menuItem3);
        Menu AMenu3 = new Menu(restaurantA, Selling.DINNER, menuItem4);
        Menu BMenu1 = new Menu(restaurantB, Selling.MORNING, menuItem5);
        Menu BMenu2 = new Menu(restaurantB, Selling.LUNCH, menuItem6);
        Menu BMenu3 = new Menu(restaurantB, Selling.DINNER, menuItem8, menuItem9);
        Menu CMenu1 = new Menu(restaurantC, Selling.MORNING, menuItem7);
        Menu CMenu2 = new Menu(restaurantC, Selling.LUNCH, menuItem10);
        Menu CMenu3 = new Menu(restaurantC, Selling.DINNER, menuItem11);
        menuRepository.save(AMenu1);
        menuRepository.save(AMenu2);
        menuRepository.save(AMenu3);
        menuRepository.save(BMenu1);
        menuRepository.save(BMenu2);
        menuRepository.save(BMenu3);
        menuRepository.save(CMenu1);
        menuRepository.save(CMenu2);
        menuRepository.save(CMenu3);
    }

}
