package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class course_schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> hm= new HashMap<>();
        for(int[] e:prerequisites){
            if(hm.get(e[0])==null){
                List<Integer> preq= new ArrayList<>();
                preq.add(e[1]);
                hm.put(e[0],preq);
            }else{
                hm.get(e[0]).add(e[1]);
                List<Integer> preq= new ArrayList<>();
                preq=hm.get(e[0]);
                hm.put(e[0],preq);
            }
        }
        for(int i=0;i<numCourses;i++){
            if(hm.get(i)==null){
                List<Integer> mo= new ArrayList<>();
                mo.add(-1);
                hm.put(i,mo);
            }
        }
        /*for (Integer key : hm.keySet()) {
            List<Integer> values = hm.get(key);
            System.out.print("Node " + key + ": ");
            for (Integer value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }*/
        List<Integer> v= new LinkedList<>();
        List<Integer> sc= new LinkedList<>();
        for(Integer key : hm.keySet()){
    
            sc.add(key);
            if(!loc_dfs(hm,key,v,sc)) return false;
        }
        return true;
    }
    private static boolean loc_dfs(HashMap<Integer, List<Integer>> hm, Integer key,List<Integer> v,List<Integer> sc) {
        //System.out.println("Key = "+key+" visited = "+v+" sc = "+sc+"\nsearching in "+hm.get(key));
        for(Integer e: hm.get(key)){
            //System.out.println("e="+e);
            if(e==-1){
                //System.out.println("going in if");
                if(!v.contains(key)){
                    v.add(key);
                }
                sc.remove(key);
                return true;
            }
            else if(sc.contains(e)){
                //System.out.println("going in eif1");
                return false;
            }else if(v.contains(e)){
                //System.out.println("going in eif2");
                continue;
            }
            else if(!v.contains(e)){
                //System.out.println("going in eif3");
                sc.add(e);
                if(!loc_dfs(hm,e,v,sc))return false;
            }else{
                //System.out.println("going in e");
                return false;
            }
        }
        if(!v.contains(key)){
            v.add(key);
        }
        sc.remove(key);
        return true;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class clone_graph {
    public void dfs(Node node , Node copy , Node[] visited){
        visited[copy.val] = copy;
        for(Node n : node.neighbors){
            if(visited[n.val] == null){
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                dfs(n , newNode , visited);
            }else{
                copy.neighbors.add(visited[n.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        Arrays.fill(visited , null);
        dfs(node , copy , visited);
        return copy;
    }
}

class search_in_rotated_sorted_array {
    public static int reduceArray(int[] nums){
        boolean found=false;
        int i=0,cut=0;
        try{
        while(!found){
            if(nums[i]-nums[i+1]>0){
                found=true;
                cut=i+1;
            }else{
                i++;
            }
        }
        }catch(Exception ArrayIndexOutOfBoundsException){
        return cut;
        }
        return cut;
    }
    public static int searchOne(int[] nums,int target,int l,int r){
        if(l==r&&nums[l]==target)return l;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]==target){
                return l;
            }
            if(nums[r]==target){
                return r;
            }else if(target<nums[mid]&&target>nums[l]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
    public static int search(int[] nums,int target){
        if(nums.length<=3){
            //System.out.println("in here");
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target){
                    return i;
                }
            }
            return -1;
        }
        int cut;
        cut = reduceArray(nums);
        return Math.max(searchOne(nums,target,cut,nums.length-1),searchOne(nums,target,0,cut));
    }
}

class find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums){
        int l=0,r=nums.length-1,mid;
        if(nums.length==0)return -1;
        if(nums.length==1)return nums[0];
        while(l<r){
            mid=l+(r-l)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(nums[l]<=nums[mid]&&nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return nums[l];
    }
}

class maximum_product_subarray {
    static int maxProduct(int[] nums){
        int max=Integer.MIN_VALUE,prod=1;
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i++){
            prod=nums[i];System.out.println("prod = "+nums[i]);
            if(prod>max){
                    max=prod;
                    //System.out.println("max "+max);
            }
            for(int j=i+1;j<nums.length;j++){
                prod*=nums[j];
                //System.out.println("prod *= nums[j] "+nums[j]+" "+prod);
                if(prod>max){
                    max=prod;
                    //System.out.println("max "+max);
                }
            }
            
        }
        return max;
    }
}

class maximum_subarray {
    public int maxSubArray(int[] a) {
        int sum=-99999,best=-99999;
        for(int i=0;i<a.length;i++){
            sum=Math.max(a[i],sum+a[i]);
            best=Math.max(sum, best);
        }
        //ystem.out.println(best);
        return best;
    }
    
}

class product_of_array_except_self {
    static int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int prod=1;
        int[] pl=new int[nums.length],pr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            pl[i]=prod;
            prod*=nums[i];
        }
        prod=1;
        for(int i=nums.length-1;i>-1;i--){
            pr[i]=prod;
            prod*=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=pl[i]*pr[i];
        }
        return ans;
    }
}

class contains_duplicate {
    static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }
        // Merge the two arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of leftArr if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        // Copy remaining elements of rightArr if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    // Merge Sort function
    static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            // Sort first and second halves
            merge_sort(arr, left, middle);
            merge_sort(arr, middle + 1, right);
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }
    static boolean containsDuplicate(int[] nums) {
        boolean r=false;
        merge_sort(nums,0,nums.length-1);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return r;
    }
}

class best_time_to_buy_and_sell_stock {
    static int maxProfit(int[] price){
        int gmin=0,nmin,smallest=price[0];
        int[] cprice= price;
        for(int i=0;i<price.length-1;i++){
            if(price[i]<smallest){
                smallest=price[i];
            }
            nmin=price[i+1]-smallest;
            System.out.println("nmin "+nmin);
            if(nmin>gmin){
                gmin=nmin;
                System.out.println("gmin "+gmin);
            }
        }
        return gmin;
    }
}