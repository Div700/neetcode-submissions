class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int target = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                if (nums[start] + nums[end] == target) {

                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);

                    answer.add(triplet);

                    // Move both pointers instead of break
                    start++;
                    end--;

                    // Skip duplicates
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }

                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }

                } else {
                    int startNeed = target - nums[start];
                    int endNeed = target - nums[end];

                    if (endNeed < nums[start]) {
                        end--;
                    } else if (startNeed > nums[end]) {
                        start++;
                    }
                }
            }
        }

        return answer;
    }
}