package DSA.recursion.level1;

public class R19_KnightTour {
    public static void main(String[] args) {
        // Question: The Knight's Tour is a sequence of moves of a knight on a chessboard
        // such that the knight visits every square exactly once. Given a chessboard of size N×N,
        // find and print all possible tours of a knight starting from a given position.
        //
        // The function should have the following signature:
        // public static void printKnightTour(int[][] chess, int row, int col, int move)
        // Where:
        // - chess: 2D array representing the chessboard (0 means unvisited, >0 means move number)
        // - row, col: Current position of the knight
        // - move: Current move number (start with 1)
        //
        // Example for 5x5 board starting at (2,2):
        // printKnightTour(new int[5][5], 2, 2, 1);
        // Will print one possible solution where numbers show the order of moves.
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If move == total cells (N*N):
             - Print the chessboard with move numbers
             - return
        
        2. Recursive Case:
           For each of the 8 possible moves a knight can make:
           1. Calculate next position (newRow, newCol)
           2. If the new position is valid (within bounds and unvisited):
              - Mark the current position with move number
              - Recurse for the next move
              - Backtrack: unmark the current position

        Key Points:
        - A knight moves in an L-shape: 2 squares in one direction and then 1 square perpendicular
        - Need to check all 8 possible moves from each position
        - The solution uses backtracking to explore all possible paths
        - The chessboard is marked with move numbers to show the path
        */
        
        // Example usage for 5x5 board starting at (2,2)
        int n = 5;
        int[][] chess = new int[n][n];
        int row = 2, col = 2;
        System.out.println("Knight's Tour starting at (" + row + ", " + col + "):");
        printKnightTour(chess, row, col, 1);

    }
    
    // All 8 possible moves a knight can make (row, col offsets)
    private static final int[][] moves = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };


    // TODO: Implement the recursive printKnightTour function
    public static void printKnightTour(int[][] chess, int row, int col, int move) {
        // Your implementation here

        if(row<0 || col<0 || row>=chess.length || col>=chess.length || !isValid(chess,row,col)){
            return;
        }else if(move==chess.length*chess.length){
            chess[row][col]=move;
            printChessboard(chess);
            chess[row][col]=0;
            return;
        }

        for (int[] mv:moves){

                chess[row][col] = move;
                printKnightTour(chess,row+mv[0],col+mv[1],move+1);
                chess[row][col] = 0;

        }

    }
    
    // Helper method to check if a position is valid
    private static boolean isValid(int[][] chess, int row, int col) {
        return row >= 0 && row < chess.length && 
               col >= 0 && col < chess[0].length && 
               chess[row][col] == 0;
    }
    
    // Helper method to print the chessboard
    private static void printChessboard(int[][] chess) {
        for (int[] row : chess) {
            for (int val : row) {
                System.out.print(String.format("%2d ", val));
            }
            System.out.println();
        }
        System.out.println();
    }
}
