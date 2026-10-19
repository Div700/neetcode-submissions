class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int answer[] = new int[2];
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            hashMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++) {
            int remaining = target - nums[i];
            if(hashMap.containsKey(remaining)) {
                int secondIndex = hashMap.get(remaining);
                if(secondIndex != i) {
                answer[0] = i;
                answer[1] = secondIndex;
                break;
                }
            } 
        }
        return answer;
    }
}
