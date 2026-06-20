import java.util.Map;

public class ForecastCalculator {

    public static double forecastValue(double principal,double growthRate,int years) {
        if (years == 0) {
            return principal;
        }
        return forecastValue(principal,growthRate,years-1)*(1 +growthRate);
    }

    public static long forecastNaive(int period) {
        if (period <= 1) {
            return period;
        }
        return forecastNaive(period-1)+forecastNaive(period-2);
    }

    public static long forecastMemoized(int period,Map<Integer,Long>cache) {

        if (period <= 1) {
            return period;
        }
        if (cache.containsKey(period)) {
            return cache.get(period);
        }
        long result = forecastMemoized(period-1,cache)+forecastMemoized(period-2,cache);
        cache.put(period, result);
        return result;
    }
}