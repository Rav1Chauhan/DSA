class Solution {
    public int romanToInt(String s) {
        int sum=0;
        for(int i =s.length()-1;i>=0;i--){
            if(i!=s.length()-1){
                if(value(s.charAt(i))>=value(s.charAt(i+1))) sum+=value(s.charAt(i));
                else sum-=value(s.charAt(i));
            }
            else sum+=value(s.charAt(i));
        }
        return sum;
    }
    public int value(char c){
        if(c=='I') return 1;
        if(c=='V') return 5;
        if(c=='X') return 10;
        if(c=='L') return 50;
        if(c=='C') return 100;
        if(c=='D') return 500;
        return 1000;
    }
}