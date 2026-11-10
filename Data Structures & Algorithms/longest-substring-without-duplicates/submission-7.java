class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;

        Map<Character, Integer> characterIndex = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (characterIndex.containsKey(c)) {
                left = Math.max(left, characterIndex.get(c) + 1);
            }
            characterIndex.put(c, right);
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}