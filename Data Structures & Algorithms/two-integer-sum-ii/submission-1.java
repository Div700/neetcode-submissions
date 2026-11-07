class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int start = 0;
       int end = numbers.length - 1;
       int answer[] = new int[2];
       while(end > start) {
        if(numbers[start] + numbers[end] == target) {
            answer[0] = start+1;
            answer[1] = end+1;
            return answer;
        }
        int startNeed = target - numbers[start];
        int endNeed = target - numbers[end];
        if(endNeed < numbers[start]) {
            // the number present at end can not be one of the numbers
            end --;
        }
        else if(startNeed > numbers[end]) {
            // the number present at start can not be one of the numbers
            start ++;
        }
       } 
       return answer;
    }
}
