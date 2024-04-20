class find_all_groups_of_farmland {
    public List<int[]> list = new ArrayList<>();
    int h = 0;
    int k =0;
    /*//boolean br = false;
    private void check(int i, int j, int[][] grid){
        boolean tlu = false, tll = false, brd = false, brr = false;
        if(i == 0)tlu = true;
        if(j == 0)tll = true;
        if(i!=0 && grid[i-1][j]==0)tlu = true;
        if(j!=0 && grid[i][j-1]==0)tll = true;
        //if(tll && tlu) tl = true;

        if(i == grid.length-1) brd = true;
        if(j == grid[i].length-1) brr = true;
        if(i != grid.length-1 && grid[i+1][j]==0) brd = true;
        if(j!= grid[i].length-1 && grid[i][j+1] == 0) brr = true;
        //if(brd && brr) br= true;

        if(tlu && tll){
            arr[0] = i;
            arr[1] = j;
            tl = true;
        }

        /*if(tlu && tll && tl){
            arr[0] = i;
            arr[1] = j;
            arr[2] = i;
            arr[3] = j;
            list.add(arr);
            tl = false;
            br = false;
        }

        if(brd && brr){
            arr[2] = i;
            arr[3] = j;
            //System.out.println("Addinh list");
            list.add(arr);
            arr = new int[4];
            tl = false;
            //br = false;
        }
    }*/
    private void DFS(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        h = Math.max(h, i);
        k = Math.max(k, j);

        DFS(i+1, j, grid);
        DFS(i, j+1, grid);
        /*grid[i][j] = 2;
        boolean up1 = false, left1 = false;
        boolean up2 = false, left2 = false, down2 = false, right2 = false;
            if(i == 0) up2 = true;
            if(j == 0) left2 = true;
            if(i != 0 && grid[i-1][j]==2) up2 = true;
            if(j!=0 && grid[i][j-1] == 2) left2 = true;
            if(i == grid.length-1) down2 = true;
            if(j == grid[i].length-1) right2 = true;
            if(i != grid.length-1 && grid[i+1][j]==0) down2 = true;
            if(j!= grid[i].length-1 && grid[i][j+1] == 0) right2 = true;
            if(up2 && left2 && right2 && down2){
                System.out.println("Added "+i+","+j+" to the back");
                arr[0] = -1;
                arr[1] = -1;
                arr[2] = i;
                arr[3] = j;
                for(int e: arr){
                    System.out.print(e+" ");
                }
                System.out.println();
                return arr;
            }

            if(i != 0 && grid[i-1][j] == 1) arr = DFS(i-1,j,grid,arr);
            if(i != grid.length-1 && grid[i+1][j] == 1) arr = DFS(i+1,j,grid,arr);
            if(j != 0 && grid[i][j-1] == 1) arr = DFS(i,j-1,grid,arr);
            if(j != grid[i].length-1 && grid[i][j+1] == 1) arr = DFS(i,j+1,grid,arr);

            if(i == 0) up1 = true;
            if(j == 0) left1 = true;
            if(i != 0 && grid[i-1][j]==0) up1 = true;
            if(j!=0 && grid[i][j-1] == 0) left1 = true;
            if(up1 && left1){
                System.out.println("Added "+i+","+j+" to the front");
                arr[0] = i;
                arr[1] = j;
            }
            for(int e: arr){
                System.out.print(e+" ");
            }
            System.out.println();
            return arr;*/
    }
    public int[][] findFarmland(int[][] grid) {
        //List<int[]> list = new ArrayList<>();
        //int[] arr = new int[4];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    DFS(i,j,grid);
                    list.add(new int[]{i,j,h,k});
                    h =0;
                    k = 0;
                }
            }
        }
        /*for(int e: arr){
                System.out.print(e+" ");
            }*/
        return list.toArray(new int[0][]);
    }
    
}
