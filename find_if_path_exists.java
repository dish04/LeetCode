class find_if_path_exists_best {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;
        boolean flag = true;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while(flag){
            flag = false;
            for(int[] edge : edges){
                if(visited[edge[0]] != visited[edge[1]]){
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if(visited[destination]) return true;
            }
        }
        return false;
    }
}
class find_if_path_exists_mine {
    boolean found = false;
    List<Integer> visited = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashMap<Integer, List<Integer>> map2 = new HashMap<>();
    HashMap<Integer, List<Integer>> map3 = new HashMap<>();
    private void dfs(int s, int d){
        if(found || visited.contains(s)) return;
        visited.add(s);
        List<Integer> n = map3.get(s);
        //List<Integer> m = map2.get(s);
        if(n == null) return;
        //if(n.isEmpty()) return false;
        if(n != null && n.contains(d)){ //|| (m!= null && m.contains(d)) ) {
            found = true;
            return;
        }
        if(n!=null) for(int e: n) {
            dfs(e,d);
            //dfs2(e,d);
        }
        if(found) return;
        //if(m!=null) for(int e: m) dfs(e,d);
        //if(found) return;
        return;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        for(int[] a : edges){
            int key = a[0];
            int value = a[1];
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            map2.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            int key = entry.getKey();
            List<Integer> list = map.get(key);
            if(map2.containsKey(key)) list.addAll(map2.get(key));
            map3.put(key,list);
        }

        for(Map.Entry<Integer, List<Integer>> entry: map2.entrySet()){
            int key = entry.getKey();
            List<Integer> list = map2.get(key);
            if(map3.containsKey(key)) continue;
            map3.put(key,list);
        }

        /*System.out.println("Map 1");
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> values = entry.getValue();
            System.out.println("Key: " + key + ", Values: " + values);
        }
        System.out.println("Map 2");
        for (Map.Entry<Integer, List<Integer>> entry : map2.entrySet()) {
            int key = entry.getKey();
            List<Integer> values = entry.getValue();
            System.out.println("Key: " + key + ", Values: " + values);
        }
        System.out.println("Map 3");
        for (Map.Entry<Integer, List<Integer>> entry : map3.entrySet()) {
            int key = entry.getKey();
            List<Integer> values = entry.getValue();
            System.out.println("Key: " + key + ", Values: " + values);
        }*/
        dfs(source, destination);
        //dfs2(source,destination);
        return found;
    }
}
