class Solution {
   public boolean canJump(int[] nums) {
       // Shuru te nums[0] theke koto dure jete pari, sheta store korchi
       int max = nums[0];
       int i = 0;

       // Jodi array te ekta element thake, tahole already last position e achi
       if(nums.length == 1) {
           return true;
       }

       // Joto khon porjonto shob positions check na hoy AR egiye jete pari
       // i != max+1 er mane: jodi current position max reachable + 1 er soman hoy,
       // tahole mane amra atke gechi (je position e achi shekhane pohonchate pari na)
       while(i < nums.length && i != max + 1) {
           
           // Current position i theke check koro je aro dure jete pari kina
           // nums[i] = jump er length, i = current position, 
           // tai nums[i]+i = ei position theke shobcheye dure jete pari
           if(nums[i] + i > max)
               max = nums[i] + i;  // Amader maximum reachable position update kore dao

           // Check koro je ekhon last index porjonto pohonchate pari kina
           if(max >= nums.length - 1)
               return true;  // Hyan! Last porjonto pohonchate pari

           i++;  // Next position e jao explore korar jonno
       }

      // Jodi loop theke ber hoye ashi, mane:
      // 1. Shob positions check korechi kintu end porjonto pohonchate pari ni, BA
      // 2. Atke gechi (i hoye geche max+1, mane position i porjonto pohonchate pari na)
      return false;
   }
}

/*
Mul Intuition: 
- Shomoy shobcheye durer index track rakho jekhan reach korte paro (max variable diye)
- Proti position e dekho je okhane theke aro dure jete paro kina, jodi paro tahole max update koro
- Jodi kokhono end porjonto pohonchate paro tahole taratari return koro true
- i != max + 1 condition ensure kore je amra shudhu oi positions gulo explore kori ja actually reachable
- Greedy approach: proti step e maximum reachable distance track kori, jodi end reach korte pari tahole true
*/