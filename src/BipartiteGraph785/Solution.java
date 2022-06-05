package BipartiteGraph785;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    var result = isBipartite(graph);

  }

  public static boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] mark = new int[n];
    for (int i = 0; i < n; i++) {
      if (mark[i] == 0) {
        if (!dfs(graph, mark, i, -1)) {
          return false;
        }
      }
    }
    return true;

  }

  private static boolean dfs(int[][] graph, int[] mark, int root, int sign) {
    if (mark[root] == -sign) {
      return false;
    }
    if (mark[root] == sign) {
      return true;
    }
    mark[root] = sign;
    for (int next : graph[root]) {
      if (!dfs(graph, mark, next, -sign)) {
        return false;
      }
    }
    return true;
  }

}
