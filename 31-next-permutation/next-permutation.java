class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length-1;
        for(int i = n-1; i>=0; i--){
            if(nums[i]<nums[i+1]){
                pivot = i;
                break;
            }

        }
        if (pivot == -1){
            int left = 0;
            int right = n;
            while(left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; right--;
            }
            return;
        }
        for(int i = n; i> pivot; i--){
            if(nums[i]>nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        int i = pivot+1;
        int j = n;
        Arrays.sort(nums, i, n+1);
        // while(i<=j){
        //     int temp = nums[i];
        //     nums[i] = nums[j];
        //     nums[j] = temp;
        //     i++; j--;
        // }
               
    }
}