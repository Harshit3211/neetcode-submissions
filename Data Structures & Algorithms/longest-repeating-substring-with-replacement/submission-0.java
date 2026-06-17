class Solution {
    public boolean isValid(HashMap<Character,Integer> hm,char c,int k){
        hm.put(c,hm.getOrDefault(c,0)+1);
        List<Integer> values=hm.values().stream().toList();
        int sum=values.stream().mapToInt(Integer::intValue).sum();
        int max=Collections.max(values);
        hm.put(c,hm.getOrDefault(c,0)-1);
        return sum-max<=k;
    }

    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int ans=0;
        while(l!=s.length()){
            while(r<s.length() && isValid(hm,s.charAt(r),k)){
                hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
                r++;
            }
            ans=Math.max(ans,r-l);
            hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
            l++;
        }
        return ans;
    }
}
