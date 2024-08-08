class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // step1: bucket sort-> 1:3, 2:3
        // step2: sort frequent-> 3:1, 3:2
        int[] bucket=new int[20001];
        for(int n: nums) bucket[n+10_000]++;
        List<Integer>[] freBucket=new List[nums.length+1];
        for(int i=0; i<bucket.length; i++) {
            if(bucket[i]>0) {
                int fre=bucket[i], val=i-10000;
                if(freBucket[fre]==null) freBucket[fre]=new LinkedList<>();
                freBucket[fre].add(val);
            }
        }
        int[] res=new int[k];
        int idx=freBucket.length-1, i=0;
        while(idx>=0) {
            if(freBucket[idx]!=null && !freBucket[idx].isEmpty()) {
                var iter=freBucket[idx].iterator();
                while(iter.hasNext()) {
                    res[i++]=iter.next();
                    if(i==k) return res;
                }
            }
            idx--;
        }
        return res;
    }
}