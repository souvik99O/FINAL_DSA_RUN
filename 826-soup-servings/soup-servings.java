class Solution {
    public double soupServings(int n) {
     if (n > 4800) return 1.0;
      HashMap<String,Double> memo= new HashMap<>();
      double ans= solve(n,n,memo); 
      return ans;
    }

    public double solve(int a,int b,HashMap<String,Double> memo)
    {
        String key= a + "," + b;
        if(a>0 && b<=0){
            memo.put(key,0.0);
        return 0;
        }
        if(a<=0 && b>0){
            memo.put(key,1.0);
        return 1;
        }
        if(a<=0 && b<=0){
            memo.put(key,0.5);
        return 0.5;
        }
        if(memo.containsKey(key))
        return memo.get(key);

        double op1=solve(a-100,b-0,memo);
        double op2=solve(a-75,b-25,memo);
        double op3=solve(a-50,b-50,memo);
        double op4=solve(a-25,b-75,memo);
        memo.put(key,(op1+op2+op3+op4)/4);
        return (op1+op2+op3+op4)/4;
    }
}