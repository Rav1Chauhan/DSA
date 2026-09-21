class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s = countAndSay(n-1);
        String s2="";
        int f=1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)) f++;
            else{
                s2=s2+ Integer.toString(f) + s.charAt(i);
                f=1;
            }
        }
        s2=s2+ Integer.toString(f) + s.charAt(s.length()-1);
        return s2;
    }
}