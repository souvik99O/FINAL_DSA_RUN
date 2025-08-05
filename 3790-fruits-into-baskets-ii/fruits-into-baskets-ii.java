class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] basket) {

        List<Integer> baskets= new ArrayList<>();
        for(int i=0 ; i<basket.length; i++)
        {
            baskets.add(basket[i]);
        }
        int unplaced=0;
        for(int i=0 ; i<fruits.length; i++)
        {
            int size=baskets.size();
            int placed=0;
            for(int j=0; j<size; j++)
            {
                if(baskets.get(j)>=fruits[i]){
                baskets.remove(baskets.get(j));
                placed=1;
                break;
                }
            }
            if(placed==0)
            {
                unplaced++;
            }

        }
        return unplaced;
        
    }
}