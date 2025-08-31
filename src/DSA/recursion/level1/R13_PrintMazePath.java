package DSA.recursion.level1;

public class R13_PrintMazePath {
    public static void main(String[] args) {
        // Question: Given a 2D grid (maze) of size m x n, print all possible paths
        // from the top-left corner (0,0) to the bottom-right corner (m-1,n-1).
        // You can only move right or down at each step.
        //
        // The function should have the following signature:
        // public static void printMazePaths(int sr, int sc, int dr, int dc, String path)
        // Where:
        // - (sr, sc): current position (start with 0, 0)
        // - (dr, dc): destination position (m-1, n-1)
        // - path: current path taken (start with empty string)
        //
        // Example for 2x2 grid (from (0,0) to (1,1)):
        // printMazePaths(0, 0, 1, 1, "");
        // Should print (order may vary):
        // h1v1
        // v1h1
        //
        /* PSEUDO APPROACH:
        1. Base Cases:
           - If current position == destination: print path and return
           - If out of grid bounds: return
        
        2. Recursive Cases:
           - Move Right (h):
             1. Add 'h1' to path
             2. Recurse with (sr, sc+1)
             
           - Move Down (v):
             1. Add 'v1' to path
             2. Recurse with (sr+1, sc)
             
        Key Points:
        - 'h1' represents a horizontal move of 1 step
        - 'v1' represents a vertical move of 1 step
        - The order of moves matters (h1v1 is different from v1h1)
        - The sum of 'h's in path = total columns - 1
        - The sum of 'v's in path = total rows - 1
        */
        
        // Example usage for 2x2 grid
        System.out.println("All possible paths in 2x2 maze:");
        printMazePaths(0, 0, 2, 2, "");
    }
    
    // TODO: Implement the recursive printMazePaths function
    public static void printMazePaths(int sr, int sc, int dr, int dc, String path) {
        // Your implementation here
        if(sr==dr && sc==dc){
            System.out.println(path);
            return;
        }
        if(sc<dc){
            printMazePaths(sr,sc+1,dr,dc,"h"+path);
        }
        if(sr<dr){
            printMazePaths(sr+1,sc,dr,dc,"v"+path);
        }
    }
}
