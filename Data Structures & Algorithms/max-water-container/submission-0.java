class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int maxArea = 0;

        while (left < right){
            int curr_height = Math.min(heights[left], heights[right]);
            int curr_width = right - left;
            int area = curr_height * curr_width;

            maxArea = Math.max(area, maxArea);

            if (heights[left] < heights[right]){
                left++;
             } else{
                right--;
             }
        }

        
        return maxArea;
    }
}
