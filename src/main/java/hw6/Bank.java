package hw6;

public class Bank <T extends Assets> {
    private String name;

    public void commingOut(String name, T asset){
        System.out.println("Bank " + name +" is selling "+ asset.getName()+ " for free");
    }
}
