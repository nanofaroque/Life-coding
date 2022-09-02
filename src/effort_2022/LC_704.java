package effort_2022;

public class LC_704 {
    public static void main(String[] args) {
        LC_704 p = new LC_704();
        int res = p.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        System.out.println(res);
    }

    public int search(int[] arr, int x) {

        int l = 0;
        int r = arr.length - 1;
        while (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
