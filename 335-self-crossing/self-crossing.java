class Solution {
    public boolean isSelfCrossing(int[] distance) {
        if (distance.length <= 3) return false;
        
        for (int i = 3; i < distance.length; ++i) {
            // Case 1: Current line crosses the 3rd line before it
        
