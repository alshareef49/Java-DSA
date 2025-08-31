package DSA.recursion.level1;

public class R12_PrintStairPath {
    public static void main(String[] args) {
        // Question: A person can climb a staircase of 'n' steps by taking 1, 2, or 3 steps at a time.
        // Print all possible ways the person can climb the staircase.
        // Each path should be represented as a string where each character represents
        // the number of steps taken at that move (e.g., "12" means take 1 step then 2 steps).
        //
        // The function should have the following signature:
        // public static void printStairPaths(int n, String path)
        // Where:
        // - n: remaining steps to climb
        // - path: current path taken (start with empty string)
        //
        // Example for n = 3:
        // printStairPaths(3, "");
        // Should print (order may vary):
        // 111
        // 12
        // 21
        // 3
        //
        /* PSEUDO APPROACH:
        1. Base Cases:
           - If n == 0: print the current path (valid path found)
           - If n < 0: return (invalid path)
        
        2. Recursive Cases:
           For each possible step size (1, 2, 3):
           - If taking that step won't exceed remaining steps:
             1. Convert step size to string
             2. Append to current path
             3. Recurse with (n - step) and updated path
             
        Key Points:
        - The order of steps matters (1+2 is different from 2+1)
        - Each path is built incrementally
        - The sum of digits in each path equals the total steps
        - The empty string is not a valid path (must take at least one step)
        */
        
        // Example usage
        int n = 3;
        System.out.println("All possible paths to climb " + n + " steps:");
        printStairPaths(n, "");
    }
    
    // TODO: Implement the recursive printStairPaths function
    public static void printStairPaths(int n, String path) {
        // Your implementation here
        if (n==0){
            System.out.println(path);
            return;
        } else if (n<0) {
            return;
        }

        printStairPaths(n-1,"1"+path);
        printStairPaths(n-2,"2"+path);
        printStairPaths(n-3,"3"+path);
    }
}
