class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        String str[]=s.split("");
        String str2[]=t.split("");
        Arrays.sort(str);
        Arrays.sort(str2);
        return Arrays.equals(str,str2);
    }
}