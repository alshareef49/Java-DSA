package DSA.recursion.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class R4_AllIndicesOfAnArray {
    public static void main(String[] args) {
        // Question: Implement a recursive function to find all indices of a given element in an array
        // The function should have the following signature:
        // public static List<Integer> allIndices(int[] arr, int idx, int data, List<Integer> result)
        // Where:
        // - arr is the input array
        // - idx is the current index (start with 0)
        // - data is the element to find
        // - result is the list to store the indices (initially empty)
        // The function should return a list containing all indices where the element is found
        
        // Example:
         int[] arr = {2, 3, 9, 8, 7, 6, 4, 12, 7, 3, 7};
         List<Integer> result = allIndices(arr, 0, 7, new ArrayList<>());
         System.out.println(result); // Should print [4, 8, 10]
        System.out.println(Arrays.toString(getAllIndices(arr, 7, 0, 0)));
//
//         result = allIndices(arr, 0, 3, new ArrayList<>());
//         System.out.println(result); // Should print [1, 9]
//
//         result = allIndices(arr, 0, 99, new ArrayList<>());
//         System.out.println(result); // Should print []
    }
    
    // TODO: Implement the recursive allIndices function here
    public static List<Integer> allIndices(int[] arr, int idx, int data, List<Integer> result) {
        // Your code here
       if(idx==arr.length){
           return result;
       } else if (arr[idx]==data) {
           result.add(idx);
       }
       return allIndices(arr,idx+1,data,result);
    }

    public  static int[] getAllIndices(int[] arr,int data,int idx,int fsf){
        if(idx==arr.length){
            return new int[fsf];
        }
        if(arr[idx]==data){
            int[] res  = getAllIndices(arr,data,idx+1,fsf+1);
            res[fsf] = idx;
            return res;
        }else {
            return getAllIndices(arr,data,idx+1,fsf);

        }
    }
}
