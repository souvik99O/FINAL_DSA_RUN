class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // int i=m;
        // int j=0;

        // while(i<m+n && j<n)
        // {
          
        //     if(i<m+n && j<n &&  nums1[i]!=0 && nums1[i]<nums2[j])
        //     {
        //         i++;
        //     }


        //      if(i<m+n && j<n && nums1[i]==0 && nums2[j]!=0)
        //         {
        //             nums1[i]=nums2[j];
        //             i++;
        //             j++;
        //          }


        //     if(i<m+n && j<n && (nums1[i]>nums2[j] || nums1[i]==nums2[j]))
        //     {
        //         for(int l=k; l>i;l--)
        //         {
        //             nums1[l]=nums1[l-1];
        //         }
        //         nums1[i]=nums2[j];
        //         i++;j++;k++;
        //     }

             
        // }

        // while(i<m+n)
        // {
        //     nums1[i]=nums2[j];
        //     i++;
        //     j++;
        // }
        // Arrays.sort(nums1);

              // Initialize pointers
        int i = m - 1;        // Pointer to last valid element in nums1
        int j = n - 1;        // Pointer to last element in nums2
        int k = m + n - 1;    // Pointer to last position in nums1 array
        
        // Merge arrays from the end while both arrays have elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                // nums1 element is larger, place it at position k
                nums1[k] = nums1[i];
                i = i - 1;    // Move nums1 pointer backward
                k = k - 1;    // Move result pointer backward
            } else {
                // nums2 element is larger or equal, place it at position k
                nums1[k] = nums2[j];
                j = j - 1;    // Move nums2 pointer backward
                k = k - 1;    // Move result pointer backward
            }
        }
          while (j >= 0) {
            nums1[k] = nums2[j];
            j = j - 1;
            k = k - 1;
        }
        

    }
}