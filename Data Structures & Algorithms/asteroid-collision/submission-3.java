class Solution {
    public int[] asteroidCollision(int[] a) {
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<a.length;i++){
            if(a[i]>0){
                q.addLast(i);
            }else if(a[i]<0){
                boolean toBeAdded=true;
                if(q.size()!=0 && a[q.peekLast()]>0 && a[q.peekLast()]>Math.abs(a[i])){
                    toBeAdded=false;
                }
                else{
                    while(q.size()!=0 && a[q.peekLast()]>0 && a[q.peekLast()]<=Math.abs(a[i])){
                        int val=a[q.removeLast()];
                        if(val==Math.abs(a[i])) {
                            toBeAdded=false;
                            break;
                        }
                    }
                    if(q.size()!=0 &&  a[q.peekLast()]>Math.abs(a[i])){
                        toBeAdded=false;
                    }

                }
                if(toBeAdded){
                    q.addLast(i);
                }
            }
            // System.out.println(q);
        }
        int[] ans=new int[q.size()];
        int ptr=0;
        while(q.size()!=0){
            ans[ptr++]=a[q.removeFirst()];
        }
        return ans;
    }
}