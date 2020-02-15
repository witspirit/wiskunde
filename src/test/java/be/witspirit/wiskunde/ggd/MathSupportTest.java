package be.witspirit.wiskunde.ggd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MathSupportTest {

    @ParameterizedTest(name = "{0} => {1}")
    @CsvSource({
            "1, ''",
            "2, '2'",
            "3, '3'",
            "4, '2, 2'",
            "5, '5'",
            "6, '3, 2'",
            "7, '7'",
            "8, '2, 2, 2'",
            "9, '3, 3'",
            "10, '5, 2'",
            "11, '11'",
            "12, '3, 2, 2'",
            "378, '7, 3, 3, 3, 2'"
    })
    public void primeComponents(int value, @ConvertWith(IntListConverter.class) List<Integer> components) {
        assertThat(MathSupport.primeComponents(value)).isEqualTo(components);
    }

    @ParameterizedTest(name = "Largest divisable prime of {0} is {1}")
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
            "4, 2",
            "5, 5",
            "6, 3",
            "7, 7",
            "8, 2",
            "9, 3",
            "10, 5"
    })
    public void largestDivisablePrime(int value, int largestPrime) {
        assertThat(MathSupport.largestDivisiblePrime(value)).isEqualTo(largestPrime);
    }

    private static class IntListConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            String numberString = (String) o;
            String[] stringComponents = numberString.split(",");
            return Stream.of(stringComponents)
                    .map(String::trim)
                    .filter(Predicate.not(String::isEmpty))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        }
    }

}
