package com.example.algebraalgorithm.graph;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class Kraskal {

        @RequiresApi(api = Build.VERSION_CODES.N)
        public static Edge[] find(int[][] graph) {
            final Edge[] mst = new Edge[graph.length - 1];
            int mstIndex = 0;

            final UnionFind uf = new UnionFind(graph.length);

            final Edge[] edges = getEdges(graph);
            Array.sort(edges);

            for (final Edge edge : edges) {
                final int u = edge.getSrc();
                final int v = edge.getDst();

                if (uf.find(u) != uf.find(v)) {
                    mst[mstIndex++] = edge;
                    if (mstIndex == mst.length) {
                        return mst;
                    }
                    uf.union(u, v);
                }
            }

            return mst;
        }


        private static Edge[] getEdges(int[][] graph) {
            final List<Edge> edgeList = new ArrayList<>();

            int delta = 1;
            for (int i = 0; i < graph.length - 1; i++) {
                for (int j = delta; j < graph[i].length; j++) {
                    if (graph[i][j] != 0) {
                        edgeList.add(new Edge(i, j, graph[i][j]));
                    }
                }
                delta++;
            }

            return edgeList.toArray(new Edge[edgeList.size()]);
        }

    }
