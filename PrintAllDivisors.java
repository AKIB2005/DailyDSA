import java.util.List;
import java.util.ArrayList;

public class PrintAllDivisors {
    public static List<Integer> printDivisors(int n) {

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }
}