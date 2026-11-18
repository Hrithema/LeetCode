class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int index = n-1;

        int [] ans = new int [n];

        while(left<=right && index >= 0){
            if(nums[left]*nums[left] < nums[right]*nums[right]){
                ans[index--] = nums[right]*nums[right];
                right--;
            }
            else{
                ans[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return ans;
    }
}