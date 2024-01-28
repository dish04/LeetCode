class longest_substring_without_repeating_characters  {
    public int lengthOfLongestSubstring(String string) {
        char[] s = string.toCharArray();
        if(s.length==0) return 0;
        if(s.length==1) return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0, right = 0;
        while(right<s.length){
            if(map.containsKey(s[right])){
                //System.out.println(s[right]+" "+map.get(s[right]));
                int moveTill = map.get(s[right]);
                //System.out.println("Move till "+(moveTill+1));
                while(left<moveTill+1){
                    map.remove(s[left]);
                    left++;
                }
                map.put(s[right],right);
                right++;
                //System.out.println(left+" "+right);
                continue;
            }
            map.put(s[right],right);
            right++;
            //System.out.println(left+" "+right);
            maxLength = Math.max(right-left,maxLength);
        }
        return (maxLength);
    }
}
