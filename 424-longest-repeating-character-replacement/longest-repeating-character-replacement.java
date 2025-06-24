class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int len = 0;
        int changes = 0;
        char str[] = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        if (k == 0) {
            int maxCount = 1;
            int currentCount = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    currentCount++;
                    maxCount = Math.max(maxCount, currentCount);
                } else {
                    currentCount = 1;
                }
            }
            return maxCount;
        } else {
            while (r < s.length()) {
                // ✅ Updated character count
                map.put(str[r], map.getOrDefault(str[r], 0) + 1);

                // ✅ Removed: `if (map.containsKey(str[r])) {` — unnecessary, as `put()` already ensures the key exists
                // ✅ Just update maxFreq directly
                maxFreq = Math.max(maxFreq, map.get(str[r]));

                // ❌ Originally recalculated changes multiple times unnecessarily
                changes = (r - l + 1) - maxFreq;

                while (changes > k) {
                    // ✅ Removed: updating maxFreq here (was incorrect logic)
                    map.put(str[l], map.getOrDefault(str[l], 0) - 1);
                    l++;

                    // ✅ Recalculate changes after shifting left pointer
                    changes = (r - l + 1) - maxFreq;
                }

                len = Math.max(len, r - l + 1);
                r++;
            }
        }
        return len;
    }
}
