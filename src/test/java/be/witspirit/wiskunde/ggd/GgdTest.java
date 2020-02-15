package be.witspirit.wiskunde.ggd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GgdTest {

    @ParameterizedTest(name = "ggd({0}, {1}) = {2}")
    @CsvFileSource(resources = "/ggd_samples.csv", numLinesToSkip = 1)
    public void euclides(int a, int b, int ggd) {
        assertThat(Ggd.euclides(a,b)).isEqualTo(ggd);
    }

    @ParameterizedTest(name = "ggd({0}, {1}) = {2}")
    @CsvFileSource(resources = "/ggd_samples.csv", numLinesToSkip = 1)
    public void primes(int a, int b, int ggd) {
        assertThat(Ggd.priem(a, b)).isEqualTo(ggd);
    }
}
