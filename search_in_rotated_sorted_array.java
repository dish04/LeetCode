class search_in_rotated_sorted_array {
    public static int reduceArray(int[] nums){
        boolean found=false;
        int i=0,cut=0;
        try{
        while(!found){
            if(nums[i]-nums[i+1]>0){
                found=true;
                cut=i+1;
            }else{
                i++;
            }
        }
        }catch(Exception ArrayIndexOutOfBoundsException){
        return cut;
        }
        return cut;
    }
    public static int searchOne(int[] nums,int target,int l,int r){
        if(l==r&&nums[l]==target)return l;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]==target){
                return l;
            }
            if(nums[r]==target){
                return r;
            }else if(target<nums[mid]&&target>nums[l]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
    public static int search(int[] nums,int target){
        if(nums.length<=3){
            //System.out.println("in here");
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target){
                    return i;
                }
            }
            return -1;
        }
        int cut;
        cut = reduceArray(nums);
        return Math.max(searchOne(nums,target,cut,nums.length-1),searchOne(nums,target,0,cut));
    }
}
