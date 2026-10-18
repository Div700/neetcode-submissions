class Solution {
    public boolean isAnagram(String s, String t) {
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int exists = t.indexOf(c);
            if(exists == -1) {
                return false;
            }
            else {
                if(exists!=(t.length() -1)) {
                    t = t.substring(0,exists) + t.substring(exists+1);
                } else {
                    t = t.substring(0,exists);
                }
            }
        }
        if(t.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
