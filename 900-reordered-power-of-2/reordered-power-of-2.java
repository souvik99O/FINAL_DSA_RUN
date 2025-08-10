
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