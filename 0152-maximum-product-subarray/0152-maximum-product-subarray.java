class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curMax = 1;
        int curMin = 1;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                curMax=1;
                curMin=1;
            }
            temp=curMax*nums[i];
            curMax=Math.max(nums[i]*curMax,Math.max(nums[i]*curMin,nums[i]));
            curMin=Math.min(temp,Math.min(nums[i]*curMin,nums[i]));
            res=Math.max(res,curMax);
        }
        return res;
    }
}