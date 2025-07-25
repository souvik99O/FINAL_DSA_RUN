class Pair{
    int start;
    int end;

    public Pair(int start, int end)
    {
        this.start=start;
        this.end=end;
    }

}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        List<Pair> list= new ArrayList<>(); 

        for(int i=0; i<intervals.length;i++)
        {
            Pair p= new Pair(intervals[i][0],intervals[i][1]);
            list.add(p);
        }

        Collections.sort(list,(a,b)->a.end-b.end);

        int count=1;
        int lastEnd=list.get(0).end;

        for(int i=1; i<list.size();i++)
        {
            if(list.get(i).start>=lastEnd)
            {
                lastEnd=list.get(i).end;
                count++;
            }
        }


        return list.size()-count;


        
    }
}