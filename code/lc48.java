package code;
/*
 * 48. Rotate Image
 * 题意：将数组顺时针翻转90度
 * 难度：Medium
 * 分类：Array
 * 思路：两种思路：先对角，再以竖轴对称；先以横轴对称，再对角.思路很新奇，记一下.
 */
public class lc48 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArr(matrix);
        rotate(matrix);
        System.out.println();
        printArr(matrix);
    }
    public void rotate(int[][] matrix) {
        
		//用十字架的方式思考，先把十字架转180 ，在 左对角线 取对称。到90 度的位置
		//先转180度
		
		if(matrix == null && matrix.length == 0)
			return;
		
        //先转180 度    matrix[i][j] = matrix[matrix.length - i - 1][j];
		for(int i = 0; i < matrix.length / 2;i++){
			
			for(int j = 0; j < matrix[i].length ; j++ ){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - i - 1][j];
				matrix[matrix.length-i-1][j] = temp;
			}
		}
		
//		for(int i = 0; i < matrix.length;i++){
//			for(int j = 0; j < matrix[i].length; j++){
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		//左对角线对称  matrix[i][j] = matrix[j][i];
	    	//左对角线对称  (0,0) -> 右下角的点
		for(int i = 0; i < matrix.length; i++){
			for(int j = i+1; j < matrix[0].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
//		System.out.println();
//		for(int i = 0; i < matrix.length;i++){
//			for(int j = 0; j < matrix[i].length; j++){
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
    }
}
