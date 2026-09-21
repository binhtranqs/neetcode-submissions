class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> distance(b)-distance(a));
        for(int[] point: points){
            maxHeap.offer(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
       int[][] results = new int[k][2];
       for(int i=0;i<k;i++){
         results[i]= maxHeap.poll();
       }
      return results;
    }
    public int distance(int[] point){
        int y = point[0];
        int x = point[1];
        return x*x+y*y;
    }
}
