import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        double principal = 10000;
        double growthRate = 0.08;

        System.out.println("Financial Forecast");
        for (int year = 0; year <= 5; year++) {
            double amount = ForecastCalculator.forecastValue(principal,growthRate,year);

            System.out.printf("Year %d : %.2f%n",year,amount);
        }
        System.out.println();
        int period = 40;
        long start = System.nanoTime();
        long naiveResult=ForecastCalculator.forecastNaive(period);
        long naiveTime =(System.nanoTime()-start)/1_000_000;
        start = System.nanoTime();
        long memoizedResult = ForecastCalculator.forecastMemoized(period,new HashMap<>());

        long memoizedTime =(System.nanoTime()-start)/1_000_000;

        System.out.println("Naive Result    : " +naiveResult);
        System.out.println("Naive Time      : " +naiveTime+" ms");

        System.out.println();

        System.out.println("Memoized Result : " +memoizedResult);
        System.out.println("Memoized Time   : " +memoizedTime +" ms");
    }
}