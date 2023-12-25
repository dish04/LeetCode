import java.util.ArrayList;
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
