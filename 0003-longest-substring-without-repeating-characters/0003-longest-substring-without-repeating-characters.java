class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] count = new int[128];
        int l = 0,r = 0;
        for(l=0,r=0;r<s.length();r++){
            count[s.charAt(r)]++;
            while(count[s.charAt(r)]>1){
                --count[s.charAt(l++)];
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}