package com.network.wavelabstest;

import java.util.Arrays;

public class Network 
{
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] row : graph) {
            Arrays.fill(row, MAX_VALUE);
        }

        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int nodeTravelTime = time[2];
            graph[source][target] = nodeTravelTime;
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, MAX_VALUE);
        distances[k] = 0;

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) 
        {
            int minDistance = -1;
            for (int j = 1; j <= n; j++) 
            {
                if (!visited[j] && (minDistance == -1 || distances[j] < distances[minDistance])) {
                    minDistance = j;
                }
            }

            visited[minDistance] = true;

            for (int j = 1; j <= n; j++) {
                if (!visited[j] && graph[minDistance][j] != MAX_VALUE) {
                    distances[j] = Math.min(distances[j], distances[minDistance] + graph[minDistance][j]);
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == MAX_VALUE) {
                return -1; // Not all nodes can receive the signal, it retuns -1
            }
            maxDistance = Math.max(maxDistance, distances[i]);
        }

        return maxDistance;
    }
    
}

