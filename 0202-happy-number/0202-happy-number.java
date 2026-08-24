class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow= findsquare(slow);
            fast = findsquare(findsquare(fast));
        }while(slow!=fast);

        if(slow==1) return true;
        
        return false;
    }
    private int findsquare(int number){
        int ans = 0;
        while(number>0){
            int rem = number%10;
            ans += rem * rem;
            number /=10;
        }
        return ans;
    }
    
}