class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,ans=0;
        HashSet<Character>hs=new HashSet<>();
        while (l!=s.length()){
            while (r<s.length() && !hs.contains(s.charAt(r))){
                hs.add(s.charAt(r));
                r++;
            }
            ans=Math.max(ans,r-l);
            hs.remove(s.charAt(l));
            l++;
        }
        return ans;
    }
}
