class Solution {
    public int[][] merge(int[][] intervals) {

       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
      ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        
       for(int i=0; i<list.size();i++)
       {
        if(i!=0 && list.get(i)[0]<=list.get(i-1)[1])
        {
            if( list.get(i)[1]<=list.get(i-1)[1])
            {
                list.remove(i);;
            }
            else{
            list.get(i-1)[1]=list.get(i)[1];
            list.remove(i);
            }
            i--;
        }
       }

       intervals=list.toArray(new int [0][0]);
       return intervals;
    }
}