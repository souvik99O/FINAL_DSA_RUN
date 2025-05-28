class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> anslist = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) { // Changed: nums.length-2 to avoid out of bounds
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int tempval = 0 - nums[i];
            List<List<Integer>> biglist = find2sum(nums, tempval, nums[i], i + 1);

            if (biglist.size() != 0) {
                anslist.addAll(biglist);
            }
        }
        return anslist;
    }

    public List<List<Integer>> find2sum(int[] nums, int target, int firstval, int start) {
        List<List<Integer>> smalllist = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = start; i < nums.length; i++) {
            // Simplified: Remove special target==0 case
            int findelement = target - nums[i];

            if (map.containsKey(findelement)) {
                List<Integer> tripple = new ArrayList<>();
                tripple.add(firstval);
                tripple.add(findelement);
                tripple.add(nums[i]);
                smalllist.add(tripple);
                
                // Skip remaining duplicates after finding a match
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return smalllist;
    }
}
