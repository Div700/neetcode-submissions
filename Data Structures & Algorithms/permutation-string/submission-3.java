class Solution {

    public boolean checkInclusion(String s1, String s2) 
    {
        int left = 0;
        int right = left + s1.length();

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] targetFrequency = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            targetFrequency[s1.charAt(i) - 'a']++;
        }

        while (right <= s2.length()) {

            String currentSubString = s2.substring(left, right);

            boolean permutationExists =
                permutationExists(currentSubString, targetFrequency);

            if (permutationExists) {
                return true;
            }

            right++;
            left++;
        }

        return false;
    }

    boolean permutationExists(String subString, int[] targetFrequency) {

        int[] frequency = targetFrequency.clone();

        for (int i = 0; i < subString.length(); i++) {

            char c = subString.charAt(i);

            frequency[c - 'a']--;
            if (frequency[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}