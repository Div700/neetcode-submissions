class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums);
        Map<Integer, List<Integer>> countMap = new HashMap<>();

        int[] answer = new int[k];
        int count = 1;
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                List<Integer> arrayList = countMap.get(count);

                if (arrayList != null) {
                    arrayList.add(current);
                } else {
                    arrayList = new ArrayList<>();
                    arrayList.add(current);
                    countMap.put(count, arrayList);
                }

                current = nums[i];
                count = 1;
            } else {
                count++;
            }
        }

        // Add the last element
        List<Integer> arrayList = countMap.get(count);

        if (arrayList != null) {
            arrayList.add(current);
        } else {
            arrayList = new ArrayList<>();
            arrayList.add(current);
            countMap.put(count, arrayList);
        }

        // Sort frequencies in descending order
        List<Integer> frequencies = new ArrayList<>(countMap.keySet());
        Collections.sort(frequencies, Collections.reverseOrder());

        // Collect elements until we have k elements
        int index = 0;

        for (int frequency : frequencies) {
            for (int num : countMap.get(frequency)) {
                answer[index++] = num;

                if (index == k) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
