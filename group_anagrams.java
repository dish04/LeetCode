import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class group_anagrams {
  public List<List<String>> groupAnagrams1(String[] strs){
        //gud
        List<List<String>> ret_list = new ArrayList<List<String>>();
        HashMap<String , ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ss = s.toCharArray();
            Arrays.sort(ss);
            String sss = new String(ss);
            if(!map.containsKey(sss)){
                map.put(sss, new ArrayList<>());
            }
            map.get(sss).add(s);
        }
        ret_list = new ArrayList<>(map.values());
        return ret_list;
    }
    public boolean isAnagram(String s, String t){
        if(s==null||t==null){
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs,ct);
    }
    public List<List<String>> groupAnagrams2(String[] strs) {
        //bad o(n^2)
        List<List<String>> ret_list = new ArrayList<List<String>>();
        for(int i=0; i < strs.length; i++){
            List<String> local_list = new ArrayList<String>();
            for(int j=i+1; j < strs.length; j++){
                if(strs[j]==null){
                    continue;
                }
                if(isAnagram(strs[i],strs[j])){
                    if(!local_list.contains(strs[i])){
                        local_list.add(strs[i]);
                    }
                    local_list.add(strs[j]);
                    strs[j]=null;
                }
            }
            if(local_list.isEmpty()&&strs[i]!=null){
                local_list.add(strs[i]);
                //ret_list.add(local_list);
            }
            strs[i]=null;
            if(!local_list.isEmpty()){
                ret_list.add(local_list);
            }
        }
        return ret_list;
    }
}
