class Solution {
    public boolean isAnagram(String s, String t) {
        int sl=s.length();
        if(s.length()!=t.length()) return false;
        int s_p=1, t_p=1,s_s=0,t_s=0,s_0=0,t_0=0;
        for(int i =0;i<sl;i++){
            s_p*=(int)s.charAt(i);
            t_p*=(int)t.charAt(i);
            s_s+=(int)s.charAt(i);
            t_s+=(int)t.charAt(i);
            s_0^=(int)s.charAt(i);
            t_0^=(int)t.charAt(i);

        }
        if(s_p==t_p && s_s==t_s && s_0!=0 && t_0!=0 && s_0==t_0) return true;
        return false;
    }
}