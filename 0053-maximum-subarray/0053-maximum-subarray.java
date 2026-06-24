class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        int startingIndex=-1;
        int endingIndex=-1;
        for(int i=0;i<nums.length;i++){
            if(sum==0) startingIndex=i;
            sum+=nums[i];
            if(sum>max){
                max=sum;
                endingIndex=i;
            }
            if(sum<0) sum=0;
        }
        return max ;
    }
}