class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[30];
        int[] freq2=new int[30];
        for(char c: s1.toCharArray()){
            freq1[c-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            if(i>=s1.length()){
                freq2[s2.charAt(i-s1.length())-'a']--;
            }
            freq2[s2.charAt(i)-'a']++;
            if(Arrays.equals(freq1,freq2)) return true;
        }
        return false;
    }
}
