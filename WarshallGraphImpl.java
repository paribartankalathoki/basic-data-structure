/**
 * @author:- Paribartan Kalathoki
 * @created on:- 26 Aug, 2023 at 10:41 PM
 */
public class WarshallGraphImpl {

    static int[][] transitiveClosure(int[][] graph) {
        int V = graph.length;
        int[][] closure = new int[V][V];

        // Initialize closure matrix with the same values as the input graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                closure[i][j] = graph[i][j];
            }
        }

        // Compute transitive closure
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    closure[i][j] = closure[i][j] | (closure[i][k] & closure[k][j]);
                }
            }
        }

        return closure;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        int[][] closure = transitiveClosure(graph);

        System.out.println("Transitive Closure Matrix:");
        for (int i = 0; i < closure.length; i++) {
            for (int j = 0; j < closure.length; j++) {
                System.out.print(closure[i][j] + " ");
            }
            System.out.println();
        }
    }

}
