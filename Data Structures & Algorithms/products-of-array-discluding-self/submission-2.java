class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroIndex = -1;
        int answer[]= new int[nums.length];
        List<Integer> zeroIndexes = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
            product = product * nums[i];
            }
            else {
                if(zeroIndex!=-1){
                    // means that zero index was already identified still second time 0 is present in array
                    return answer;
                }
                else {
                    zeroIndex = i;
                }
            }
        }
        if(zeroIndex != -1) {
            answer[zeroIndex] = product;
        }
        else {
            for(int i=0;i<nums.length;i++) {
                answer[i] = (int)(product/nums[i]);
            }
        }
        return answer;
    }
}  
