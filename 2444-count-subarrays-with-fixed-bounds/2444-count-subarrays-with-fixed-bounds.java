class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0l;
        
        int minFound = -1;
        int maxFound = -1;
        
        int start = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<minK || nums[i] > maxK){
                minFound = -1;
                maxFound = -1;
                start = i+1;
            }
            
            if(nums[i]==minK){
                minFound = i;
            }
            if(nums[i] == maxK){
                maxFound = i;
                
            }
            
            if(minFound!=-1 && maxFound!=-1){
                ans+=Math.min(maxFound, minFound) -start+1;
            }
            
        }
        return ans;
        
    }
}

// class Solution {
// public:
//     long long countSubarrays(vector<int>& nums, int minK, int maxK) {
//         long res = 0;
//         bool minFound = false, maxFound = false;
//         int start = 0, minStart = 0, maxStart = 0;
//         for (int i = 0; i < nums.size(); i++) {
//             int num = nums[i];
//             if (num < minK || num > maxK) {
//                 minFound = false;
//                 maxFound = false;
//                 start = i+1;
//             }
//             if (num == minK) {
//                 minFound = true;
//                 minStart = i;
//             }
//             if (num == maxK) {
//                 maxFound = true;
//                 maxStart = i;
//             }
//             if (minFound && maxFound) {
//                 res += (min(minStart, maxStart) - start + 1);
//             }
//         }
//         return res;
//     }
// };