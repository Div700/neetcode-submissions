class Solution {
    public boolean isPalindrome(String s) {
        String trimmedString = "";
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!isAlphaNumeric(c)) continue;
            trimmedString = trimmedString + c;
        }
        int start = 0;
        int end = trimmedString.length() - 1;
        boolean isPalindrome = true;
        while(end>start) {
            char c1 = trimmedString.charAt(start);
            char c2 = trimmedString.charAt(end);
            if(c1!=c2) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrome;
    }

    boolean isAlphaNumeric(char c) {
        if(((c >= 'a') && (c<='z')) || ((c >= '0') && (c<='9'))) return true;
        return false;
    }
}
