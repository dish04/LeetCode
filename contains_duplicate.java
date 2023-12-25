class contains_duplicate {
    static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }
        // Merge the two arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of leftArr if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        // Copy remaining elements of rightArr if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    // Merge Sort function
    static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            // Sort first and second halves
            merge_sort(arr, left, middle);
            merge_sort(arr, middle + 1, right);
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }
    static boolean containsDuplicate(int[] nums) {
        boolean r=false;
        merge_sort(nums,0,nums.length-1);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return r;
    }
}