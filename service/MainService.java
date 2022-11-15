package main.service;

import main.AppConfig;
import main.account.Account;
import main.account.AccountRepository;
import main.menu.*;
import main.restaurant.Restaurant;
import main.restaurant.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainService {
    private static MainService mainServiceBasic = new MainService();

    /**
     * Memory Data 추가
     */


    private Scanner s = new Scanner(System.in);

    private MainService() {

    }

    public static MainService getInstance() {
        return mainServiceBasic;
    }

    public String setRestaurantName() {
        String restaurantName = s.next();
        return restaurantName;
    }

    public Account setAccount() {
        System.out.print("유저 이름을 입력해주세요 : ");
        return new Account(s.next());
    }


    public List<Integer> getMenuList() {
        List<Integer> menuList = new ArrayList<>();
        String[] orderInputs = s.next().split(",");
        for (String oi : orderInputs) {
            menuList.add(Integer.parseInt(oi));
        }

        return menuList;
    }

    public void closeScanner() {
        s.close();
    }
}
