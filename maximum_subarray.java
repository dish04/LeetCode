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