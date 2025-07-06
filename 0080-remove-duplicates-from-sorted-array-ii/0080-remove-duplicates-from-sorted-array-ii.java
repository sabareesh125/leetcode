class Solution {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        int count = 0;
        for(int num: nums) {
            if(k == 0 || (count < 2 && num == nums[k - 1])) {
                nums[k++] = num;
                ++count;
            } else if(num != nums[k - 1]) {
                nums[k++] = num;
                count = 1;
            }
        }
        return k;
    }
}