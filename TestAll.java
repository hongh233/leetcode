import util.IO;
import util.TestCase;

import java.lang.reflect.Method;
import java.util.*;

public class TestAll {

    public static void main(String[] args) throws Exception {
        Map<Integer, String> tags = TestData.TAGS;

        int total = 0, pass = 0;

        for (Map.Entry<Integer, String> entry : tags.entrySet()) {
            int leetcode = entry.getKey();
            String tag = entry.getValue();

            String path = String.format("repo/%s/lc%d", tag, leetcode);
            String jsonPath = path + "/test.json";

            try {
                List<TestCase> cases = IO.readTestCases(jsonPath);
                if (cases.isEmpty()) {
                    System.out.println("⚠️  No test cases found for " + leetcode);
                    continue;
                }

                String className = String.format("repo.%s.lc%d.Test%d", tag, leetcode, leetcode);
                Class<?> testClass = Class.forName(className);
                Method runMethod = testClass.getMethod("runTest", String.class);

                System.out.println("\n==============================");
                System.out.println(" Running LeetCode " + leetcode + " (" + tag + ")");
                System.out.println("==============================");

                int localPass = 0;
                for (int i = 0; i < cases.size(); i++) {
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
                    if (ok) localPass++;

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

                double accuracy = cases.isEmpty() ? 0.0 : (localPass * 100.0 / cases.size());
                System.out.printf("Accuracy for %d: %.2f%%, Passed %d/%d%n",
                        leetcode, accuracy, localPass, cases.size());

                total += cases.size();
                pass += localPass;

            } catch (Exception e) {
                System.out.println("❌ Error running tests for LeetCode " + leetcode + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("\n==============================");
        System.out.println(" Final Report ");
        System.out.println("==============================");
        double totalAcc = total == 0 ? 0.0 : (pass * 100.0 / total);
        System.out.printf("Overall Accuracy: %.2f%%, Passed %d/%d%n", totalAcc, pass, total);
    }
}
