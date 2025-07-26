class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;
        for(int i=0; i<gas.length;i++)
        {
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas<totalCost)
        return -1;

        int gasLeft=0;
        int start=0;
        //am sure one solution exist so i wont check by circing instead check each index any one index must give me the ans for sure...
        for(int i=0; i<gas.length;i++)
        {
           gasLeft=gasLeft+gas[i]-cost[i];
           if(gasLeft<0)
           {
            start=i+1;
            gasLeft=0;
           } 
        }
        return start;
    }
}