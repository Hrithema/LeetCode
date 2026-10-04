class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0; int endRow = m-1;
        while(startRow <= endRow){
            int midRow = startRow+(endRow-startRow)/2;
            int start = 0;
            int end = n-1;
            while(end>=start && target>= matrix[midRow][0] && target <= matrix[midRow][n-1]){
                int mid = start+(end-start)/2;
                if(target == matrix[midRow][mid]){
                    return true;
                }else if(target > matrix[midRow][mid]){
                    start = mid+1;
                }else{
                    end = mid -1;
                }
            }
            if(target >= matrix[midRow][n-1]){
                startRow = midRow+1;
            }
            else{
                endRow = midRow-1;
            }
        }
        return false;
    }
}