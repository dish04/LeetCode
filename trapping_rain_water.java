class trapping_rain_water {
    public int trap(int[] height) {
        int right = height.length-1, left = 0, volume = 0, maxRight = 0, maxLeft = 0;
        while(right>left){
            if(height[left]>height[right]){
                if(maxRight>height[right]){
                    volume += maxRight-height[right];
                }else{
                    maxRight = height[right];
                }
                right--;
            }else{
                if(maxLeft>height[left]){
                    volume += maxLeft-height[left];
                }else{
                    maxLeft = height[left];
                }
                left++;
            }
        }
        //System.out.println(right+" "+left);
        return volume;
    }
}
