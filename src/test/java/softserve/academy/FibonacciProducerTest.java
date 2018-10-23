package softserve.academy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static softserve.academy.Constants.*;

public class FibonacciProducerTest {
    private FibonacciProducer producer = FibonacciProducer.getProducer();


    @Test
    public void getProducer() {
        FibonacciProducer producer = FibonacciProducer.getProducer();
        assertNotNull(producer);
    }

    @Test
    public void getSequenceByLengthWithValidArg() {
        String actual = producer.getSequenceByLength(VALID_ARGUMENT);
        assertEquals(EXPECTED_FOR_VALID_ARG, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSequenceByLengthWithInvalidArg() {
        producer.getSequenceByLength(INVALID_ARGUMENT);
    }

    @Test
    public void getSequenceInRange() {
        assertEquals(EXPECTED_FOR_THE_RANGE, producer.getSequenceInRange(LOWER_BOUND, UPPER_BOUND));
    }
}