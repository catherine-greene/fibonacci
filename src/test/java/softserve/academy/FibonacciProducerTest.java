package softserve.academy;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import static softserve.academy.Constants.INVALID_ARGUMENT;

class FibonacciProducerTest {
    private FibonacciProducer producer = FibonacciProducer.getProducer();

    @Test
    void getProducer() {
        FibonacciProducer producer = FibonacciProducer.getProducer();
        assertNotNull(producer);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvFileSource(resources = "/length_data.csv")
    void getSequenceByLengthWithValidArg(int length, String expectedResult) {
        String actual = producer.getSequenceByLength(length);
        assertEquals(expectedResult, actual);
    }

    @Test
    void getSequenceByLengthWithInvalidArg() {
        assertThrows(IllegalArgumentException.class, () -> producer.getSequenceByLength(INVALID_ARGUMENT));
    }

    @ParameterizedTest(name = "{0} - {1} -> {2}")
    @CsvFileSource(resources = "/range_data.csv")
    void getSequenceInRange(int lowerBound, int upperBound, String expectedResult) {
        assertEquals(expectedResult, producer.getSequenceInRange(lowerBound, upperBound));
    }
}