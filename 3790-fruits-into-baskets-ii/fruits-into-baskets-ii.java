// class Solution {
//     public int numOfUnplacedFruits(int[] fruits, int[] basket) {

//         List<Integer> baskets= new ArrayList<>();
//         for(int i=0 ; i<basket.length; i++)
//         {
//             baskets.add(basket[i]);
//         }
//         int unplaced=0;
//         for(int i=0 ; i<fruits.length; i++)
//         {
//             int size=baskets.size();
//             int placed=0;
//             for(int j=0; j<size; j++)
//             {
//                 if(baskets.get(j)>=fruits[i]){
//                 baskets.remove(baskets.get(j));
//                 placed=1;
//                 break;
//                 }
//             }
//             if(placed==0)
//             {
//                 unplaced++;
//             }

//         }
//         return unplaced;

//     }
// }
class Pair {
    int pos;
    int basketVal;

    public Pair(int pos, int basketVal) {
        this.pos = pos;
        this.basketVal = basketVal;
    }
}

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] basket) {
        int unplaced=0;
        int placed=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.pos - b.pos);
        for (int i = 0; i < basket.length; i++) {
            pq.offer(new Pair(i, basket[i]));
        }
        List<Pair> temp = new ArrayList<>();
        for (int i = 0; i < fruits.length; i++) {
            placed=0;
            while (!pq.isEmpty()) {
                Pair ele = pq.poll();
                
                if (ele.basketVal >= fruits[i]) {
                    placed = 1;
                    break;
                } else {
                    temp.add(ele);
                }
            }

            if (placed == 0)
                unplaced++;

            for (int j = 0; j < temp.size(); j++) {
                pq.offer(temp.get(j));
            }
            temp.clear();
        }
        return unplaced;
    }
}