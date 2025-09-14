import util.IO;

import java.lang.reflect.Method;
import java.util.*;

public class Test {
    private static final Map<Integer, String> TAGS = Map.of(
    56, "Sort",
    148, "Sort"
    );

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Leetcode number: ");
        int leetcode = in.nextInt();
        in.close();

        String tag = TAGS.getOrDefault(leetcode, "Unknown");
        String path = String.format("repo/%s/lc%d/test", tag, leetcode);

        int testNum = IO.getFileNum(path, "input");

        for (int i = 0; i < testNum; i++) {
            String test_input_name = String.format(path + "/test.%02d.input.txt", i+1);
            String test_expected_name = String.format(path + "/test.%02d.expected.txt", i+1);

            String input = IO.readFile(test_input_name);
            String expected = IO.readFile(test_expected_name);

            String className = String.format("repo.%s.lc%d.Test%d", tag, leetcode, leetcode);
            Class<?> testClass = Class.forName(className);
            Method runMethod = testClass.getMethod("runTest", String.class);
            String output = (String) runMethod.invoke(null, input);

            String result = output.equals(expected) ? "✅" : "❌";
            System.out.println("=== Test Case " + (i+1) + " "+ result + " ===");
            System.out.println(">>> Input:");
            System.out.println(" ➡️ " + input);
            System.out.println(">>> Expected:");
            System.out.println(" ➡️ " + expected);
            System.out.println(">>> Output:");
            System.out.println(" 👉 " + output);
            System.out.println();
        }
    }
}
