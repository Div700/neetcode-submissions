class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        int left = 0;
        int right = left + s1.length();
        while(right<=s2.length()) {
            String currentSubString = s2.substring(left,right);
            System.out.println(currentSubString);
            boolean permutationExists = permutationExists(currentSubString,s1);
            if(permutationExists) return true;
            right++;
            left++;
        }    
        return false;
    }

    boolean permutationExists(String subString,String target) {
        for(int i=0;i<subString.length();i++) {
            char c = subString.charAt(i);
            int index = target.indexOf(c);
            if(index==-1) return false;
            if(index == target.length()-1) {
                target = target.substring(0,index);
            }
            else {
            target = target.substring(0,index) + target.substring(index+1,target.length());
            }
        }
        if(target.isEmpty()) return true;
        else return false;
    }
}
