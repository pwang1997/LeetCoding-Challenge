```java
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length < 1){
            return 0;
        }
        
        int[][] memo = new int[matrix.length][matrix[0].length];
        int count = 0;
        
        for(int[] row :memo){
           Arrays.fill(row, -1); 
        }

        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(memo[i][j] != -1){
                    continue;
                }
                
                count = Math.max(count, helper(matrix, memo, i, j, Integer.MIN_VALUE));
            }
        }
        return count;
    }
    
    public int helper(int[][] matrix, int[][] memo, int row, int col, int prev){
        if(row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0){
            return 0;
        }
        
        if(matrix[row][col] <= prev){
            return 0;
        }
        
        if(memo[row][col] != -1){
            return memo[row][col] + 1;
        }
        
        int[] dirX = new int[]{0,1,0,-1};
        int[] dirY = new int[]{1,0,-1,0};
        
        int count = 0;
        for(int i = 0; i < dirX.length;i++){
            count = Math.max(count, helper(matrix, memo, row + dirX[i], col + dirY[i], matrix[row][col]));
        }
        
        memo[row][col] = count;
        
        return count + 1;
        
    }
}
```