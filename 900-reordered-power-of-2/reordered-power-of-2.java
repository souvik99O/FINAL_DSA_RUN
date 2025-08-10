// class Solution {
//     public boolean reorderedPowerOf2(int n) {
//         List<Integer> arrL= new ArrayList<>();
//         while(n!=0)
//         {
//             int ld=n%10;
//             n=n/10;
//             arrL.add(ld);
//         }
//         int arr[]= new int[arrL.size()];
//         for(int i=0; i<arrL.size(); i++)
//         {
//             arr[i]=arrL.get(i);
//         }
//         int len=arr.length;
//         for(int i=0; i<arr.length/2; i++)
//         {
//             int temp=arr[i];
//             arr[i]=arr[len-i-1];
//             arr[len-i-1]=temp;
//         }

//         HashMap<Integer,Integer> map= new HashMap<>();

//         for(int i=0; i<arr.length; i++)
//         {
//             map.put(arr[i], map.getOrDefault(arr[i],0)+1);
//         }
//         List<Integer> list =new ArrayList<>();
//         boolean ans=permute(0,map,list,len);
//         if(ans==true)
//         return true;
//         else
//         return false;
        
//     }

//     boolean permute(int i,HashMap<Integer,Integer> map, List<Integer> list,int n)
//     {

//         if(i>=n)
//         {
//             int num=convertToNum(list);
//             if(list.get(0)==0)
//             return false;
//             if(isPowerOfTwo(num))
//             return true;
//             else
//             return false;
//         }


//         for(int e: new ArrayList<Integer>(map.keySet()))
//         {
//             list.add(e);
//             map.put(e, map.getOrDefault(e,0)-1);
//             if(map.get(e)==0)
//             map.remove(e);
            
//             boolean ans=permute(i+1,map,list,n);

//             int ld=list.get(list.size()-1);

//             map.put(ld, map.getOrDefault(ld,0)+1);
//             list.remove(list.size()-1);

//             if(ans==true)
//             return true;
//         }

//         return false;

//     }

//     public boolean isPowerOfTwo(int n) {
//         int count = 0;
//         while (n > 0) {
//             int bit = n & 1;
//             n = n >> 1;
//             if (bit == 1)
//                 count++;
//         }
//         if (count == 1) {
//             return true;
//         }
//         return false;
//     }

//     public int convertToNum(List<Integer> list) {
//         int start = list.size() - 1;
//         int fact = 1;
//         int num = 0;
//         for (int i = start; i >= 0; i--) {
//             int n = list.get(i);
//             n = n * fact;
//             fact = fact * 10;
//             num += n;
//         }
//         return num;
//     }
// }
class Solution {
    public boolean reorderedPowerOf2(int n) {

        for(int i=0; i<31; i++)
        {
            int powerOf2 =1<<i;
            if(findFrequency(n).equals(findFrequency(powerOf2)))
            {
                return true;
            }
        }

    return false;
      
    }
    String findFrequency(int n)
    {
        int map[]= new int[10];

        while(n>0)
        {
            int digit=n%10;
            map[digit]++;
            n=n/10;
        }
    return Arrays.toString(map);
    }
}