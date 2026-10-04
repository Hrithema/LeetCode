class Solution {
    public void sortColors(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]>max) max = nums[i];
            if(nums[i]<min) min = nums[i]; 
        }

        int [] count = new int [max - min + 1];
        for (int i = 0; i<nums.length; i++){
            count[nums[i]-min]++;
        }
        int j= 0;
        for(int i = 0; i< count.length; i++){
            while(count[i]>0){    
                nums[j] = i + min;
                j++;
                count[i]--; 
            }
        }
    }
}