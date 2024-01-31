class binary_search {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0] == target)return 0;
            else return -1;
        }
        //Arrays.sort(nums);
        int right = nums.length-1, left = 0, mid;
        while(right>=left){
            mid = left + (right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else return mid;
        }
        return -1;
    }
}
