package program_creek;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr, n ) + "\n" );
    }

    private static int lis(int[] arr, int n) {
        int[] lis=new int[n];
        Arrays.fill(lis,1);
        int max=Integer.MIN_VALUE;

        for (int i = 1; i <n ; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j]<=arr[i]){
                    lis[i]=Math.max(lis[j]+1,lis[i]);
                    max=Math.max(max,lis[i]);
                }
            }
        }
        return max;
    }
}
