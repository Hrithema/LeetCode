class Solution {
    public void sortColors(int[] nums) {
        // Dutch National Flag Algorithm
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // Swap nums[low] and nums[mid]
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                    
                case 1:
                    mid++;
                    break;
                    
                case 2:
                    // Swap nums[mid] and nums[high]
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}