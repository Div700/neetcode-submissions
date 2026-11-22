class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i=1;i<piles.length;i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        int low = 1;
        int high = max;
        int answer = max;
        while(high >=low) {
            int mid = low + (high-low)/2;
            long timeToEatBananas = 0;
            for(int i=0;i<piles.length;i++) {
                timeToEatBananas += (int) Math.ceil((double) piles[i] / mid);
            }
            if(timeToEatBananas<=h) {
                answer = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
