class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSubSequence = 0;
        int subSequence = 0;
        int left =0;
        Map<Character,Integer> characterIndex = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(characterIndex.containsKey(c)) {
                longestSubSequence = Math.max(subSequence,longestSubSequence);
                int duplicateIndex = characterIndex.get(c);
                for(int j=left;j<=duplicateIndex;j++){
                    char toRemove = s.charAt(j);
                    characterIndex.remove(toRemove);
                    subSequence--;
                }
                left = duplicateIndex+1;
                subSequence++;
                characterIndex.put(c, i);
            }
            else {
                subSequence++;
                characterIndex.put(c,i);
            }
        }
        return Math.max(longestSubSequence,subSequence);
    }
}
