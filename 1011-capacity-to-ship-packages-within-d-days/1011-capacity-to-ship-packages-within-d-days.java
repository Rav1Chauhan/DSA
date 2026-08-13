class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high+=weight;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int no_of_days = requiredDays(mid, weights);
            if(no_of_days>days){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    private int requiredDays(int capacity, int[] weight) {
        int day = 1;
        int load = 0;
        for (int i = 0; i < weight.length; i++) {
            if (load + weight[i] > capacity) {
                load = weight[i];
                day += 1;
            } else {
                load += weight[i];
            }
        }
        return day;

    }
}