class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> mainList = new ArrayList<>();
        

        f(0,target,list,candidates.length,candidates,mainList);

        return mainList;

    }

    public static void f(int i, int t, List<Integer>list, int n, int [] candidates,List<List<Integer>> mainList)
    {
        //base
        if(t==0)
        {
            mainList.add(new ArrayList(list));
            return;
        }
        if(i>=n || t<0)
        return;
        //base

        //pick and keep picking till target is not negative
        list.add(candidates[i]);
        f(i,t-candidates[i],list,n,candidates,mainList);
        //donot pick that index move to the next
        list.remove(list.size()-1);
        f(i+1,t,list,n,candidates,mainList);
        
    }
}