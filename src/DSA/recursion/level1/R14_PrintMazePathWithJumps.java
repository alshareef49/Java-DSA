package DSA.recursion.level1;

public class R14_PrintMazePathWithJumps {
    public static void main(String[] args) {
        // Question: Given a 2D grid (maze) of size m x n, print all possible paths
        // from the top-left corner (0,0) to the bottom-right corner (m-1,n-1).
        // You can jump any number of steps at a time in any direction (right, down, or diagonal).
        // Each path should be represented as a string where:
        // - 'h' followed by a number represents a horizontal jump
        // - 'v' followed by a number represents a vertical jump
        // - 'd' followed by a number represents a diagonal jump
        //
        // The function should have the following signature:
        // public static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String path)
        // Where:
        // - (sr, sc): current position (start with 0, 0)
        // - (dr, dc): destination position (m-1, n-1)
        // - path: current path taken (start with empty string)
        //
        // Example for 2x2 grid (from (0,0) to (1,1)):
        // printMazePathsWithJumps(0, 0, 1, 1, "");
        // Should print (order may vary):
        // h1v1
        // v1h1
        // d1
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If current position == destination: print path and return
        
        2. Recursive Cases:
           For each possible jump size (from 1 to max possible):
           - Horizontal Jump (h):
             1. If valid move (within bounds):
                - Add 'h' + jumpSize to path
                - Recurse with new position (sr, sc + jumpSize)
                
           - Vertical Jump (v):
             1. If valid move (within bounds):
                - Add 'v' + jumpSize to path
                - Recurse with new position (sr + jumpSize, sc)
                
           - Diagonal Jump (d):
             1. If valid move (within bounds for both row and column):
                - Add 'd' + jumpSize to path
                - Recurse with new position (sr + jumpSize, sc + jumpSize)
                
        Key Points:
        - Jump size can be 1 or more
        - Must check bounds before making each jump
        - The order of jumps matters
        - The empty string is not a valid path (must make at least one jump)
        */
        
        // Example usage for 2x2 grid
        System.out.println("All possible paths in 2x2 maze with jumps:");
        printMazePathsWithJumps(0, 0, 2, 2, "");
    }
    
    // TODO: Implement the recursive printMazePathsWithJumps function
    public static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String path) {
        // Your implementation here
        if(sr==dr && sc==dc){
            System.out.println(path);
            return;
        }
        // horizontal jumps
        for(int ms = 1;ms<=dc-sc;ms++){
            printMazePathsWithJumps(sr,sc+ms,dr,dc,"h"+ms+path);
        }
        // vertical jumps
        for(int ms = 1;ms<=dr-sr;ms++){
            printMazePathsWithJumps(sr+ms,sc,dr,dc,"v"+ms+path);
        }
        // diagonal jumps
        for(int ms = 1;ms<=dc-sc && ms<=dr-sr;ms++){
            printMazePathsWithJumps(sr+ms,sc+ms,dr,dc,"d"+ms+path);
        }
    }
}
