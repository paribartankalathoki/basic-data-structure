/**
 * @author:- Paribartan Kalathoki
 * @created on:- 28 Aug, 2023 at 08:52 PM
 */

import java.util.*;

class Graph {
    private int V;  // Number of vertices
    private List<List<Node>> adj;  // Adjacency list

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        adj.get(v).add(new Node(u, w));  // For undirected graph
    }

    public void shortestPath(int src) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        minHeap.offer(new Node(src, 0));

        while (!minHeap.isEmpty()) {
            Node curNode = minHeap.poll();

            for (Node neighbor : adj.get(curNode.vertex)) {
                int newDist = dist[curNode.vertex] + neighbor.weight;

                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    minHeap.offer(new Node(neighbor.vertex, newDist));
                }
            }
        }

        System.out.println("Shortest distances from vertex " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    private static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

public class ShortestPathExample {
    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        int source = 0;
        graph.shortestPath(source);
    }
}
