package DSA.recursion.level1;

import java.util.ArrayList;
import java.util.List;

public class R8_GetMazePath {
    public static void main(String[] args) {
        // Question: Find all possible paths from top-left to bottom-right of a m x n grid
        // You can only move right (h) or down (v) at each step.
        // Return the result as a list of strings where each string represents a path.
        // For example, "hvhv" means move right, down, right, down.
        //
        // The function should have the following signature:
        // public static List<String> getMazePaths(int sr, int sc, int dr, int dc)
        // Where:
        // - (sr, sc) = source row and column (starting position, typically 0,0)
        // - (dr, dc) = destination row and column (target position)
        //
        // Example for 2x2 grid (1x1 matrix with 0-based indexing):
        // getMazePaths(0, 0, 1, 1)
        // Should return: [hv, vh]  (order may vary)
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If current position == destination: return [""] (empty path, we've reached)
           - If out of grid bounds: return [] (invalid path)
        
        2. Recursive Case:
           - Get all paths by moving right (h) from current position
           - Get all paths by moving down (v) from current position
        
        3. Combine Results:
           - Prepend 'h' to all paths from right move
           - Prepend 'v' to all paths from down move
           - Combine both lists of paths
        
        Time Complexity: O(2^(m+n)) where m = rows, n = columns
        - At each step, we have 2 choices (right or down)
        - In the worst case, the path length is (m+n) steps
        
        Space Complexity: O(2^(m+n)) for storing all possible paths
        - Each path can be of length (m+n) in the worst case
        - There are 2^(m+n) possible paths in the worst case
        */
        
        // Example usage for 2x2 grid (1x1 matrix with 0-based indexing)
        List<String> paths = getMazePaths(0, 0, 2, 2);
        System.out.println(paths);
    }
    
    /**
     * Returns all possible paths from (sr,sc) to (dr,dc) in a grid
     * @param sr Source row
     * @param sc Source column
     * @param dr Destination row
     * @param dc Destination column
     * @return List of all possible paths as strings of 'h' and 'v' moves
     */
    public static List<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if(sr==dr && sc==dc){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> hPaths = new ArrayList<>();
        List<String> vPaths = new ArrayList<>();
        List<String> res = new ArrayList<>();

        if(sc<dc){
            hPaths = getMazePaths(sr,sc+1,dr,dc);
        }
        if(sr<dr){
            vPaths = getMazePaths(sr+1,sc,dr,dc);
        }

        for(String path:hPaths){
            res.add("h"+path);
        }
        for(String path:vPaths){
            res.add("v"+path);
        }
        return res;


    }
}
