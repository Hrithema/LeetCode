class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        return found(matrix, target, i, j);
    }
    public boolean found(int[][] matrix, int target, int i, int j){
        if(i >= matrix.length) return false;
        if(j < 0) return false;
        if(matrix[i][j]==target) return true;
        else{
            if(matrix[i][j]>target){
                if(found(matrix, target, i, j-1)) return true;
            }else if(found(matrix, target, i+1, j)) return true;
        }
        return false;
    }
}