class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet();
        for(int n: nums){
            if(!seen.contains(n)){
                seen.add(n);
            }else{
                return true;
            }
        }
        return false;
    }
}