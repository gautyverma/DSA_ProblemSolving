package gfg.a17_Graph.exercise;

import java.util.Arrays;

/*
* Given an array arr[] of distinct elements.
* Find the minimum number of swaps required to sort the array in strictly increasing order.
* */
public class a11_MinSwaps {
    public static void main(String[] args){
        int[] arr = {5,4,3,1,2};
    System.out.println("Min Swaps to sort the array :: "+minSwap(arr));
    }

    private static int minSwap(int[] arr) {
        int n = arr.length;
        int[][] temp = new int[n][2];

        // pair value with originalIndex
        for(int i = 0;i<n;i++){
            temp[i][0] = arr[i]; // store the value
            temp[i][1] = i;
        }

        // sort by value
        Arrays.sort(temp,(a,b) -> Integer.compare(a[0],b[0]));

        boolean[] visited = new boolean[n];
        int swaps = 0;
        for(int i= 0 ;i<n;i++){
            // already visited or already at correct position
            if(visited[i] || temp[i][1] == i)
                continue;
            int cycleSize = 0; int j = i;
            while(!visited[j]){
                visited[j] = true;
                j = temp[j][1];
                cycleSize++;
            }
            if(cycleSize > 1)
                swaps += cycleSize -1;
        }

        return swaps;
    }
}
