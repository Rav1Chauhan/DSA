class Solution {

    public String longestPalindrome(String s) {

        String rstr = "";

        for (int i = 0; i < s.length(); i++) {

            String str1 = expand(i, i, s); // odd length
            String str2 = expand(i, i + 1, s); // even length

            String current;

            if (str1.length() > str2.length()) {
                current = str1;
            } else {
                current = str2;
            }

            // Only update if current palindrome is longer
            if (current.length() > rstr.length()) {
                rstr = current;
            }
        }

        return rstr;
    }

    public String expand(int j, int k, String s) {

        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        return s.substring(j + 1, k);
    }
}