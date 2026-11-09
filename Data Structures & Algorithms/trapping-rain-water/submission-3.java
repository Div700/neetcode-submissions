class Solution {
    public int trap(int[] height) 
    {
        int maximumLeft[] = new int[height.length];
        int maximumRight[] = new int[height.length];
        int maxL = 0;
        int maxR = 0;
        int trappedWater = 0;
        for(int i=0;i<height.length;i++){
            maximumLeft[i] = maxL;
            if(height[i]>maxL) {
                maxL = height[i];
            }
        }
        for(int i=height.length - 1;i>=0;i--){
            maximumRight[i] = maxR;
            if(height[i]>maxR) {
                maxR = height[i];
            }
        }
        for(int i=0;i<height.length;i++) {
            int indexWater = Math.min(maximumLeft[i],maximumRight[i]) - height[i];
            if(indexWater>0) {
                trappedWater+=indexWater;
            }
        }
        return trappedWater;
    }
}
