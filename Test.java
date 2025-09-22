import util.IO;
import util.TestCase;

import java.lang.reflect.Method;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Leetcode number: ");
        int leetcode = in.nextInt();
        in.close();

        String tag = TestData.TAGS.getOrDefault(leetcode, "Unknown");
        String path = String.format("repo/%s/lc%d", tag, leetcode);
        String jsonPath = path + "/test.json";

        List<TestCase> cases = IO.readTestCases(jsonPath);
        String className = String.format("repo.%s.lc%d.Test%d", tag, leetcode, leetcode);
        Class<?> testClass = Class.forName(className);
        Method runMethod = testClass.getMethod("runTest", String.class);

        int testNum = cases.size();
        int pass = 0;

        for (int i = 0; i < testNum; i++) {
            TestCase tc = cases.get(i);
            String input = tc.input();
            String[] expected = tc.expected();

            String output = String.valueOf(runMethod.invoke(null, input)).trim();

            boolean ok = false;
            for (String e : expected) {
                if (output.equals(e.trim())) {
                    ok = true;
                    break;
                }
            }
            if (ok) pass++;

            String result = ok ? "✅" : "❌";
            System.out.println("=== Test Case " + (i + 1) + " " + result + " ===");
            System.out.println(">>> Input:");
            System.out.println(" ➡️ " + input);
            System.out.println(">>> Expected:");
            System.out.println(" ➡️ " + Arrays.toString(expected));
            System.out.println(">>> Output:");
            System.out.println(" 👉 " + output);
            System.out.println();
        }

        double accuracy = testNum == 0 ? 0.0 : (pass * 100.0 / testNum);
        System.out.printf("Accuracy: %.2f%%, Passed %d/%d%n", accuracy, pass, testNum);
    }
}
