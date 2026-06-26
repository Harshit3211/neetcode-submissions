class TimeMap {
     HashMap<String,TreeMap<Integer,String>>hm;

    public TimeMap() {
        hm=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> temp = hm.getOrDefault(key, new TreeMap<>());
        temp.put(timestamp, value);
        hm.put(key,temp);
    }

    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        TreeMap<Integer,String> temp = hm.get(key);
        if(temp.containsKey(timestamp)) return temp.get(timestamp);
        if(temp.lowerKey(timestamp)!=null){
            return temp.get(temp.lowerKey(timestamp)); 
        }
        return "";
    }
}