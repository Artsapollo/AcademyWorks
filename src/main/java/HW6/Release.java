package HW6;

public class Release {
    public static void main(String[] args) {
        Assets goldRush = new Gold(100000);
        Assets topSecurities = new Securities(2000);
        Assets hotStocks = new Stocks(30000);

        System.out.println(goldRush);
        System.out.println(topSecurities);
        System.out.println(hotStocks);

        System.out.println();

        Bank<Assets> mainBank = new Bank<Assets>();

        mainBank.commingOut("GloriousTrust", goldRush);
        mainBank.commingOut("GloriousTrust", hotStocks);
        mainBank.commingOut("GloriousTrust", topSecurities);
    }
}
