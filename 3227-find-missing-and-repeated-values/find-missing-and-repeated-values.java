class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = 0;
        int b = 0;
        int n = grid.length;
        int [] freq = new int [(n*n)];
        for (int i = 0; i< n; i++){
            for( int j = 0; j<n; j++){
                freq[grid[i][j]-1]++;
            }
        }
        for (int i = 0; i< (n*n); i++){
            if (freq[i] == 0){
                b = i+1;
            } else if (freq[i]>1){
                a = i+1;
            }
        }
        int ans [] = {a, b};
        return ans;
    }
}