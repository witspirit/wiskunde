package be.witspirit.wiskunde.ggd;

import java.util.ArrayList;
import java.util.List;

public class MathSupport {

    private static final List<Integer> primes = List.of(2, 3, 5, 7, 11, 13, 17); // ... limited set of primes for now

    public static List<Integer> primeComponents(int number) {
        List<Integer> components = new ArrayList<>();

        // Look for the largest prime that is smaller or equal than number
        int largestPrime = largestDivisiblePrime(number);

        if (largestPrime > 1) {
            components.add(largestPrime);
            components.addAll(primeComponents(number / largestPrime));
        }
        return components;
    }

    public static int largestDivisiblePrime(int number) {
        return primes.stream()
                .filter(prime -> prime <= number)
                .filter(prime -> number % prime == 0)
                .max(Integer::compareTo)
                .orElse(1);
    }
}
