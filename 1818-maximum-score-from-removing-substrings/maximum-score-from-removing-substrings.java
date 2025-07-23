import java.util.*;

class Solution {
    public static int points = 0;

    public int maximumGain(String s, int x, int y) {
        points = 0;

        if (x > y) {
            String afterFirst = removePattern(s, 'a', 'b', x);
            removePattern(afterFirst, 'b', 'a', y);
        } else {
            String afterFirst = removePattern(s, 'b', 'a', y);
            removePattern(afterFirst, 'a', 'b', x);
        }

        return points;
    }

    public static String removePattern(String s, char c1, char c2, int p) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c1 && ch == c2) {
                st.pop();
                points += p;
            } else {
                st.push(ch);
            }
        }

        // return remaining string
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);
        return sb.toString();
    }
}
