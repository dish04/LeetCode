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