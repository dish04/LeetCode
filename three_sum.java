class Solution {
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        HashMap<Integer, Integer> dup = new HashMap<>();
        int left=0, right=nums.length-1, mid, sum, r, l, zero=0;
        boolean found=false;
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0 ){
                zero++;
            }
            else{
                if(nums[i]==nums[i+1]){
                    if(!dup.containsKey(nums[i])) dup.put(nums[i],2);
                    else{
                        int c = dup.get(nums[i]);
                        dup.put(nums[i],++c);
                    }
                }
            }
        }
        if(nums[nums.length-1]==0) zero++;
        while(nums[left]<0 && left<nums.length-1){
            if(left!=0 && nums[left]==nums[left-1]) {
                left++;
                right = nums.length-1;
                continue;
            }
            while(nums[right]>=0 && right>=0){
                if(right!=nums.length-1 && nums[right]==nums[right+1]) {
                    right--;
                    continue;
                }
                found = false;
                sum = 0-nums[right]-nums[left];
                System.out.println("nums[right] = "+nums[right]+" nums[left] = "+nums[left]+" sum = "+sum);
                r = right;
                l = left;
                while(r>l){
                    mid = l+(r-l)/2;
                    if(nums[mid]==sum || nums[left]==sum || nums[right]==sum){
                        found=true;
                        System.out.println("Found");
                        break;
                    }
                    else if(nums[mid]>sum) r=mid-1;
                    else l=mid+1;
                }
                if(found){
                    if(sum==nums[left] || sum==nums[right]){
                        if(!dup.containsKey(sum)){
                            right--;
                            continue;
                        }
                        else{
                            int c = dup.get(sum);
                            dup.put(sum,--c);
                            if(c == 0){
                                dup.remove(sum);
                            }
                        }
                    }
                    System.out.println("Added");
                    List<Integer> temp = Arrays.asList(nums[left], nums[right], sum);
                    ret.add(temp);
                }
                right--;
            }
            left++;
            right = nums.length-1;
        }
        if(zero>=3){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            ret.add(list);
        }
        return ret;
    }
}
