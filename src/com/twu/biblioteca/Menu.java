package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    HashMap<Integer, MenuOperations> map = new HashMap<Integer, MenuOperations>();
    ArrayList<String> menuList = new ArrayList<String>();

    public Menu(Books books) {
        map.put(1, books);
        map.put(2, new Quit());
        map.put(3, new CheckOut());
        menuList.add("1 : List Of Books");
        menuList.add("2 : Quit");
        menuList.add("3 : Checkout Book");
    }


    public String displayMenuOptions() {
        String displayMenu = "";
        for (int i = 0; i < menuList.size(); i++) {
            displayMenu = displayMenu + menuList.get(i) + System.lineSeparator();
        }
        return displayMenu;
    }


    public String computeMenuOption(int optionNumber) {
        if (optionNumber > menuList.size() || optionNumber <= 0)
            return "Select a valid option!";
        Object object;
        object = map.get(optionNumber);
        return object.toString();
    }
}
