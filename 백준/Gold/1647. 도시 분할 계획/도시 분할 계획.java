import java.util.*;
import java.io.*;

public class Main{
  static int N;
  static int[] parent;

  static class Edge implements Comparable<Edge> {
    int first, second, value;

    Edge(int first, int second, int value) {
      this.first = first;
      this.second = second;
      this.value = value;
    }

    @Override
    public int compareTo(Edge edge) {
      return this.value - edge.value;
    }
  }
  
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    PriorityQueue<Edge> pq = new PriorityQueue<>();

    if(M == 1) {
      bw.write("0");
      bw.flush();
      return;
    }

    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      pq.offer(new Edge(first, second, value));
    }
    
    int count = 0;
    int sum = 0;
    parent = new int[N+1];

    for(int i=1; i<=N; i++) {
      parent[i] = i;
    }
    
    while(!pq.isEmpty()) {
      Edge edge = pq.poll();

      if(find(edge.first) != find(edge.second)) {
        union(edge.first, edge.second);
        count++;
        sum += edge.value;
      }

      if(count == N-2) {
        break;
      }
    }
    bw.write(sum+"");
    bw.flush();
  }

  private static void union(int first, int second) {
    first = find(first);
    second = find(second);

    if(first > second) {
      parent[first] = second;
    } else {
      parent[second] = first;
    }
  }

  private static int find(int node) {
    if(parent[node] == node) {
      return node;
    }
    return parent[node] = find(parent[node]);
  }
}
