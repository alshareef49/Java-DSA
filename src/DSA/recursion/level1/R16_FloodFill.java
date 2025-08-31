package DSA.recursion.level1;

public class R16_FloodFill {
    public static void main(String[] args) {
        // Question: Given a 2D grid representing a maze where:
        // - 0 represents an open cell (can move here)
        // - 1 represents an obstacle (cannot move here)
        // Find and print all possible paths from the top-left corner (0,0) to the 
        // bottom-right corner (m-1,n-1).
        // You can only move right or down at each step.
        //
        // The function should have the following signature:
        // public static void findPaths(int[][] maze, int row, int col, String path)
        // Where:
        // - maze: The 2D grid representing the maze
        // - row, col: Current position in the maze
        // - path: Current path taken (start with empty string)
        //
        // Example:
        // int[][] maze = {
        //     {0, 0, 0},
        //     {0, 1, 0},
        //     {0, 0, 0}
        // };
        // findPaths(maze, 0, 0, "");
        // Should print:
        // DDRR
        // RRDD
        //
        /* PSEUDO APPROACH:
        1. Base Cases:
           - If current cell is out of bounds: return
           - If current cell is an obstacle (1) or already visited: return
           - If reached destination (m-1, n-1): print path and return
        
        2. Recursive Case:
           1. Mark current cell as visited (by setting it to 1)
           2. Try moving in all 4 directions (Down, Right, Up, Left)
              - Add direction to path ('D', 'R', 'U', 'L')
              - Recurse to the next cell
              - Backtrack: remove the direction from path
           3. Unmark current cell (set back to 0) for other paths

        Key Points:
        - Must check boundaries before moving
        - Need to mark cells as visited to prevent cycles
        - Must unmark cells when backtracking to explore other paths
        - The order of direction checks affects the order of paths found
        */
        
        // Example usage
        int[][] maze = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
                { 1, 0, 0}
        };
        
        System.out.println("All possible paths in the maze:");
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        findPaths(maze, 0, 0, visited,"");
    }
    
    // TODO: Implement the recursive findPaths function
    public static void findPaths(int[][] maze, int row, int col, boolean[][] visited,String path) {
        // Your implementation here

        if(row<0 || col<0 || row==maze.length || col==maze[0].length || maze[row][col]==1 || visited[row][col]){
            return;
        }else if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(path);
            return;
        }

        if(!visited[row][col]){
            visited[row][col] = true;
        }


        // top call
        findPaths(maze,row-1,col,visited,path+"T");
        // left call
        findPaths(maze,row,col-1,visited,path+"L");
        // down call
        findPaths(maze,row+1,col,visited,path+"D");
        // up call
        findPaths(maze,row,col+1,visited,path+"R");

    }
}
