class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        TreeMap<Integer,Integer> sortedElements = new TreeMap<>(Comparator.reverseOrder());
        int answer[] = new int[nums.length - k +1];
        int left = 0;
        int right = 0;
        int x=0;
        while(right<nums.length) {
            int ele = nums[right];
            sortedElements.put(ele,right);
            if(right-left+1 == k) {
                int max = sortedElements.firstKey();
                answer[x] = max;
                x++;
                int indexToSkip = sortedElements.get(nums[left]);
                if(indexToSkip == left) {
                    sortedElements.remove(nums[left]);
                }
                left ++;
            }
            right++;
        }
        return answer;
    }
}
