class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        int[] stdRow = row.stream().mapToInt(i -> i).toArray();
        int[] stdCol = col.stream().mapToInt(i -> i).toArray();

        for(int i = 0; i< stdRow.length; i++){
            int rowVal = stdRow[i];
            for(int j = 0; j<matrix[0].length; j++){
                matrix[rowVal][j] = 0;
            }
        }
        for(int i = 0; i< stdCol.length; i++){
            int colVal = stdCol[i];
            for(int j = 0; j<matrix.length; j++){
                matrix[j][colVal] = 0;
            }
        }
        // return matrix[][];
    }
}