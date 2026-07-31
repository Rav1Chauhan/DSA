class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        int ans = high;
        int minsum = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = canDivide(mid, nums);
            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int canDivide(int divisor, int[] nums) {
        int sum = 0;
        int consecutive = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
}