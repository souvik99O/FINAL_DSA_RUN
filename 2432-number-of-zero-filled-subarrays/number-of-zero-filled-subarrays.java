class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0;
        long ans = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                int zeroes = 0;
                while (i<nums.length && nums[i] == 0) {
                    zeroes++;
                    i++;
                }

                while (zeroes != 0) {
                    ans = ans + zeroes;
                    zeroes--;
                }

            }
            i++;
        }

        return ans;

    }
}