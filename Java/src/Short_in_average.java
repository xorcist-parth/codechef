/**
 * Created by Xorcist on 23-01-2017.
 */

/*
There are a lot of problems related to the shortest paths. Nevertheless, there are not much problems, related
to the shortest paths in average.
Consider a directed graph G, consisting of N nodes and M edges. Consider a walk from the node A to the node B
in this graph. The average length of this walk will be total sum of weight of its' edges divided by number of
edges. Every edge counts as many times as it appears in this path.
Now, your problem is quite simple. For the given graph and two given nodes, find out the shortest
average length of the walk between these nodes. Please note, that the length of the walk need not to
be finite, but average walk length will be.

Input

The first line of the input contains an integer T denoting the number of test cases. The description of T test
cases follows. The first line of each test case contains a pair of space-separated integers N and M denoting
the number of nodes and the number of edges in the graph. Each of the following M lines contains a triple of
space-separated integers Xi Yi Zi, denoting the arc, connecting the node Xi to the node Yi (but not
vice-versa!) having the weight of Zi. The next line contains a pair of space separated integers A and B,
denoting the first and the last node of the path.

Output

For each test case, output a single line containing the length of the shortest path in average. If there is no
path at all, output just -1 on the corresponding line of the output.

Constraints

        1 ≤ N ≤ 500
        1 ≤ M ≤ 1000
        A is not equal to B
        1 ≤ A, B, Xi, Yi ≤ N
        1 ≤ Zi ≤ 100
        There are no self-loops and multiple edges in the graph.
        1 ≤ sum of N over all test cases ≤ 10000
        1 ≤ sum of M over all test cases ≤ 20000

Subtasks

Subtask #1 (45 points): 1 ≤ N ≤ 10, 1 ≤ M ≤ 20; Your answer will be considered correct in case it has an
absolute or relative error of no more than 10-2. Subtask #2 (55 points): no additional constraints; Your
answer will be considered correct in case it has an absolute or relative error of no more than 10-6.

Example

Input:
        2
        3 3
        1 2 1
        2 3 2
        3 2 3
        1 3
        3 3
        1 2 10
        2 3 1
        3 2 1
        1 3

Output:
        1.5
        1.0
Explanation

Example case 1. The walk 1 -> 2 and 2 -> 3 has average length of 3/2 = 1.5. Any other walks in the graph
will have more or equal average length than this.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Short_in_average {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int t = 0; t < T; t++) {
            int N = input.nextInt();
            int M = input.nextInt();
            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
            for (int m = 0; m < M; m++) {
                Integer x = input.nextInt();
                Integer y = input.nextInt();
                Integer z = input.nextInt();
                addNodeToGraph(graph, x, y, z);
                addNodeToGraph(graph, y, x, z);
            }
            //TODO solve the problem
        }
    }

    private static Map<Integer, Map<Integer, Integer>> addNodeToGraph(Map<Integer, Map<Integer, Integer>> graph, Integer x, Integer y, Integer z) {
        if (graph.containsKey(x)) {
            graph.get(x).put(y, z);
        } else {
            Map<Integer, Integer> edge = new HashMap<>();
            edge.put(y, z);
            graph.put(x, edge);
        }
        return graph;
    }
}
