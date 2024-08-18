import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        q.add(1L);
        set.add(1L);
        
        int[] factors = {2, 3, 5};
        long uglyNumber = 1;

        for (int i = 0; i < n; i++) {
            uglyNumber = q.poll();
            
            // Generate new ugly numbers and add them to the priority queue
            for (int factor : factors) {
                long newUgly = uglyNumber * factor;
                if (set.add(newUgly)) {
                    q.add(newUgly);
                }
            }
        }
        return (int) uglyNumber;
    }
}