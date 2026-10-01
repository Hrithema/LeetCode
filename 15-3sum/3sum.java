class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            int second = i+1;
            int last = n-1;
            while(second<last){
                if((first+nums[second]+nums[last]) < 0){
                    second++;
                }
                else if((first+nums[second]+nums[last]) > 0){
                    last--;
                }
                else{
                    ans.add(Arrays.asList(
                        nums[i],
                        nums[second],
                        nums[last]
                    ));
                    second++;
                    last--;

                    // Skip duplicate second values
                    while (second < last && nums[second] == nums[second - 1]) {
                        second++;
                    }

                    // Skip duplicate last values
                    while (second < last && nums[last] == nums[last + 1]) {
                        last--;
                    }
                }
            }
            

        }
        return ans;
    }
        
    
}