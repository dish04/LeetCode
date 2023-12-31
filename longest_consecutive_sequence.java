import java.util.Arrays;

class longest_consecutive_sequence {
    //gud
    //9ms
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = 1, counter = 0, max = 0;
        while(right<nums.length){
            if((nums[right]-nums[left])==0){
                right++;
                left++;
                continue;
            }
            if((nums[right]-nums[left])==1){
                //System.out.println("Right value is = "+nums[right]+" Left value is = "+nums[left]);
                counter++;
            }
            else{
                if(max<counter) max = counter;
                //System.out.println("Max is = "+max);
                counter = 1;
            }
            left++;
            right++;
        }
        //System.out.println("Counter at the end is = "+counter);
        return Math.max(max, counter);
    }
    public static void main(String[] args) {
        longest_consecutive_sequence lcs = new longest_consecutive_sequence();
        int[] nums = {-1,-9,-5,-2,-9,8,-8,1,-9,-3,-3};
        System.out.println(lcs.longestConsecutive(nums));
    }
}