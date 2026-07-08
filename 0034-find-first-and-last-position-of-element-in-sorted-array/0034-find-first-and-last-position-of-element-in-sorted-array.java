class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = {search(nums,target,true),search(nums,target,false)};
        return ans;
    }

    private int search(int [] nums,int target,boolean findIndex){
        int start = 0;
        int end = nums.length-1;
        int potentialAns=-1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(nums[mid]>target) end = mid-1;
            else if (nums[mid]<target) start = mid+1;
            else{
                potentialAns=mid;
                if(findIndex) end=mid-1;
                else start = mid+1;
            }
        }
        return potentialAns;
    }
}