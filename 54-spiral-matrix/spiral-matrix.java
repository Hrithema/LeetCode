class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0, startCol =0;
        int endRow = matrix.length-1, endCol = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(startRow<=endRow && startCol <= endCol){
            // top
            for(int j = startCol; j<= endCol; j++){
                ans.add(matrix[startRow][j]);
            }

            // right
            for(int i = startRow+1; i<= endRow; i++){
                // if(startCol>=endCol) break;
                ans.add(matrix[i][endCol]);
            }

            // bottom
            if(startRow < endRow){   
                for(int j = endCol-1; j>= startCol; j--){
                    ans.add(matrix[endRow][j]);
                }
            }
            // left
            if(startCol < endCol){
                for(int i = endRow-1; i>= startRow+1; i--){
                    ans.add(matrix[i][startCol]);
                }
            }
            startRow++; startCol++; endCol--; endRow--;
        }
        return ans;
    }
}