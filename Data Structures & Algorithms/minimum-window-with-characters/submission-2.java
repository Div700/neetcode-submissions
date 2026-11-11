class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int left = 0;
        int right = 0;

        Map<Character, Integer> sFrequency = new HashMap<>();
        Map<Character, Integer> tFrequency = new HashMap<>();

        String answer = "";
        int minLength = Integer.MAX_VALUE;

        // Frequency of characters required
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            tFrequency.put(c, tFrequency.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {

            char rightChar = s.charAt(right);

            // Add character entering the window
            sFrequency.put(
                rightChar,
                sFrequency.getOrDefault(rightChar, 0) + 1
            );

            // If current window is valid, try shrinking it
            while (isValidSubString(sFrequency, tFrequency)) {

                String currentSubString =
                    s.substring(left, right + 1);

                if (currentSubString.length() < minLength) {
                    answer = currentSubString;
                    minLength = currentSubString.length();
                }

                // Remove left character and shrink window
                char leftChar = s.charAt(left);

                decrementCount(sFrequency, leftChar);

                left++;
            }

            right++;
        }

        return answer;
    }


    boolean isValidSubString(
        Map<Character, Integer> sFrequency,
        Map<Character, Integer> tFrequency
    ) {

        for (char c : tFrequency.keySet()) {

            if (sFrequency.getOrDefault(c, 0)
                    < tFrequency.get(c)) {
                return false;
            }
        }

        return true;
    }


    void decrementCount(
        Map<Character, Integer> sFrequency,
        char c
    ) {

        sFrequency.put(c, sFrequency.get(c) - 1);
    }
}