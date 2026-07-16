class Solution {
    public boolean isValid(HashMap<Character,Integer> hm, String t,char ch){
        hm.put(ch,hm.getOrDefault(ch,0)+1);

        Map<Character, Integer> temp = new HashMap<>();
        for (char c : t.toCharArray()) {
            temp.put(c, temp.getOrDefault(c, 0) + 1);
        }

        for(Character c: temp.keySet()){
            if(hm.getOrDefault(c,0)<temp.get(c)){
                hm.put(ch,hm.getOrDefault(ch,0)-1);
                return false;
            }
        }
        hm.put(ch,hm.getOrDefault(ch,0)-1);
        return true;
    }

    public String minWindow(String s, String t) {
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        int l=0,r=0;
        int ans=2*n;
        String answer="";
        while(l!=n){
            while(r<n && !isValid(hm,t,s.charAt(r))){
                hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
                r++;
            }
            if(r<n && isValid(hm,t,s.charAt(r))){
                int temp=r-l+1;
                if(ans>temp){
                    ans=temp;
                    answer=s.substring(l,r+1);
                }
            }
            hm.put(s.charAt(l),hm.getOrDefault(s.charAt(l),0)-1);
            l++;
        }
        return answer;
    }
}
