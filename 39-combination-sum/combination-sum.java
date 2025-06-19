class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> mainList = new ArrayList<>();
        int sum=0;

        f(0,sum,list,candidates.length,candidates,mainList,target);

        return mainList;

    }

    public static void f(int i, int sum, List<Integer>list, int n, int [] candidates,List<List<Integer>> mainList,int t)
    {
        //base
        if(i>=n)
        {
            if(sum==t)
            mainList.add(new ArrayList(list));

          return;  
        }
        if(sum>t)
        return;
        //base

        //pick and keep picking till target is not negative
        list.add(candidates[i]);
        f(i,sum+candidates[i],list,n,candidates,mainList,t);
        //donot pick that index move to the next
        list.remove(list.size()-1);
        f(i+1,sum,list,n,candidates,mainList,t);
        
    }
}