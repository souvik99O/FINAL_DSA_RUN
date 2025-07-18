class Solution {
    public int findKthPositive(int[] arr, int k) {

        List<Integer> list = new ArrayList<>();
        int m=0;
        for(int i=1; i<=arr[arr.length-1]; i++)
        {
            if(arr[m]!=i)
            list.add(i);
            else
            m++;
        }
        
            for(int i=arr[arr.length-1]+1; i<10000;i++)
            {
                list.add(i);
            }
        

        return list.get(k-1);
        
    }
}