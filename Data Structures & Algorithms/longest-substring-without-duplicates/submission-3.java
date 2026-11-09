class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueCharacters = new HashSet<>();
        int longestSubSequence = 0;
        int subSequence = 0;
        int i = 0;
        int start = 0;
        while(i<s.length()) {
            char c = s.charAt(i);
            if(uniqueCharacters.contains(c)) {
                if(subSequence>longestSubSequence) {
                    longestSubSequence = subSequence;
                }
                uniqueCharacters.clear();
                subSequence = 0;
                i = start + 1;
                start ++;
            }
            else {
                subSequence++;
                uniqueCharacters.add(c);
                i++;
            }
        }
        return Math.max(subSequence,longestSubSequence);
    }
}
