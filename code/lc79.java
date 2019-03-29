package code;
/*
 * 79. Word Search
 * 题意：在字符数组中搜索字符串
 * 难度：Medium
 * 分类：Array, Backtracking
 * 思路：回溯法
 * Tips：访问过的格子要标记，不能重复访问。回溯法注意回来的时候要重置标志位。向下找的时候直接找4个方向的，回来的时候不用再找了，只需重置标志位。
 *       不用mem，因为 ABC ABAD 这种情况，不能仅仅从A一个字符就断定为不为true
 */
public class lc79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"SEE"));
    }

     //典型的回溯法 
    public boolean exist(char[][] board, String word) {
        
        //访问位
        boolean[][] flag = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(judge(board, word, i,j,0,flag))
                    return true;
            }
        }
     
     return false;   
        
    }
    
    public boolean judge(char[][] board, String word, int i, int j,int index,boolean[][] flag){
        
        if(index == word.length())
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] == true || board[i][j] != word.charAt(index)){
            return false;
        }
        
        
        //设置访问 ， 访问结束后要释放
        flag[i][j] = true;
        index++;
        boolean res = judge(board, word, i+1, j, index, flag) || judge(board,word, i-1, j, index , flag) || judge(board, word, i,j+1, index, flag) || judge(board, word, i, j-1, index, flag);
        flag[i][j] = false;
        
        return res;
        
    }
}
