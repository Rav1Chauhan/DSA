class Solution {
    public int arrangeCoins(int n) {
        long l = 1;
        long r = n;
        int res = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long coins = mid * (mid + 1) / 2;

            if (coins <= n) {
                res = (int) mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}