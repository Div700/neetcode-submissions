class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> count1 = new HashMap<>();
        Map<Character,Integer> count2 = new HashMap<>();
        for(int i=0;i<(s.length());i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(count1.containsKey(c1)){
                int existing = count1.get(c1);
                count1.put(c1,existing+1);
            }
            else {
                count1.put(c1,1);
            }
                        if(count2.containsKey(c2)){
                int existing = count2.get(c2);
                count2.put(c2,existing+1);
            }
            else {
                count2.put(c2,1);
            }
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
if (count2.get(c) == null || !count1.get(c).equals(count2.get(c))) {
    return false;
}
        }
        return true;
    }
}
