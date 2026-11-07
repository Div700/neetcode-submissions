class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        boolean isPalindrome = true;
        while(end>start) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if(!isAlphaNumeric(c1)) {
                start ++;
                continue;
            }
            if(!isAlphaNumeric(c2)) {
                end --;
                continue;
            }
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
