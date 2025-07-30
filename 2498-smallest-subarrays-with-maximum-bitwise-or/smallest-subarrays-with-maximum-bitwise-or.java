// class Solution {
//     public int[] smallestSubarrays(int[] nums) {
//         int max = 0;
//         int len = 0;
//         List<Integer> ansList = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++) {
//             int or = 0;
//             max = Integer.MIN_VALUE;
//             for (int j = i; j < nums.length; j++) {
//                 or = or | nums[j];
//                 if (or > max) {
//                     max = or;
//                     len = (j - i) + 1;
//                 }

//             }
//             ansList.add(len);
//         }

//         int arr[] = new int[ansList.size()];
//         int k = 0;
//         for (int i : ansList) {
//             arr[k++] = i;
//         }

//         return arr;

//     }
// }

//----o(n)----------------------
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int arr[] = new int[32];

        List<Integer> ansList = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                int temp=(1 << j);
                if ((nums[i] & temp) != 0) {
                    arr[j] = i;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int k = 0; k < 32; k++) {
                max = Math.max(max, arr[k]);
            }
            int len=0;
            if(max==0)
            {
                len=1;
            }
            else
            len = (max - i) + 1;
            ansList.add(len);
        }
        Collections.reverse(ansList);
        int ans[] = new int[ansList.size()];
        int k = 0;
        for (int i : ansList) {
            ans[k++] = i;
        }

        return ans;

    }
}