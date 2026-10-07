import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1. Build the adjacency list and tracking array
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // prerequisites[i] = [course, prereq] -> meaning: prereq -> course
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adjList.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // 2. Queue up all courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 3. Process the queue to build the topological order
        int[] order = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;
            
            // Reduce in-degree for all neighboring dependencies
           
     
