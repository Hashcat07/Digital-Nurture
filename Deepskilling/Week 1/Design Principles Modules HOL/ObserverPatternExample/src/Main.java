public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer ravi  = new MobileApp("Ray");
        Observer meena = new MobileApp("Ragul");

        market.registerObserver(ravi);
        market.registerObserver(meena);

        market.setStockPrice("Tesla", 3850.50);

        market.deregisterObserver(meena);

        System.out.println("---- After Meena unsubscribes ----");
        market.setStockPrice("Tesla", 3902.75);
    }
}