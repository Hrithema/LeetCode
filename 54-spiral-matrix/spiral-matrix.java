class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while(startRow <= endRow && startCol <= endCol) {

            // Top row
            for(int j = startCol; j <= endCol; j++) {
                ans.add(matrix[startRow][j]);
            }

            // Right column
            for(int i = startRow + 1; i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
            }

            // Bottom row
            if(startRow < endRow) {
                for(int j = endCol - 1; j >= startCol; j--) {
                    ans.add(matrix[endRow][j]);
                }
            }

            // Left column
            if(startCol < endCol) {
                for(int i = endRow - 1; i >= startRow + 1; i--) {
                    ans.add(matrix[i][startCol]);
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return ans;
    }
}