class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int r = 0, l = 0, count = 0, odd = 0;
        int temp = -1; // Position of first odd number in current window
        
        while (r < nums.length) {
            if (nums[r] % 2 != 0) {
                odd++;
                // Set temp to first odd number we encounter
                if (temp == -1) {
                    temp = r;
                }
            }
            
            // Shrink window when we have too many odds
            while (odd > k) {
                if (nums[l] % 2 != 0) {
                    odd--;
                }
                l++;
                
                // If we moved past the first odd, find the new first odd
                if (temp < l) {
                    temp = l;
                    // Find first odd number from current left position
                    while (temp <= r && nums[temp] % 2 == 0) {
                        temp++;
                    }
                    // If no odd found in current window, reset temp
                    if (temp > r) {
                        temp = -1;
                    }
                }
            }
            
            // When we have exactly k odd numbers
            if (odd == k && temp != -1) {
                // Count valid starting positions: from l to temp (inclusive)
                count += temp -l + 1;
            }
            
            r++;
        }
        
        return count;
    }
}