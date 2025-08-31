package DSA.recursion.level1;

public class R18_NQueens {
    public static void main(String[] args) {
        // Question: The N-Queens puzzle is the problem of placing N chess queens on an N×N chessboard
        // such that no two queens threaten each other. This means that no two queens can be placed
        // in the same row, column, or diagonal.
        //
        // The function should have the following signature:
        // public static void printNQueens(boolean[][] board, int row, String psf)
        // Where:
        // - board: 2D boolean array representing the chessboard (true means queen is placed)
        // - row: Current row being considered (start with 0)
        // - psf: Path so far (start with empty string)
        //
        // Example for N=4:
        // printNQueens(new boolean[4][4], 0, "");
        // Should print all valid configurations, for example:
        // 0-1, 1-3, 2-0, 3-2,
        // 0-2, 1-0, 2-3, 3-1,
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If all rows are processed (row == board.length):
             - Print the current configuration
             - return
        
        2. Recursive Case:
           For each column in the current row:
           1. Check if it's safe to place queen at (row, col)
              - No queen in same column above
              - No queen in left diagonal above
              - No queen in right diagonal above
           2. If safe:
              - Place the queen
              - Recurse for next row
              - Backtrack: remove the queen

        Key Points:
        - Each row must have exactly one queen
        - Need to check column and both diagonals for safety
        - Backtracking is essential to explore all configurations
        - The solution prints queen positions as row-column pairs
        */
        
        // Example usage for 4x4 board
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println("All possible " + n + "-Queens configurations:");
        printNQueens(board, 0, "");
    }
    
    // TODO: Implement the recursive printNQueens function
    public static void printNQueens(boolean[][] board, int row, String psf) {
        // Your implementation here
        if(row==board.length){
            System.out.println(psf);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                printNQueens(board,row+1,psf+row+"-"+col+",");
                board[row][col] = false;
            }

        }
    }
    
    // TODO: Implement isSafe helper function
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check if placing queen at (row, col) is safe
        // Your implementation here
        //checking row
        for(int i=row-1,j=col;i>=0;i--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]){
                return false;
            }
        }

        return true;
    }
}
