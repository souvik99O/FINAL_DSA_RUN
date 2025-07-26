class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        int TotalGroups = hand.length / groupSize;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while(!map.isEmpty()) {
            int minKey = Integer.MAX_VALUE;
            for (int key : map.keySet()) {
                if (key < minKey) {
                    minKey = key;
                }
            }

            map.put(minKey, map.getOrDefault(minKey, 0) - 1);
            if(map.get(minKey)==0)
            map.remove(minKey);

            for(int i=0; i<groupSize-1;i++)
            {
                if(map.containsKey(minKey+1))
                {
                    minKey=minKey+1;
                    map.put(minKey, map.getOrDefault(minKey, 0) - 1);
                    if(map.get(minKey)==0)
                    map.remove(minKey);

                }
                else
                {
                    return false;
                }
            }
        }

        if(map.size()==0)
        return true;

        else
        return false;
    }
}