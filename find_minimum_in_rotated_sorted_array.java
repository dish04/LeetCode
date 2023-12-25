class find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums){
        int l=0,r=nums.length-1,mid;
        if(nums.length==0)return -1;
        if(nums.length==1)return nums[0];
        while(l<r){
            mid=l+(r-l)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(nums[l]<=nums[mid]&&nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return nums[l];
    }
}
