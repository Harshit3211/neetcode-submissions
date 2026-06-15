class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append("@");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int num=0;
        List<String> ans=new ArrayList<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='0' && ch<='9'){
                num=num*10;
                num+=ch-'0';
            }
            else if(ch=='@'){
                ans.add(str.substring(i+1,i+num+1));
                i+=num;
                num=0;
            }
        }
        return ans;
    }
}
