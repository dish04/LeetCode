import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class top_k_frequent_elements {
    public int[] topKFrequent1(int[] nums, int k) {
        //13ms
        // Better to use custom classes to hold values
        // Better to use PriorityQueue holding only k items as it is less time consuming
        // to convert to an array of size k
        if (nums.length == k) {
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<t> pq = new PriorityQueue<>((n1, n2) -> n1.freq - n2.freq);
        int num, freq;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            num = entry.getKey();
            freq = entry.getValue();
            pq.offer(new t(num, freq));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ret[i] = pq.poll().num;
        }
        return ret;
    }

    class t {
        public int num;
        public int freq;

        public t(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    static public int[] topKFrequent2(int[] nums, int k){
        //24+-1ms
        //Better to use PriorityQueue holding only k items as it is less time consuming to convert to an array of size k
        if(nums.length==k){
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        for(int i : map.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ret=new int[k];
        for(int i = k-1; i>=0 ;i++){
            ret[i] = pq.poll();
        }
        return ret;
    }
    static public int[] topKFrequent3(int[] nums, int k) {
        //Shuttles between 14ms and 24 ms
        //Uses HashMap to convert to the return array which is time consuming with a map
        if(nums.length==k){
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int key, value;
        HashMap<Integer, List<Integer>> mapped = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            mapped.computeIfAbsent(value, x -> new ArrayList<>()).add(key);
        }
        int[] max = mapped.keySet().stream().mapToInt(Integer::intValue).toArray();
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(max);
        int i = 0, x = 0;
        while(true){
            if(x<k){
                x+=mapped.get(max[max.length-1-i]).size();
                ret.addAll(mapped.get(max[max.length-1-i++]));
            }
            else
                break;
        }
        //System.out.println(mapped);
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] x = topKFrequent2(nums, 2);
        for(int i : x){
            System.out.println(i);
        }
    }
}
