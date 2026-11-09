class Solution {
    public int maxArea(int[] heights) 
    {
        int maximum = 0;
        int start = 0;
        int end = heights.length - 1;
        while(start<end){
            int effectiveHeight = Math.min(heights[start],heights[end]);
            int waterVolume = effectiveHeight * (end-start);
            if(waterVolume>maximum) maximum = waterVolume;
            if(heights[start]<heights[end]) start ++;
            else if (heights[end]<heights[start]) end--;
            else start++;
        }    
        return maximum;
    }
}
