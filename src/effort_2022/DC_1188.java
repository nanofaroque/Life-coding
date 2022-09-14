package effort_2022;

public class DC_1188 {
    public static void main(String[] args) {
        DC_1188 dc = new DC_1188();
        int res = dc.countInversion(new int[]{2, 4, 1, 3, 5});
        System.out.println(res);
    }

    private int countInversion(int[] arr) {
        int len = arr.length;
        return mergeSort(arr, new int[len],0, len - 1);
    }

    private int mergeSort(int[] arr,int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count+=mergeSort(arr,temp, left,mid);
            count+=mergeSort(arr,temp, mid+1, right);
            count+=mergeCount(arr,temp,left,mid+1,right);
        }
        return count;
    }

    private int mergeCount(int[] arr, int[] temp, int l, int m, int r) {
        int i = l;
        int j = m;
        int k = l, swaps = 0;

        while (i <= m-1 && j <= r) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                arr[k++] = arr[j++];
                swaps += m-i-l+1; //
            }
        }
        while (i <=m-1)
            arr[k++] = arr[i++];
        while (j <= r)
            arr[k++] = temp[j++];

        for(i=l;i<=r;i++){
            arr[i]=temp[i];
        }
        return swaps;
    }
}
