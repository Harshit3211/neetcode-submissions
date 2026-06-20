class Solution {
    public String simplifyPath(String path) {
        Deque<String> q=new LinkedList<>();
        for(String s: path.split("/")){

            if(s.length()==0|| s.equals(".")) continue;
            if(s.equals("..")){
                if(q.size()!=0)  q.removeLast();
            }
            else{
                q.addLast(s);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(q.size()!=0){
            sb.append("/");
            sb.append(q.removeFirst());
        }
        if(sb.length()==0) sb.append("/");
        return sb.toString();
    }
}