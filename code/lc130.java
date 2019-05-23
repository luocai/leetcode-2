package code;
/*
 * 130. Surrounded Regions
 * 题意：把被 X 包围的 O 填补成 X
 * 难度：Medium
 * 分类：Depth-first Search, Breadth-first Search
 * 思路：把四条外围边框的O向内延伸填为1，剩下的O全部替换为X，再把1替换成O
 * Tips：
 */
public class lc130 {
    
    
     // 对边界的点做dfs，把 O换成 Y
    // 遍历整个图， 把 O 换成 X, Y 换成 O
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return ;
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < row; i++){
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }
        for(int i = 0; i < col ; i++){
            dfs(board, 0, i);
            dfs(board, row -1, i);
        }
        
        for(int i = 0; i < row ;i++){
            for(int j = 0; j < col ;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j){
        
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
          board[i][j] == 'X' || board[i][j] == 'Y')
            return ;
        
        board[i][j] = 'Y';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
    
    --------------------
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        System.out.println(board);
    }
    public static void solve(char[][] board) {
        if(board.length==0) return;
        int[] row = {0, board.length-1};
        for (int i = 0; i <row.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
               if(board[row[i]][j]=='O'){     // 注意是row[i]，不是i
                    dfs(board, row[i], j);
                }
            }
        }
        int[] col = {0, board[0].length-1};
        for (int i = 0; i <col.length ; i++) {
            for (int j = 0; j < board.length ; j++) {
                if(board[j][col[i]]=='O'){
                    dfs(board, j, col[i]);
                }
            }
        }
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j]=='1')
                    board[i][j] = 'O';
                else if(board[i][j]=='O')
                    board[i][j] = 'X';
            }
        }
    }

    public static void dfs(char[][] board, int row, int col){
        if(row<0||row>=board.length||col<0||col>=board[0].length) return;
        if(board[row][col]=='O') {  //是 O 的话才继续递归
            board[row][col] = '1';
            dfs(board, row + 1, col);
            dfs(board, row - 1, col);
            dfs(board, row, col + 1);
            dfs(board, row, col - 1);
        }
    }
}
