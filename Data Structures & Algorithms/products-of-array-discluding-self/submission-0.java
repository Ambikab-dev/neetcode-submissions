class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int product = 1;

        if(nums.length == 0) return result;

        for(int i=0; i<nums.length-1; i++){
            product *= nums[i];
            leftProduct[i] = product;
        }
        product = 1;
        for(int i=nums.length-1; i>=0; i--){
            product *= nums[i];
            rightProduct[i] = product;
        }

        result[0] = rightProduct[1];
        result[nums.length-1] = leftProduct[nums.length-2];

        for(int i=1; i<nums.length-1; i++){
            result[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        return result;
        
    }
}  
