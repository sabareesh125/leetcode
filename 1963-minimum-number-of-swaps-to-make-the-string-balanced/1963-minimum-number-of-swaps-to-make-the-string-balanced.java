class Solution {
    public int minSwaps(String s) {
      int n=s.length(); 
      int open=0;
      int close=0;
      int swap=0;
       for(int i=0;i<n;i++){
        if(s.charAt(i)=='['){
            open++;
        }
        else{
            close++;
        }
        if(close>open){
            swap++;
            open++;
            close--;        
            }

       }
       return swap;
    }
}