class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int n = charArr1.length;
        int m = charArr2.length;

        HashMap<String, String> dp = new HashMap<>();
        String list = findLcs(n - 1, m - 1, charArr1, charArr2, dp);

        List<Character> lcs = new ArrayList<>();
        for (char ch : list.toCharArray()) {
            lcs.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        for (char c : lcs) {
            // Append all extra characters from str1 before c
            while (i < n && charArr1[i] != c) {
                sb.append(charArr1[i]);
                i++;
            }
            // Append all extra characters from str2 before c
            while (j < m && charArr2[j] != c) {
                sb.append(charArr2[j]);
                j++;
            }
            // Append the LCS character
            sb.append(c);
            i++;
            j++;
        }

        // Append remaining characters
        while (i < n) sb.append(charArr1[i++]);
        while (j < m) sb.append(charArr2[j++]);

        return sb.toString();
    }

    String findLcs(int i, int j, char[] charArr1, char[] charArr2, HashMap<String, String> dp) {
        String key = i + "," + j;
        if (i == -1 || j == -1) {
            return "";
        }
        if (dp.containsKey(key))
            return dp.get(key);

        if (charArr1[i] == charArr2[j]) {
            String str = findLcs(i - 1, j - 1, charArr1, charArr2, dp) + charArr1[i];
            dp.put(key, str);
            return str;
        }

        String option1 = findLcs(i - 1, j, charArr1, charArr2, dp);
        String option2 = findLcs(i, j - 1, charArr1, charArr2, dp);

        String result = option1.length() > option2.length() ? option1 : option2;
        dp.put(key, result);
        return result;
    }
}
