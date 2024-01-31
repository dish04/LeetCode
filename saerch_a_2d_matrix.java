class saerch_a_2d_matrix {
    public boolean searchMatrix(int[][] nums, int target) {
        for(int i=0; i<nums.length; i++){
            //Arrays.sort(nums);
            int right = nums[i].length-1, left = 0, mid;
            while(right>=left){
                mid = left + (right-left)/2;
                if(nums[i][mid]<target){
                    left=mid+1;
                }
                else if(nums[i][mid]>target){
                    right=mid-1;
                }
                else return true;
            }
        }
        return false;
    }
}
