package HW6;

import java.util.ArrayList;

public class Bank <T> extends ArrayList<T> {
    private String name;

    public Bank(String name){
        this.name = name;
    }

    public <T> void commingOut(String name, T asset){
        System.out.println("Bank " + name +" is selling "+ asset.getClass()+ " for free");
    }
}
