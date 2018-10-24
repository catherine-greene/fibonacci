package softserve.academy;

class FibonacciProducer {
    private static final int[] ONE_DIGIT_FIBONACCI = {0, 1, 1, 2, 3, 5, 8};
    private static final int[] TWO_DIGIT_FIBONACCI = {13, 21, 34, 55, 89};
    private static final int[] THREE_DIGIT_FIBONACCI = {144, 233, 377, 610, 987};
    private static final int[] FOUR_DIGIT_FIBONACCI = {1597, 2584, 4181, 6765};
    private static final int[] FIVE_DIGIT_FIBONACCI = {10946, 17711, 28657, 46368, 75025};
    private static final int[] SIX_DIGIT_FIBONACCI = {121393, 196418, 317811, 514229, 832040};
    private static final int[] SEVEN_DIGIT_FIBONACCI = {1346269, 2178309, 3524578, 5702887, 9227465};
    private static final int[] EIGHT_DIGIT_FIBONACCI = {14930352, 24157817, 39088169, 63245986};
    private static final int[] NINE_DIGIT_FIBONACCI = {102334155, 165580141, 267914296, 433494437, 701408733};
    private static FibonacciProducer producer;
    private int first = -1;
    private int second = -1;

    private FibonacciProducer() {
    }

    static FibonacciProducer getProducer() {
        if (producer == null) {
            producer = new FibonacciProducer();
        }
        return producer;
    }

    String getSequenceByLength(int length) {
        String result;
        if (length < 0) {
            length = -length;
        }
        if (length > 9) {
            throw new IllegalArgumentException("Length must be less or equal to 9!");
        }
        switch (length) {
            case 1:
                result = intArrayToString(ONE_DIGIT_FIBONACCI);
                break;
            case 2:
                result = intArrayToString(TWO_DIGIT_FIBONACCI);
                break;
            case 3:
                result = intArrayToString(THREE_DIGIT_FIBONACCI);
                break;
            case 4:
                result = intArrayToString(FOUR_DIGIT_FIBONACCI);
                break;
            case 5:
                result = intArrayToString(FIVE_DIGIT_FIBONACCI);
                break;
            case 6:
                result = intArrayToString(SIX_DIGIT_FIBONACCI);
                break;
            case 7:
                result = intArrayToString(SEVEN_DIGIT_FIBONACCI);
                break;
            case 8:
                result = intArrayToString(EIGHT_DIGIT_FIBONACCI);
                break;
            case 9:
                result = intArrayToString(NINE_DIGIT_FIBONACCI);
                break;
            default:
                result = "";
        }
        return result;
    }

    String getSequenceInRange(int lowerBound, int upperBound) {
        if (lowerBound < 0) {
            lowerBound = -lowerBound;
        }
        if (upperBound < 0) {
            upperBound = -upperBound;
        }
        String result;
        if (lowerBound == 0) {
            first = ONE_DIGIT_FIBONACCI[0];
            second = ONE_DIGIT_FIBONACCI[1];
        } else if (lowerBound == 1) {
            first = ONE_DIGIT_FIBONACCI[1];
            second = ONE_DIGIT_FIBONACCI[1];
        } else {
            switch (getNumLength(lowerBound)) {
                case 1:
                    setFirstAndSecond(ONE_DIGIT_FIBONACCI, null, lowerBound);
                    break;
                case 2:
                    setFirstAndSecond(TWO_DIGIT_FIBONACCI, ONE_DIGIT_FIBONACCI, lowerBound);
                    break;
                case 3:
                    setFirstAndSecond(THREE_DIGIT_FIBONACCI, TWO_DIGIT_FIBONACCI, lowerBound);
                    break;
                case 4:
                    setFirstAndSecond(FOUR_DIGIT_FIBONACCI, THREE_DIGIT_FIBONACCI, lowerBound);
                    break;
                case 5:
                    setFirstAndSecond(FIVE_DIGIT_FIBONACCI, FOUR_DIGIT_FIBONACCI, lowerBound);
                    break;
                case 6:
                    setFirstAndSecond(SIX_DIGIT_FIBONACCI, FIVE_DIGIT_FIBONACCI, lowerBound);
                    break;
                case 7:
                    setFirstAndSecond(SEVEN_DIGIT_FIBONACCI, SIX_DIGIT_FIBONACCI, lowerBound);
                    break;
                case 8:
                    setFirstAndSecond(EIGHT_DIGIT_FIBONACCI, SEVEN_DIGIT_FIBONACCI, lowerBound);
                    break;
                case 9:
                    setFirstAndSecond(NINE_DIGIT_FIBONACCI, EIGHT_DIGIT_FIBONACCI, lowerBound);
                    break;
            }
        }
        result = calcSequence(first, second, upperBound);
        return result;
    }

    private int getNumLength(int num) {
        return String.valueOf(num).length();
    }

    private void setFirstAndSecond(int[] array, int[] precedingArray, int lowerBound) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= lowerBound) {
                second = array[i];
                try {
                    first = array[i - 1];
                } catch (IndexOutOfBoundsException ex) {
                    first = precedingArray[precedingArray.length - 1];
                }
                break;
            }
        }

    }

    private String intArrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : array) {
            stringBuilder.append(num).append(", ");
        }
        String result = stringBuilder.toString().trim();
        return result.substring(0, result.length() - 1);
    }

    private String calcSequence(int first, int second, int upperBound) {
        StringBuilder stringBuilder;
        if (first == 0 || first == 1 && second != 2) {
            stringBuilder = new StringBuilder(first + ", " + second + ", ");
        } else {
            stringBuilder = new StringBuilder(second + ", ");
        }
        int sum;
        while (true) {
            sum = first + second;
            if (sum > upperBound) {
                break;
            }
            stringBuilder.append(sum).append(", ");
            first = second;
            second = sum;
        }
        String result = stringBuilder.toString().trim();
        return result.substring(0, result.length() - 1);
    }
}
