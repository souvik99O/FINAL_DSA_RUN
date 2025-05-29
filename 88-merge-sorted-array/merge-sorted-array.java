class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=m;
        int j=0;

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

        while(i<m+n)
        {
            nums1[i]=nums2[j];
            i++;
            j++;
        }
        Arrays.sort(nums1);

        
      
        
    }
}