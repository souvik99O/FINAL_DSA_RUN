class Solution {
    public int[][] merge(int[][] intervals) {

       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int[] interval : intervals) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(interval[0]);
            temp.add(interval[1]);
            list.add(temp);
        }
       for(int i=0; i<list.size();i++)
       {
        if(i!=0 && list.get(i).get(0)<=list.get(i-1).get(1))
        {
            if( list.get(i).get(1)<=list.get(i-1).get(1))
            {
                list.remove(i);;
            }
            else{
            list.get(i-1).set(1,list.get(i).get(1));
            list.remove(i);
            }
            i--;
        }
       }

       int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }
}