package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IO {

    public static List<TestCase> readTestCases(String path) throws IOException {
        String json = Files.readString(Path.of(path));
        return parseTestCases(json);
    }

    private static List<TestCase> parseTestCases(String json) {
        if (json == null) json = "";
        json = json.trim();
        List<TestCase> list = new ArrayList<>();
        if (json.isEmpty()) return list;

        int n = json.length();
        int i = skipWs(json, 0);
        if (i >= n || json.charAt(i) != '[') {
            throw new IllegalArgumentException("JSON must start with '['");
        }
        i++;

        while (true) {
            i = skipWs(json, i);
            if (i >= n) break;

            if (json.charAt(i) == ']') {
                break;
            }

            if (json.charAt(i) != '{') {
                throw new IllegalArgumentException("Expected '{' at position " + i);
            }
            int start = i;
            int depth = 0;
            boolean inStr = false;
            boolean esc = false;

            while (i < n) {
                char c = json.charAt(i);
                if (inStr) {
                    if (esc) {
                        esc = false;
                    } else if (c == '\\') {
                        esc = true;
                    } else if (c == '"') {
                        inStr = false;
                    }
                } else {
                    if (c == '"') {
                        inStr = true;
                    } else if (c == '{') {
                        depth++;
                    } else if (c == '}') {
                        depth--;
                        if (depth == 0) {
                            String obj = json.substring(start, i + 1);
                            addOneTestCase(obj, list);
                            i++;
                            break;
                        }
                    }
                }
                i++;
            }

            i = skipWs(json, i);
            if (i < n && json.charAt(i) == ',') {
                i++;
            }
        }
        return list;
    }

    private static int skipWs(String s, int i) {
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') i++;
            else break;
        }
        return i;
    }

    private static final Pattern P_INPUT =
            Pattern.compile("\"input\"\\s*:\\s*\"([^\"]*)\"");
    private static final Pattern P_EXPECTED =
            Pattern.compile("\"expected\"\\s*:\\s*\"([^\"]*)\"");

    private static void addOneTestCase(String objJson, List<TestCase> out) {
        String input = findFirstGroup(P_INPUT, objJson);
        String expected = findFirstGroup(P_EXPECTED, objJson);
        if (input == null || expected == null) {
            throw new IllegalArgumentException("Missing 'input' or 'expected' in object: " + objJson);
        }
        out.add(new TestCase(input, expected));
    }

    private static String findFirstGroup(Pattern p, String s) {
        Matcher m = p.matcher(s);
        return m.find() ? m.group(1) : null;
    }

}
