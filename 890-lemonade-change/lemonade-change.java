class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        int count20=0;

        for(int i=0; i<bills.length;i++)
        {
            if(bills[i]==5)
            {
                count5++;
            }
            else if(bills[i]==10)
            {
                if(count5<1)
                return false;
                else{
                count5--;
                count10++;
                }

            }
            else
            {
                if(count5>=1 && count10>=1)
                {
                    //no problem
                    count20++;
                    count10--;
                    count5--;
                }
                else if(count10<=0 && count5>=3)
                {
                    //no problem
                    count20++;
                    count5=count5-3;

                }
                else
                {
                    return false;
                }
            }
        }

        return true;
        
    }
}