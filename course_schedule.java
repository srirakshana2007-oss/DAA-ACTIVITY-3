//https://leetcode.com/problems/course-schedule/submissions/2168430889/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];

        for (int[] p : prerequisites)
            graph[p[1]][p[0]] = 1;

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited))
                return false;
        }

        return true;
    }

    boolean hasCycle(int course, int[][] graph, int[] visited) {
        if (visited[course] == 1)
            return true;

        if (visited[course] == 2)
            return false;

        visited[course] = 1;

        for (int i = 0; i < graph.length; i++) {
            if (graph[course][i] == 1) {
                if (hasCycle(i, graph, visited))
                    return true;
            }
        }

        visited[course] = 2;
        return false;
    }
}
