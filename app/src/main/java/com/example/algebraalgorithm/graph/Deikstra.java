package com.example.algebraalgorithm.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deikstra {

    private final Integer[][] graph;

    private final int startVertex;

    private final float[] distance;

    private final int[] previous;

    private final boolean[] used;

    public Deikstra(Integer[][] graph, int startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;

        distance = new float[graph.length];
        Arrays.fill(distance, Float.POSITIVE_INFINITY);
        distance[startVertex] = 0f;

        previous = new int[graph.length];
        used = new boolean[graph.length];

        findShortest();
    }

    public Edge[] getPath(int destination) {
        if (destination == startVertex) {
            return new Edge[]{};
        }

        final List<Edge> path = new ArrayList<>(graph.length - 1);
        int vertex = destination;

        while (vertex != startVertex) {
            final int previous = this.previous[vertex];
            path.add(new Edge(previous, vertex, graph[previous][vertex]));
            vertex = previous;
        }

        final Edge[] result = path.toArray(new Edge[path.size()]);
        Array.reverse(result);

        return result;
    }

    private void findShortest() {
        int vertex = findNotUsedVertex();

        while (vertex != -1) {
            for (int i = 0; i < graph[vertex].length; i++) {
                final Integer neighborDistance = graph[vertex][i];
                if (neighborDistance != null) {
                    final float distance = this.distance[vertex] + neighborDistance;
                    if (distance < this.distance[i]) {
                        this.distance[i] = distance;
                        previous[i] = vertex;
                    }
                }
            }

            used[vertex] = true;
            vertex = findNotUsedVertex();
        }
    }

    private int findNotUsedVertex() {
        int minValue = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!used[i] && (minValue == -1 || distance[i] < distance[minValue])) {
                minValue = i;
            }
        }

        return minValue;
    }
}