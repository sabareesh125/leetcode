class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int radiant = 0;
        int dire = 0;
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant++;
                r.offer(i);
            } else {
                dire++;
                d.offer(i);
            }
        }
        while (!r.isEmpty() &&!d.isEmpty()) {
            int rindex = r.poll();
            int dindex = d.poll();
            if (rindex < dindex) {
                r.offer(rindex + n);
                dire--;
            } else {
                d.offer(dindex + n);
                radiant--;
            }
        }
        return radiant > dire? "Radiant" : "Dire";
    }
}