class Pair implements Comparable<Pair>{
    public int x;
    public int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Pair o) {
        return o.x-this.x;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> cars=new ArrayList<>();
        Deque<Double> q=new LinkedList<>();
        for(int i=0;i<position.length;i++){
            cars.add(new Pair(position[i],speed[i]));
        }
        Collections.sort(cars);
        for(int i=0;i<cars.size();i++){
            double tim=((target-cars.get(i).x)*1.0)/cars.get(i).y;
            if(q.size()==0 || q.peekLast()<tim){
                q.addLast(tim);
            }
        }
        return q.size();
    }
}
