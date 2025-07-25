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
    public int[][] merge(int[][] intervals) {

 List<Pair> list= new ArrayList<>(); 
  List<Pair> Anslist= new ArrayList<>(); 

        for(int i=0; i<intervals.length;i++)
        {
            Pair p= new Pair(intervals[i][0],intervals[i][1]);
            list.add(p);
        }

        Collections.sort(list,(a,b)->a.start-b.start);

        int minStart=list.get(0).start;
        int maxEnd=list.get(0).end;

        for(int i=0; i<list.size();i++)
        {
            if(list.get(i).start<=maxEnd)
            {
                maxEnd=Math.max(maxEnd,list.get(i).end);
            }
            else
            {
                Anslist.add(new Pair(minStart,maxEnd));
                minStart=list.get(i).start;
                maxEnd=list.get(i).end;
            }
        }

        Pair p= new Pair(minStart,maxEnd);

        if(!Anslist.contains(p))
        Anslist.add(p);

    int result[][]= new int[Anslist.size()][2];

    for(int i=0; i<Anslist.size();i++)
    {
        result[i][0]=Anslist.get(i).start;
        result[i][1]=Anslist.get(i).end;
    }

    return result;

        
        
    }
}