package main;

public class Main {
    public static void main(String[] args) {
        OrderFacade mainService = new OrderFacade();

        mainService.setData();
        mainService.startOrder();

    }
}
