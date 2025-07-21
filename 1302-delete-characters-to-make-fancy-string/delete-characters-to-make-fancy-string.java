class Solution {
    public String makeFancyString(String s) {

       StringBuilder sb= new StringBuilder();
       char [] arr= s.toCharArray();
       int count=1;
       sb.append(arr[0]);

       for(int i=1;i<arr.length; i++)
       {
        if(arr[i-1]==arr[i])
        {
            count++;
        }
        else
        count=1;

        if(count<3)
        {
            sb.append(arr[i]);
        }
       } 

       return sb.toString();
    }
}