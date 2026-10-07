
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Initialize a Min-Heap (Java's PriorityQueue is a Min-Heap by default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Iterate through all numbers in the array
        for (int num : nums) {
            minHeap.offer(num); // Add the current number to the heap
            
            // If the heap exceeds size k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the heap is now the kth largest element
        return minHeap.peek();
    }
}
