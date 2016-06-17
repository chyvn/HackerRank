package com.Graph;

import java.util.Comparator;

/**
 * Created by v-vetula on 6/17/2016.
 */
public class GraphGenerator {
    private static final class Edge implements Comparable<Edge> {
        private int v;
        private int w;

        private Edge(int v, int w) {
            if (v < w) {
                this.v = v;
                this.w = w;
            } else {
                this.v = w;
                this.w = v;
            }
        }

        @Override
        public int compareTo(Edge that) {
            if (this.v < that.v) return -1;
            if (this.v > that.v) return 1;
            if (this.w < that.w) return -1;
            if (this.w > that.w) return 1;
            return 0;
        }
    }

    //this class can't be instantiated ?
    private GraphGenerator() {
    }

    public static Graph simple(int V, int E) {
        if (E > (long) V * (V - 1) / 2) throw new IllegalArgumentException("Too many edges");
        if (E < 0) throw new IllegalArgumentException("Too few edges");

        Graph G = new Graph(V);
        SET<Edge> set = new SET<Edge>();
        return null;
    }
}
