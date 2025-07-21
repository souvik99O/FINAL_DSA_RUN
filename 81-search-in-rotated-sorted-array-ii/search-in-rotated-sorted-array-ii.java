class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;

            if(low==mid && mid==high)
            {
                if(nums[mid]==target)
                return true;

                else return false;
            }

            if (nums[mid] == target) {
                return true;
            }
             else if (nums[high] == nums[mid] && nums[mid] == nums[low]) {
                    low++;
                    high--;

            }

            else if (nums[low] <= nums[mid])//left sorted
            {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else//right sorted
            {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

        }

        return false;

    }
}