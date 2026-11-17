class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int [] rotated = new int[k];
        for(int i = 0; i< k; i++){
            rotated[i] = nums[nums.length- k + i];
        }       
        for(int i = nums.length-1; i>0; i--){
            if(i-k < 0) break;
            nums[i] = nums[i-k];
        }
        for(int i = 0; i< k; i++){
            nums[i] = rotated [i];
        }
    }
}