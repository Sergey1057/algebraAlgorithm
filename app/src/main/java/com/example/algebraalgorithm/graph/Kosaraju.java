package com.example.algebraalgorithm.graph;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Kosaraju {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int[][] kosaraju(int[][] graph) {

        final List<Integer> order = findOrder(graph);
        final boolean[] used = new boolean[order.size()];
        final List<List<Integer>> componentList = new ArrayList<>();

        for (int i = order.size() - 1; i > 0; i--) {
            if (!used[i]) {
                final List<Integer> component = new ArrayList<>();
                depthSearch(graph, order.get(i), used, component::add);
                componentList.add(component);
            }
        }

        return toArray(componentList);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static List<Integer> findOrder(int[][] graph) {
        final int[][] transposedGraph = invert(graph);
        final boolean[] used = new boolean[transposedGraph.length];
        final List<Integer> order = new ArrayList<>(graph.length);

        for (int i = 0; i < transposedGraph.length; i++) {
            if (!used[i]) {
                depthSearch(transposedGraph,
                        i,
                        used,
                        order::add);
            }
        }

        return order;
    }

    private static int[][] toArray(List<List<Integer>> list) {
        final int[][] result = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            final List<Integer> item = list.get(i);
            result[i] = new int[item.size()];
            for (int j = 0; j < item.size(); j++) {
                result[i][j] = item.get(j);
            }
        }

        return result;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void depthSearch(int[][] graph, int vertex, boolean[] used, Consumer<Integer> visitor) {
        used[vertex] = true;

        for (int adjacentVertex : graph[vertex]) {
            if (!used[adjacentVertex]) {
                depthSearch(graph, adjacentVertex, used, visitor);
            }
        }

        visitor.accept(vertex);
    }

    public static int[][] invert(int[][] graph) {
        final int[][] transposedGraph = new int[graph.length][];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                final int index = graph[i][j];
                if (transposedGraph[index] == null) {
                    transposedGraph[index] = new int[1];
                } else {
                    transposedGraph[index] = Arrays.copyOf(transposedGraph[index], transposedGraph[index].length + 1);
                }
                transposedGraph[index][transposedGraph[index].length - 1] = i;
            }
        }

        return transposedGraph;
    }
}
