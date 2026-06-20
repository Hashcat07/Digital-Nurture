public class MobileApp implements Observer{
    private final String appUser;

    public MobileApp(String appUser){
        this.appUser=appUser;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(appUser+" notified: "+stockName+" is now: "+price);
    }
}
