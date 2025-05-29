class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=0; int j=0;
        int k=m;
      
        if (n>0) { 
            while(i<m+n && j<n) {
                
                if(i >= k && nums2[j] != 0) {  // If we're in the empty space
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
                else if(i < k && nums2[j] < nums1[i]) {  // Insert nums2[j] before nums1[i]
                    // Shift elements to make space
                    for(int l = k; l > i; l--) {
                        nums1[l] = nums1[l-1];
                    }
                    nums1[i] = nums2[j];
                    k++;  // One more element in the valid portion
                    i++;
                    j++;
                }
                else if(i < k && nums1[i] <= nums2[j]) {  // nums1[i] is smaller or equal
                    i++;
                }
                else {  // Handle equal case when i >= k
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
            }
            
            // Copy any remaining elements from nums2
            while(j < n) {
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }
    }
}