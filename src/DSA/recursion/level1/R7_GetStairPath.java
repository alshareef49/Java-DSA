package DSA.recursion.level1;

import java.util.ArrayList;
import java.util.List;

public class R7_GetStairPath {
    public static void main(String[] args) {
        // Question: Given a staircase with n steps, find all possible ways to climb it
        // You can take either 1 step, 2 steps, or 3 steps at a time.
        // Return the result as a list of strings where each string represents a path.
        // For example, "123" means take 1 step, then 2 steps, then 3 steps.
        //
        // The function should have the following signature:
        // public static List<String> getStairPaths(int n)
        //
        // Example:
         int n = 3;
         List<String> paths = getStairPaths(n);
         System.out.println(paths);
        // Should print: [111, 12, 21, 3]  (order may vary)
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If n == 0: Return list with empty string [""] (valid path found)
           - If n < 0: Return empty list [] (invalid path)
        
        2. Recursive Case:
           - Take 1 step, and recursively find paths for remaining (n-1) steps
           - Take 2 steps, and recursively find paths for remaining (n-2) steps
           - Take 3 steps, and recursively find paths for remaining (n-3) steps
        
        3. Combine Results:
           - For each valid path found, prepend the step taken (1, 2, or 3)
           - Combine all paths from all three recursive calls
        
        Example for n=3:
        - Paths from (n-1=2): [11, 2] → becomes [111, 12]
        - Paths from (n-2=1): [1] → becomes [21]
        - Paths from (n-3=0): [""] → becomes [3]
        - Final result: [111, 12, 21, 3]
        */
    }
    
    /**
     * Recursive function to get all possible paths to climb 'n' stairs
     * Time Complexity: O(3^n) - At each step, we make 3 recursive calls
     * Space Complexity: O(3^n) - To store all possible paths in the worst case
     * 
     * Note: This can be optimized using Dynamic Programming (DP) to O(n) time
     * by storing results of subproblems (memoization)
     */
    public static List<String> getStairPaths(int n) {
        // Your code here
        if(n==0){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }else if(n<0){
            return new ArrayList<>();
        }
        List<String> p1 = getStairPaths(n-1);
        List<String> p2 = getStairPaths(n-2);
        List<String> p3 = getStairPaths(n-3);

        List<String> res = new ArrayList<>();
        for(String path:p1){
            res.add("1"+path);
        }
        for (String path:p2){
            res.add("2"+path);
        }
        for (String path:p3){
            res.add("3"+path);
        }
        return res;
    }
}
