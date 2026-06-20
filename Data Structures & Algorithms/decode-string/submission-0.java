class Solution {
    public String decodeString(String s) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        compute(s,hm);
        return getString(s,0,s.length()-1,hm);
    }
    public void compute(String s,HashMap<Integer,Integer> hm){
        int ptr=0;
        Deque<Integer> q=new LinkedList<>();
        for(char c: s.toCharArray()){
            if(c=='['){
                q.addLast(ptr);
            }else if(c==']'){
                hm.put(q.removeLast(),ptr);
            }
            ptr++;
        }
        System.out.println(hm);
    }
    public String getString(String s,int st,int end,HashMap<Integer,Integer> hm){
        int num=0;
        StringBuilder sb=new StringBuilder();
        for(int i=st;i<=end;i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                num*=10;
                num+=s.charAt(i)-'0';
            }
            if(s.charAt(i)=='['){
                String temp=getString(s,i+1,hm.get(i)-1,hm);
                for(int j=0;j<num;j++) sb.append(temp);
                num=0;
                i=hm.get(i);
            }
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}