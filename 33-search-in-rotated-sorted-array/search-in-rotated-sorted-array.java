class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            //0 1 2 3 4 5 6 
            //4 5 6 7 0 1 2 

            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) //left sorted
            {
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else //right sorted
            {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;

            }

        }

        return -1;
    }
}