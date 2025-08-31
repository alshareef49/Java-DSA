package DSA.recursion.level1;

import java.util.ArrayList;
import java.util.List;

public class R9_GetMazePathWithJumps {
    public static void main(String[] args) {
        // Question: Find all possible paths from top-left to bottom-right of a m x n grid
        // with the ability to make jumps. You can make horizontal jumps of any size (h1, h2, ...)
        // vertical jumps of any size (v1, v2, ...), and diagonal jumps of any size (d1, d2, ...).
        // The number after the letter represents the jump size.
        //
        // For example, in a 3x3 grid (0,0 to 2,2):
        // "h1v1d1" means: move right 1, down 1, then diagonal 1
        // "d2" means: move diagonally from (0,0) to (2,2) in one jump
        // "v2h2" means: move down 2, then right 2
        //
        // The function should have the following signature:
        // public static List<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc)
        // Where:
        // - (sr, sc) = source row and column (starting position, typically 0,0)
        // - (dr, dc) = destination row and column (target position)
        //
        // Example for 2x2 grid (0,0 to 1,1):
        // getMazePathsWithJumps(0, 0, 1, 1)
        // Should return: [h1v1, v1h1, d1]  (order may vary)
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If current position == destination: return [""] (empty path, we've reached)
           - If out of grid bounds: return [] (invalid path)
        
        2. Recursive Case:
           For each possible jump size (from 1 to max possible in that direction):
           - Get all paths by making a horizontal jump right (h1, h2, ...)
           - Get all paths by making a vertical jump down (v1, v2, ...)
           - Get all paths by making a diagonal jump (d1, d2, ...)
        
        3. Combine Results:
           - For each valid jump, prepend the jump direction and size to all paths
           - Combine all paths from all three directions
        
        Key Points:
        - Need to check grid bounds for each jump size
        - Each jump must be at least size 1
        - For diagonal jumps, both row and column must be within bounds
        */
        
        // Example usage for 2x2 grid (0,0 to 1,1)
        List<String> paths = getMazePathsWithJumps(0, 0, 2, 2);
        System.out.println("All possible paths with jumps in 2x2 grid:");
        System.out.println(paths);
    }
    
    // TODO: Implement the recursive getMazePathsWithJumps function here
    public static List<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {

        if(sr==dr && sc==dc){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> result = new ArrayList<>();
        //horizontal moves
        for (int ms = 1;ms<=dc-sc;ms++){
            List<String> hPaths = getMazePathsWithJumps(sr,sc+ms,dr,dc);
            for(String path:hPaths){
                result.add("h"+ms+path);
            }
        }

        //vertical moves
        for(int ms = 1;ms<=dr-sr;ms++){
            List<String> vPaths = getMazePathsWithJumps(sr+ms,sc,dr,dc);
            for(String path:vPaths){
                result.add("v"+ms+path);
            }
        }

        //diagonal moves
        for(int ms=1;ms<=dr-sr && ms<=dc-sc;ms++){
            List<String> dPaths = getMazePathsWithJumps(sr+ms,sc+ms,dr,dc);
            for(String path:dPaths){
                result.add("d"+ms+path);
            }
        }

        return result;


    }
}
