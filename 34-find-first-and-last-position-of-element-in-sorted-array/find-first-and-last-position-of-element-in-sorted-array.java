class Solution {

//---------------------------------o(n) brute  force------------------------------

    // public int[] searchRange(int[] arr, int target) {
        
    //     int low=0;
    //     int high=arr.length-1;
    //     int ans[]= new int[2];
    //     ans[0]=-1;ans[1]=-1; 
    //     if(arr.length==0)
    //     {return ans;}
       
    //    for(int i=0; i<arr.length;i++)
    //    {
    //     if(arr[i]==target)
    //     {
    //         ans[0]=i;
    //         while(i<arr.length && arr[i]==target)
    //         {
    //             i++;
    //         }
    //         ans[1]=i-1;
    //     }
    //    }

    //    return ans;
    // }

    public int[] searchRange(int[] arr, int target) {
     
     int low=0;
     int high=arr.length-1;
     int ans[]=new int[2];
     ans[0]=-1;
     ans[1]=-1;

     while(low<=high)
     {
        int mid=(high+low)/2;
        if(arr[mid]>target)
        {
            high=mid-1;
        }
        else if(arr[mid]<target)
        {
            low=mid+1;
        }
        else
        {
            if(mid>0 && arr[mid-1]==arr[mid])
            high=mid-1;
            else{
            ans[0]=mid;
            break;
            }
        }

     }


     low=0;
     high=arr.length-1;
     while(low<=high)
     {
        int mid=(high+low)/2;
        if(arr[mid]>target)
        {
            high=mid-1;
        }
        else if(arr[mid]<target)
        {
            low=mid+1;
        }
        else
        {
            if(mid < arr.length - 1 && arr[mid+1]==arr[mid])
            low=mid+1;
            else
            {
            ans[1]=mid;
            break;
            }
        }

     }

     return ans;

        
    }
}