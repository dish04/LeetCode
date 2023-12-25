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