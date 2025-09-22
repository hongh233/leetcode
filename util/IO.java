package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;

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

            if (json.charAt(i) == ']') break;
            if (json.charAt(i) != '{') {
                throw new IllegalArgumentException("Expected '{' at position " + i);
            }

            int start = i;
            int depth = 0;
            boolean inStr = false, esc = false;

            while (i < n) {
                char c = json.charAt(i);
                if (inStr) {
                    if (esc) esc = false;
                    else if (c == '\\') esc = true;
                    else if (c == '"') inStr = false;
                } else {
                    if (c == '"') inStr = true;
                    else if (c == '{') depth++;
                    else if (c == '}') {
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
            if (i < n && json.charAt(i) == ',') i++;
        }
        return list;
    }

    private static int skipWs(String s, int i) {
        int n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return i;
    }

    private static final Pattern P_INPUT =
            Pattern.compile("\"input\"\\s*:\\s*\"([^\"]*)\"");


    private static void addOneTestCase(String objJson, List<TestCase> out) {
        String input = findFirstGroup(P_INPUT, objJson);
        String[] expected = extractExpectedArray(objJson);
        if (input == null || expected == null) {
            throw new IllegalArgumentException("Missing 'input' or 'expected' in object: " + objJson);
        }
        out.add(new TestCase(input, expected));
    }


    private static String findFirstGroup(Pattern p, String s) {
        Matcher m = p.matcher(s);
        return m.find() ? m.group(1) : null;
    }

    private static String[] extractExpectedArray(String objJson) {
        if (objJson == null) return null;

        int keyIdx = indexOfExpectedKey(objJson);
        if (keyIdx < 0) return null;

        int i = keyIdx;
        int n = objJson.length();

        while (i < n && objJson.charAt(i) != ':') i++;
        if (i >= n) return null;
        i++;

        while (i < n && Character.isWhitespace(objJson.charAt(i))) i++;
        if (i >= n) return null;

        char first = objJson.charAt(i);

        if (first == '"') {
            StringBuilder sb = new StringBuilder();
            i++;
            boolean esc = false;
            while (i < n) {
                char c = objJson.charAt(i++);
                if (esc) { sb.append(c); esc = false; }
                else if (c == '\\') esc = true;
                else if (c == '"') break;
                else sb.append(c);
            }
            return new String[]{sb.toString()};
        }

        if (first == '{') {
            int start = i;
            int end = findMatchingBrace(objJson, start);
            if (end < 0) return null;
            String expectedObj = objJson.substring(start, end + 1);

            List<String> list = new ArrayList<>();
            Matcher m = Pattern.compile(":\\s*\"(.*?)\"").matcher(expectedObj);
            while (m.find()) {
                list.add(m.group(1).trim());
            }
            return list.toArray(new String[0]);
        }

        return null;
    }


    private static int indexOfExpectedKey(String s) {
        Pattern p = Pattern.compile("\"expected\"\\s*:");
        Matcher m = p.matcher(s);
        return m.find() ? m.end() - 1 : -1;
    }

    private static int findMatchingBrace(String s, int start) {
        int depth = 0;
        boolean inStr = false, esc = false;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStr) {
                if (esc) esc = false;
                else if (c == '\\') esc = true;
                else if (c == '"') inStr = false;
            } else {
                if (c == '"') inStr = true;
                else if (c == '{') depth++;
                else if (c == '}') {
                    depth--;
                    if (depth == 0) return i;
                }
            }
        }
        return -1;
    }
}
