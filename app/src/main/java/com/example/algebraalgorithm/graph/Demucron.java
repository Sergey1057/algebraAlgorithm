package com.example.algebraalgorithm.graph;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Demucron {

    private final static int USED = -1;

    @Nullable
    public static final int[][] graph ={
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int[][] demucronSort(int[][] graph) {
        final int[] sumArray = getSumArray(graph);

        final List<List<Integer>> result = sort(graph, sumArray, new ArrayList<>());

        return toArray(result);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static List<List<Integer>> sort(int[][] graph, int[] sumArray, List<List<Integer>> levels) {
        final List<Integer> levelList = new ArrayList<>();
        int[] vector = new int[sumArray.length];

        for (int i = 0; i < sumArray.length; i++) {
            if (sumArray[i] == 0) {
                vector = sumLevels(graph[i], vector);
                levelList.add(i);
                sumArray[i] = USED;
            }
        }

        if (levelList.isEmpty()) {
            return levels;
        }

        levels.add(levelList);

        return sort(graph, subtraction(sumArray, vector), levels);
    }

    private static int[] getSumArray(int[][] graph) {
        final int[] result = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            int sum = 0;
            for (final int[] row : graph) {
                sum += row[i];
            }

            result[i] = sum;
        }

        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static int[] sumLevels(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(index -> (a[index] + b[index]))
                .toArray();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private static int[] subtraction(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(index -> a[index] -b[index])
                .toArray();
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
}
