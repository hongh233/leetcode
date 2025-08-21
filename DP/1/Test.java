import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        // Define multiple test cases: input and expected output
        String[][] testCases = {
                {
                    "3\n5 3 2\n",    // Sample input
                    "27"             // Expected output
                },
                {
                    "3\n5 3 2\n",    // Sample input
                    "27"             // Expected output
                }
                // Add more test cases here
        };

        final long TIME_LIMIT_MS = 1000;  // 1s
        final long MEMORY_LIMIT_MB = 512; // 512MB

        for (int idx = 0; idx < testCases.length; idx++) {
            String input = testCases[idx][0];
            String expectedOutput = testCases[idx][1];

            // Redirect System.in
            InputStream originalIn = System.in;
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            // Capture System.out
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            Runtime runtime = Runtime.getRuntime();
            runtime.gc(); // Suggest GC to get clean memory baseline
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            long startTime = System.nanoTime();

            boolean threwException = false;
            try {
                Main.main(null); // Call your main solution
            } catch (Exception e) {
                threwException = true;
                System.setIn(originalIn);
                System.setOut(originalOut);
                System.out.printf("Test #%d threw an exception: %s\n", idx + 1, e.getMessage());
                continue;
            }

            long endTime = System.nanoTime();
            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            // Restore System.in and System.out
            System.setIn(originalIn);
            System.setOut(originalOut);

            // Get and compare the actual output
            String actualOutput = outContent.toString().trim();
            boolean passed = actualOutput.equals(expectedOutput);

            // Calculate runtime and memory usage
            long elapsedMs = (endTime - startTime) / 1_000_000;
            long memoryUsedMB = (memoryAfter - memoryBefore) / (1024 * 1024);

            // Report result
            System.out.printf("====== Test #%d ======\n", idx + 1);
            System.out.println("Input:\n" + input);
            System.out.println("Expected Output: " + expectedOutput);
            System.out.println("Actual Output:   " + actualOutput);
            System.out.println(passed ? "--Test Passed--" : "--Test Failed--");
            System.out.printf("Time: %d ms (%s)\n", elapsedMs, (elapsedMs <= TIME_LIMIT_MS ? "OK" : "Exceeded"));
            System.out.printf("Memory: %d MB (%s)\n\n", memoryUsedMB, (memoryUsedMB <= MEMORY_LIMIT_MB ? "OK" : "Exceeded"));
        }
    }
}
