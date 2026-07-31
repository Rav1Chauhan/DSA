class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int maxDay=0;
        int minDay=0;
        int ans=-1;
        for(int D : bloomDay){
            maxDay=Math.max(maxDay,D);
            minDay = Math.max(minDay,D);
        }
        int low =1;
        int high = maxDay;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canBloom(mid,bloomDay,k,m)){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    private boolean canBloom(int Day, int[] bloomDay,int k,int m) {
        int bouquet = 0;
        int consecutive = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= Day) {
                consecutive++;
                if (consecutive == k) {
                    bouquet++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        return (bouquet >= m) ? true : false;
    }
}