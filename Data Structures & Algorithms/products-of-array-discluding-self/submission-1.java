class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        List<Integer> zeroIndexes = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
            product = product * nums[i];
            }
            else {
                zeroIndexes.add(i);
            }
        }
        int answer[]= new int[nums.length];
        if(zeroIndexes.size()>1) {
            return answer;
        }
        else if(zeroIndexes.size()==1) {
            int i = zeroIndexes.get(0);
            answer[i] = product;
        }
        else {
            for(int i=0;i<nums.length;i++) {
                answer[i] = (int)(product/nums[i]);
            }
        }
        return answer;
    }
}  
