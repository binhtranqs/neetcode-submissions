class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] frequency = new int[26];
        for(char task:tasks){
            frequency[task-'A']++;
        }
        for(int i:frequency){
            if(i>0){
                maxHeap.offer(i);
            }
        }
       Queue<int[]> cooldown = new ArrayDeque<>();
       int time=0;
       while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
        time++;
          while (!cooldown.isEmpty()
                    && cooldown.peek()[1] <= time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    cooldown.offer(
                        new int[]{remaining, time + n + 1}
                    );
                }
       }
     

    }
    return time;
}
}
