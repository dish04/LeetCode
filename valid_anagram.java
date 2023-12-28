class valid_anagram{
  //Another smart solution i found
  class Solution_smart {
    //Basically what i came up with but its fatser and requires less code, need to learn when and where to implement certain ds
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
  //Soltuion i should have come up with
  class Solution_better{
    public boolean isAnagram(String s, String t){
      char[] cs = s.toCharArray();
      char[] ct = t.toCharArray();
      Arrays.sort(cs)
      Arrays.sort(ct)
      return Arrays.equals(cs,ct);
    }
  }
  //Solution i came up with
  class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> cs = new HashMap<>();
        HashMap<Character,Integer> ct= new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            if(!cs.containsKey(s.charAt(i))){
                cs.put(s.charAt(i),1);
            }
            else{
                int j = cs.get(s.charAt(i));
                cs.remove(s.charAt(i));
                cs.put(s.charAt(i),++j);
            }
        }
        //System.out.println(cs);
        for(int i = 0; i<t.length(); i++){
            if(!cs.containsKey(t.charAt(i))){
                return false;
            }
        }
        for(int i = 0; i<t.length(); i++){
            if(!ct.containsKey(t.charAt(i))){
                ct.put(t.charAt(i),1);
            }
            else{
                int j = ct.get(t.charAt(i));
                ct.remove(t.charAt(i));
                ct.put(t.charAt(i),++j);
            }
        }
        //System.out.println(cs+"\n"+ct);
        if(cs.equals(ct)){
            return true;
        }
        return false;
    }
}
}
