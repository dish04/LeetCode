class container_with_most_water {
    int[] H;
    private int volume(int left,int right){
        return Math.min(H[left],H[right])*(right-left);
    }
    public int maxArea(int[] height) {
        H = height;
        int right=height.length-1, left=0, volume, mover=0, maxVolume=volume(left,right);
        while(right>left){
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
            maxVolume = Math.max(maxVolume,volume(left,right));
        }
        //System.out.println(right+" "+left);
        return maxVolume;
    }
    /*public int maxArea(int[] height) {
        H = height;
        int right=height.length-1, left=0, volume, mover=0, maxVolume=volume(left,right), max=0, t1=0, t2=0,i=1;
        for(int j =0; j<height.length; j++){
            if(height[j]>max){
                t1 = j;
                max = height[j];
            }
        }
        max = 0;
        for(int j =0; j<height.length; j++){
            if(height[j]>max){
                if(i == t1) continue;
                t2 = j;
                max = height[j];
            }
        }
        t2 = Math.max(t1,t2);
        t1 = Math.min(t1,t2);
        System.out.println("t1="+t1+"t2="+t2);
        while(t1!=0 && t2!=height.length-1){
            System.out.println("t1="+t1+"t2="+t2);
            if(volume(t1,t2)<volume(t1-i,t2) && t1>0){
                t1-=i;
            }
            if(volume(t1,t2)<volume(t1,t2+i) && t2<height.length){
                t2+=i;
            }
            if(volume(t1,t2)<volume(t1-i,t2+i) && t1>0 && t2<height.length){
                t1-=i;
                t2+=i;
            }
            maxVolume = volume(t1,t2);
            i++;
        }
        maxVolume = volume(t1,t2);
        //while(tmaxV1>)
        return maxVolume;
    }*/
}
