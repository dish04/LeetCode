import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class top_k_frequent_elements {
    static public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] ret=null;
        return ret;
    }
    static public int[] topKFrequent2(int[] nums, int k) {
        long startTime = System.currentTimeMillis();
        if(nums.length==1){
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        long part1EndTime = System.currentTimeMillis();
        System.out.println("Part 1 execution time: " + (part1EndTime - startTime) + " milliseconds");
        System.out.println(map);
        startTime = System.currentTimeMillis();
        HashMap<Integer, List<Integer>> mapped = new HashMap<>();
        for(int i : map.keySet()){
            System.out.println(i);
            if(mapped.containsKey(map.get(i))){
                mapped.get(map.get(i)).add(i);
            }
            else{
                List<Integer> local_list = new ArrayList<>();
                local_list.add(i);
                mapped.put(map.get(i), local_list);
            }
        }
        long part2EndTime = System.currentTimeMillis();
        System.out.println("Part 2 execution time: " + (part2EndTime - startTime) + " milliseconds");
        System.out.println(mapped);
        startTime = System.currentTimeMillis();
        int[] max = mapped.keySet().stream().mapToInt(Integer::intValue).toArray();
        long part3EndTime = System.currentTimeMillis();
        System.out.println("Part 3 execution time: " + (part3EndTime - startTime) + " milliseconds");
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(max);
        int i = 0, x = 0;;
        startTime = System.currentTimeMillis();
        while(true){
            if(x<k){
                x+=mapped.get(max[max.length-1-i]).size();
                ret.addAll(mapped.get(max[max.length-1-i++]));
            }
            else
                break;
        }
        long part4EndTime = System.currentTimeMillis();
        System.out.println("Part 4 execution time: " + (part4EndTime - startTime) + " milliseconds");
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