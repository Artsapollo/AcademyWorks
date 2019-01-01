package HW6;

public class Release {
    public static void main(String[] args) {
        Gold goldRush = new Gold(100000);
        Securities topSecurities = new Securities(2000);
        Stocks hotStocks = new Stocks(30000);

        Bank<Assets> mainBank = new Bank<Assets>("GTB");
        mainBank.add(goldRush);
        mainBank.add(topSecurities);
        mainBank.add(hotStocks);

        for(Assets as : mainBank){
            System.out.println("Bank keeps "+ as.getQuantity()+ " in " + as.getName());
        }

        System.out.println();

        mainBank.commingOut("GTB", goldRush);
        mainBank.commingOut("GTB", hotStocks);
        mainBank.commingOut("GTB", topSecurities);

    }
}
