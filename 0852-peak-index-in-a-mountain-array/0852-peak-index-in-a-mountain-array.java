class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // You are in the decreasing part.
                // Peak is at mid or to the left.
                end = mid;
            } else {
                // You are in the increasing part.
                // Peak is to the right.
                start = mid + 1;
            }
        }

        return start; // start == end
    }
}