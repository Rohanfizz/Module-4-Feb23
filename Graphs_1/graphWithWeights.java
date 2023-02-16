import java.util.*;

class graphWithWeights {

  public static class Edge {

    int nbr;
    int wt;

    Edge(int n, int w) {
      this.nbr = n;
      this.wt = w;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int e = scn.nextInt();

    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<Edge>());
    }
    //taking input for edges
    for (int i = 0; i < e; i++) {
      int u = scn.nextInt();
      int v = scn.nextInt();
      int wt = scn.nextInt();
      //undirected graph
      graph.get(u).add(new Edge(v, wt));
      graph.get(v).add(new Edge(u, wt));
    }

    for (int i = 0; i < n; i++) {
      System.out.print(i + ": (");
      for (Edge edge : graph.get(i)) {
        System.out.print("[ " + edge.nbr + "," + edge.wt + "], ");
      }
      System.out.println(")");
    }
    scn.close();
  }
}
