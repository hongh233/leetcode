package util;

public class TestCase {
    private final String input;
    private final String expected;

    public TestCase(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    public String getInput() {
        return this.input;
    }

    public String getExpected() {
        return this.expected;
    }

}
