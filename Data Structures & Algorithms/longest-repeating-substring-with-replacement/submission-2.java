class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> frequencyCount = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            incrementFrequency(frequencyCount, c);

            int currentWindowLength = right - left + 1;
            int maxFrequency = getMaxFrequency(frequencyCount);

            if (currentWindowLength - maxFrequency > k) {
                char toRemove = s.charAt(left);
                decrementFrequency(frequencyCount, toRemove);
                left++;
                currentWindowLength = right - left + 1;
            }

            maxLength = Math.max(maxLength, currentWindowLength);

            right++;
        }

        return maxLength;
    }

    int getMaxFrequency(Map<Character, Integer> frequencyCount) {
        int maxLen = 0;

        for (int value : frequencyCount.values()) {
            maxLen = Math.max(maxLen, value);
        }

        return maxLen;
    }

    void incrementFrequency(Map<Character, Integer> frequencyCount, char c) {
        frequencyCount.put(c, frequencyCount.getOrDefault(c, 0) + 1);
    }

    void decrementFrequency(Map<Character, Integer> frequencyCount, char c) {
        frequencyCount.put(c, frequencyCount.get(c) - 1);
    }
}