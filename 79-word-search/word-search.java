class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int k){
        // Entire word is found
        if(k == word.length()){
            return true;
        }
        
        // out of bounds
        if(i < 0 || i>= board.length || j<0 || j>= board[0].length){
            return false;
        }
        
        
        //characters don't match
        if(board[i][j] != word.charAt(k)){
            return false;
        }
        

        // Marking current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // chechking all the directions
        boolean found = dfs(board, word, i+1, j, k+1) ||
                        dfs(board, word, i-1, j, k+1) ||
                        dfs(board, word, i, j+1, k+1) ||
                        dfs(board, word, i, j-1, k+1);
        
        board[i][j] = temp;

        return found;
    }
}