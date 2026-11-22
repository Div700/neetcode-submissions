class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLow = 0;
        int columnLow = 0;
        int rowHigh = matrix[0].length - 1;
        int columnHigh = matrix.length - 1;
        boolean answer = false;
        int columnSize = matrix[0].length - 1;
        int targetRow = -1;
        while(columnHigh >= columnLow) {
            int mid = (columnHigh + columnLow)/2;
            if(matrix[mid][columnSize] >= target) {
                targetRow = mid;
                columnHigh = mid-1;
            }
            else {
                columnLow = mid+1;
            }
        }
        if(targetRow == -1) return answer;
        while(rowHigh >= rowLow) {
            int mid = (rowHigh + rowLow)/2;
            if(matrix[targetRow][mid] == target) {
                answer = true;
                break;
            }
            else if(matrix[targetRow][mid] > target) {
                rowHigh = mid-1;
            }
            else {
                rowLow = mid+1;
            }
        }
        return answer;
    }
}
