package DSA.recursion.level1;

public class R17_TargetSumSubset {
    public static void main(String[] args) {
        // Question: Given an array of integers and a target sum, find and print all subsets of the array
        // whose elements add up to the given target sum. You can use each element only once in a subset.
        //
        // The function should have the following signature:
        // public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar)
        // Where:
        // - arr: Input array of integers
        // - idx: Current index in the array (start with 0)
        // - set: Current subset (start with empty string)
        // - sos: Sum of current subset (start with 0)
        // - tar: Target sum to achieve
        //
        // Example:
        // int[] arr = {10, 20, 30, 40, 50};
        // int target = 70;
        // printTargetSumSubsets(arr, 0, "", 0, target);
        // Should print:
        // 10, 20, 40
        // 20, 50
        // 10, 60
        //
        /* PSEUDO APPROACH:
        1. Base Cases:
           - If current sum (sos) > target: return (prune the search space)
           - If reached end of array (idx == arr.length):
             - If sos == target: print the current subset
             - return
        
        2. Recursive Cases:
           For each element, we have two choices:
           - Include the current element in the subset:
             1. Add current element to the set string
             2. Add current element's value to the sum
             3. Recurse with next index
             
           - Exclude the current element from the subset:
             1. Keep the set and sum as is
             2. Recurse with next index

        Key Points:
        - Each element can be either included or excluded (similar to subset problem)
        - The order of elements in the subset doesn't matter
        - Need to handle base cases properly to avoid stack overflow
        - The solution uses backtracking to explore all possible subsets
        */
        
        // Example usage
        int[] arr = {10, 20, 30, 40, 50};
        int target = 70;
        System.out.println("Subsets with sum " + target + ":");
        printTargetSumSubsets(arr, 0, "", 0, target);
    }
    
    // TODO: Implement the recursive printTargetSumSubsets function
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int target) {
        // Your implementation here
        if(sos==target){
            System.out.println(set);
            return;
        }else if (idx==arr.length){
            return;
        }

        printTargetSumSubsets(arr,idx+1,set,sos,target);
        printTargetSumSubsets(arr,idx+1,set+arr[idx]+",",sos+arr[idx],target);
    }
}
