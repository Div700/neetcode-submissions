class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        int setSize = set.size();
        int originalSize = nums.length;
        if(setSize < originalSize) {
            return true;
        }
        else{
            return false;
        }
    }
}