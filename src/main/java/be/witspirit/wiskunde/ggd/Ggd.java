package be.witspirit.wiskunde.ggd;

import java.util.ArrayList;
import java.util.List;

public class Ggd {
    public static int euclides(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return euclides(b, a % b);
        }
    }



    public static int priem(int a, int b) {
        List<Integer> aPrimes = MathSupport.primeComponents(a);
        List<Integer> bPrimes = MathSupport.primeComponents(b);

        // Find longest combination of primes
        System.out.println(aPrimes);
        System.out.println(bPrimes);

        List<Integer> commonPrimes = new ArrayList<>();
        for (Integer aPrime : aPrimes) {
            if (bPrimes.contains(aPrime)) {
                commonPrimes.add(aPrime);
                bPrimes.remove(aPrime);
            }
        }

        System.out.println("Common Primes = "+commonPrimes);

        return commonPrimes.stream().reduce(1, (val1, val2) -> val1*val2);
    }

}
