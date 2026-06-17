class TimeMap {
    private Map< String, List<Data>> map;
    class Data {
        String value;
        int timestamp;
        Data(String value ,int timestamp){
            this.value = value;
            this.timestamp= timestamp;
        }
    }
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Data> list= map.get(key);
        int left =0;
        int right=list.size()-1;
         String result = "";
        while(left<=right){
            int mid = left + (right-left)/2;
            if(list.get(mid).timestamp<=timestamp){
                result = list.get(mid).value;
                left = mid + 1;
            }else{
                right = mid-1;
            }
           
        }
     return result;
    }
}

